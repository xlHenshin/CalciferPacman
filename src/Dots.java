import processing.core.PApplet;
import processing.core.PImage;

public class Dots extends Objects {
	
	PApplet app;
	PImage dot;
	
	public Dots(int posx, int posy, PApplet app) {
		super(posx, posy);
		this.app = app;
		// TODO Auto-generated constructor stub
	}
	
	public void paintObject() {
		app.fill(255,246,53);
		app.ellipse(getPositionX(),getPositionY(),8,8);
	}
	
}
