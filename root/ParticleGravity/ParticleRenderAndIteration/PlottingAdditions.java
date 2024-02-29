package ParticleGravity.ParticleRenderAndIteration;

import ParticleGravity.ImageOutPut.Color;
import ParticleGravity.ImageOutPut.Screen;
import ParticleGravity.Vector.vec2;

public class PlottingAdditions {
    public static void drawCircle(vec2 pos, int radius, Screen scrn, Color col){
        if(radius<2){
            scrn.setPixel((int)(pos.x()), (int)(pos.y()), col);
        }
        else {
            for (int i = -radius; i < radius; i++) {
                for (int j = -radius; j < radius; j++) {
                    if (Math.sqrt(i * i + j * j) < radius) scrn.setPixel((int) (pos.x() + j), (int) (pos.y() + i), col);
                }
            }
        }
    }
    public static void drawLine(vec2 pnt1, vec2 pnt2, Screen scrn, Color col){
        double xDif=pnt2.x()-pnt1.x();
        double yDif=pnt2.y()-pnt1.y();
        double len= Math.sqrt(xDif*xDif+yDif*yDif);
        double xStep=xDif/len;
        double yStep=yDif/len;
        double ax=pnt1.x();
        double ay=pnt1.y();
        for(int i=0;i<len;i++){
            scrn.setPixel((int)ax, (int)ay, col);
            ax+=xStep;
            ay+=yStep;
        }
    }
}
