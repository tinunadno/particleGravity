package ParticleGravity.ParticleRenderAndIteration;

import java.util.ArrayList;

public class Scene {
    private static ArrayList<Particle> currentParticles=new ArrayList<>();
    public static void addParticle(Particle particle) {
        currentParticles.add(particle);
    }
    public static Particle getParticle(int index){
        return currentParticles.get(index);
    }
    public static void killParticle(Particle partcle){
        currentParticles.remove(partcle);
    }

    public static int getSize(){return currentParticles.size();}
}
