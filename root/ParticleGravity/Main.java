package ParticleGravity;

import ParticleGravity.ImageOutPut.Color;
import ParticleGravity.ParticleRenderAndIteration.Particle;
import ParticleGravity.ParticleRenderAndIteration.ParticleAnimate;
import ParticleGravity.ParticleRenderAndIteration.ParticlePlot;
import ParticleGravity.ParticleRenderAndIteration.Scene;
import ParticleGravity.Vector.vec2;

public class Main{
    public static void main(String[] args){
        //star1
        Particle part=new Particle(new vec2(-200,0), new vec2(0.01,0),100, 10, new Color(220,200,255));
        Scene.addParticle(part);


        //galaxy1
        for(int i=0;i<500;i++){
            double rad=Math.random()*100;
            int clrtemp=255-(int)(rad*2.5);
            int direction=1;
            if(Math.random()>0.5)direction=-1;
            Particle part2=new Particle(new vec2(part.getPosition().x(),rad*(direction)), new vec2(direction*Math.sqrt(part.getMass()/rad),0), .00001, 1, new Color(255, clrtemp,clrtemp));
            Scene.addParticle(part2);
        }

        //star2
        Particle part_1=new Particle(new vec2(200,0), new vec2(-.01,0),1, 10, new Color(220,200,255));
        Scene.addParticle(part_1);
        //galaxy2
        for(int i=0;i<500;i++){
            double rad=Math.random()*100;
            int clrtemp=255-(int)(rad*2.5);
            int direction=1;
            if(Math.random()>0.5)direction=-1;
            Particle part2=new Particle(new vec2(part_1.getPosition().x(),rad*(direction)), new vec2(direction*Math.sqrt(part_1.getMass()/rad),0), .00001, 1, new Color(255, clrtemp,clrtemp));
            Scene.addParticle(part2);
        }



        ParticlePlot.setScale(200);
        ParticlePlot.setSpeedVectorRender(false);
        ParticlePlot.setWeightMapRender(true);
        ParticleAnimate.startAnimation();
    }
}