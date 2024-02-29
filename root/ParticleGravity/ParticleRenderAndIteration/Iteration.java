package ParticleGravity.ParticleRenderAndIteration;

import ParticleGravity.Vector.vec2;

public class Iteration {
    public static void iterate(){
        for(int i=0;i<Scene.getSize();i++){
            for(int j=0;j<Scene.getSize();j++){
                if(i!=j){
                    Particle changable=Scene.getParticle(i);
                    Particle influencer=Scene.getParticle(j);
                    double distance=(influencer.getPosition()).sub(changable.getPosition()).length();
                    vec2 gravityVector=(influencer.getPosition().sub(changable.getPosition()))
                            .normalize().mult(influencer.getMass()/(distance*distance));
                    changable.setSpeed(changable.getSpeed().add(gravityVector));

                }

            }
        }
        for(int i=0;i<Scene.getSize();i++){
            Particle part=Scene.getParticle(i);
            part.setPosition(part.getPosition().add(part.getSpeed()));
        }
    }
}
