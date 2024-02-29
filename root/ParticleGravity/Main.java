package ParticleGravity;

import ParticleGravity.ImageOutPut.Color;
import ParticleGravity.ParticleRenderAndIteration.Particle;
import ParticleGravity.ParticleRenderAndIteration.ParticleAnimate;
import ParticleGravity.ParticleRenderAndIteration.ParticlePlot;
import ParticleGravity.ParticleRenderAndIteration.Scene;
import ParticleGravity.Vector.vec2;

public class Main{
    public static void main(String[] args){
        //star
        Particle part=new Particle(new vec2(0,0), new vec2(0,0),100, 10, new Color(220,200,255));
        Scene.addParticle(part);

        //planets
        for(int i=0;i<1000;i++){
            double rad=Math.random()*100;
            int clrtemp=255-(int)(rad*2.5);
            int direction=1;
            if(Math.random()>0.5)direction=-1;
            Particle part2=new Particle(new vec2(0,rad*(direction)), new vec2(direction*Math.sqrt(part.getMass()/rad),0), .00001, 1, new Color(255, clrtemp,clrtemp));
            Scene.addParticle(part2);
        }

        ParticlePlot.setScale(100);
        ParticlePlot.setSpeedVectorRender(false);
        ParticleAnimate.startAnimation();
    }
}