package ParticleGravity.ImageOutPut;

public class Color {
    private int r;
    private int g;
    private int b;
    public Color(int r, int g, int b){
        this.r=r;
        this.g=g;
        this.b =b;
    }
    public Color(int val){
        this.r=val;
        this.g=val;
        this.b =val;
    }
    public Color(){
        this.r=(int)(Math.random()*255);
        this.g=(int)(Math.random()*255);
        this.b=(int)(Math.random()*255);
    }
    public int getR(){return r;}
    public int getG(){return g;}
    public int getB(){return b;}

    public void setR(int r){this.r=r;}
    public void setG(int g){this.g=g;}
    public void setB(int b){this.b=b;}
}
