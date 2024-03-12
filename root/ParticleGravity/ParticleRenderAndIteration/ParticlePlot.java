package ParticleGravity.ParticleRenderAndIteration;

import ParticleGravity.ImageOutPut.Color;
import ParticleGravity.ImageOutPut.Screen;
import ParticleGravity.Vector.vec2;

public class ParticlePlot {
    private static final int SCREEN_X_SIZE=800;
    private static final int SCREEN_Y_SIZE=400;
    private static final int WEIGHT_MAP_RESOLUTION=5;
    private static final Screen screen=new Screen(SCREEN_X_SIZE, SCREEN_Y_SIZE, true);
    private static double[][] weightMap=new double[SCREEN_X_SIZE/WEIGHT_MAP_RESOLUTION][SCREEN_Y_SIZE/WEIGHT_MAP_RESOLUTION];
    private static double scale=100;
    private static boolean speedVectorEnabled=true;
    private static boolean weightMapEnabled=true;
    //screen y size in units
    public static void plot(){
        screen.refresh();
        if(weightMapEnabled) {
            double max = -1;
            double sum = 1;
            for (int i = 0; i < weightMap.length; i++) {
                for (int j = 0; j < weightMap[i].length; j++) {

                    if (max < weightMap[i][j] && weightMap[i][j] < sum) max = weightMap[i][j];
                    sum += max = weightMap[i][j];
                }
            }
            weightMap[0][0] = 0;
            weightMap[0][weightMap[0].length - 1] = 0;
            weightMap[weightMap.length - 1][0] = 0;
            weightMap[weightMap.length - 1][weightMap[0].length - 1] = 0;
            for (int i = 0; i < SCREEN_Y_SIZE; i++) {
                for (int j = 0; j < SCREEN_X_SIZE; j++) {
                    int value = (int) (weightMap[(int) (j / WEIGHT_MAP_RESOLUTION)][(int) (i / WEIGHT_MAP_RESOLUTION)] * 255 / max);
                    screen.setPixel(j, i, new Color(value, 0, (255 - value) / 20));
                }
            }
        }
        weightMap=new double[SCREEN_X_SIZE/WEIGHT_MAP_RESOLUTION][SCREEN_Y_SIZE/WEIGHT_MAP_RESOLUTION];
        for(int i=0;i<Scene.getSize();i++){
            vec2 screenPos=getScreneSpaceCoordinates(Scene.getParticle(i).getPosition());
            if(speedVectorEnabled)
                PlottingAdditions.drawLine(screenPos, screenPos.add(Scene.getParticle(i).getSpeed()), screen, new Color(255,0,0));
            PlottingAdditions.drawCircle(new vec2(screenPos.x(), screenPos.y()), (int)(Scene.getParticle(i).getSize()*100/scale),screen,Scene.getParticle(i).getColor());
            if(weightMapEnabled)weightMap[(int)(Math.min(Math.max(screenPos.x(), 0)/WEIGHT_MAP_RESOLUTION, weightMap.length-1))][(int)(Math.min(Math.max(screenPos.y(), 0)/WEIGHT_MAP_RESOLUTION, weightMap[0].length-1))]+=Scene.getParticle(i).getMass();
        }
        screen.show();
        try{Thread.sleep(10);}
        catch (InterruptedException e){}
    }
    private static vec2 getScreneSpaceCoordinates(vec2 cords){
        double xScreenCord=cords.x()*((SCREEN_X_SIZE/screen.getRatio())/(scale*2))+(SCREEN_X_SIZE>>1);
        double yScreenCord=cords.y()*(SCREEN_Y_SIZE/(scale*2))+(SCREEN_Y_SIZE>>1);
        return new vec2(xScreenCord, yScreenCord);
    }
    public static void setSpeedVectorRender(boolean val){speedVectorEnabled=val;}
    public static void setWeightMapRender(boolean val){weightMapEnabled=val;}
    public static void setScale(double Scale){scale=Scale;}
}
