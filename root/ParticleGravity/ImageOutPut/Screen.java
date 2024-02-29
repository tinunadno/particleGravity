package ParticleGravity.ImageOutPut;

import javax.swing.*;
import java.awt.image.BufferedImage;

//a class shell for comfortable work with java.BufferedImage
public class Screen {
	private JFrame frame;
	private int xSize;
	private int ySize;
	private double sidesRatio;
	private BufferedImage img;
	private boolean closeOnExit;
	public Screen(int xSize, int ySize, boolean closeOnExit){
		this.xSize=xSize;
		this.ySize=ySize;
		this.sidesRatio=xSize/ySize;
		this.closeOnExit=closeOnExit;
		frame=new JFrame();
		if(closeOnExit)
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		img = new BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_RGB);
	}
	public void setCloseOnExit(boolean val){
		if(val) frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		else frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	//update image
	public void refresh(){
		img = new BufferedImage(xSize, ySize, BufferedImage.TYPE_INT_RGB);
	}

	//convert RGB to int
	private int colorPoint(int r, int g, int b){
		return (int)(Math.max(0, Math.min(255, r)))<<16 | (int)(Math.max(0, Math.min(255, g)))<<8 | (int)(Math.max(0, Math.min(255, b)));
	}

	//set pixel
	public void setPixel(int x, int y, Color col){
		img.setRGB(Math.max(0, Math.min(xSize-1, x)), Math.max(0, Math.min(ySize-1,ySize-y-1)), colorPoint(col.getR(), col.getG(), col.getB()));
	}
	public void setPixel(int x, int y, int col){
		img.setRGB(Math.max(0, Math.min(xSize-1, x)), Math.max(0, Math.min(ySize-1,ySize-y-1)), colorPoint(col,col,col));
	}
	//show image
	public void show(){
		frame.getContentPane().removeAll();
		frame.repaint();
		frame.getContentPane().add(new JLabel(new ImageIcon(img)));
		frame.pack();
		frame.repaint();
		frame.setVisible(true);
	}

	public double getRatio(){return sidesRatio;}
}