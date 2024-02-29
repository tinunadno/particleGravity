package ParticleGravity.ParticleRenderAndIteration;

public class ParticleAnimate {
    public static void startAnimation(){
        while(true){
            ParticlePlot.plot();
            Iteration.iterate();
        }
    }
}
