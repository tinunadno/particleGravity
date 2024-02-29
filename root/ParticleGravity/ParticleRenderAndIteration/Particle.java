package ParticleGravity.ParticleRenderAndIteration;

import ParticleGravity.ImageOutPut.Color;
import ParticleGravity.Vector.vec2;

public class Particle {
    private vec2 position;
    private vec2 speed;
    private int size;
    private Color color;
    private  final double mass;
    public Particle(vec2 position, vec2 speed, double mass, int size, Color color){
        this.position=position;
        this.speed=speed;
        this.size=size;
        this.mass=mass;
        this.color=color;
    }

    public void setPosition(vec2 position){this.position=position;}
    public void setSpeed(vec2 speed){this.speed=speed;}
    public Color getColor(){return this.color;}
    public vec2 getPosition(){return position;}
    public vec2 getSpeed(){return speed;}
    public int getSize(){return size;}
    public double getMass(){return mass;}
    @Override
    public String toString(){
        return "["+position.x()+", "+position.y()+"]";
    }
}