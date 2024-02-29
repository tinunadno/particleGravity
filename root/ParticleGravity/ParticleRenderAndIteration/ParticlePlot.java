package ParticleGravity.ParticleRenderAndIteration;

import ParticleGravity.ImageOutPut.Color;
import ParticleGravity.ImageOutPut.Screen;
import ParticleGravity.Vector.vec2;

public class ParticlePlot {
    private static final int SCREEN_X_SIZE=800;
    private static final int SCREEN_Y_SIZE=400;
    private static final Screen screen=new Screen(SCREEN_X_SIZE, SCREEN_Y_SIZE, true);
    private static double scale=100;
    private static boolean speedVectorEnabled=true;
    //screen y size in units
    public static void plot(){
        screen.refresh();
        for(int i=0;i<Scene.getSize();i++){
            vec2 screenPos=getScreneSpaceCoordinates(Scene.getParticle(i).getPosition());
            if(speedVectorEnabled)
                PlottingAdditions.drawLine(screenPos, screenPos.add(Scene.getParticle(i).getSpeed()), screen, new Color(255,0,0));
            PlottingAdditions.drawCircle(new vec2(screenPos.x(), screenPos.y()), (int)(Scene.getParticle(i).getSize()*100/scale),screen,Scene.getParticle(i).getColor());

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
    public static void setScale(double Scale){scale=Scale;}
}
