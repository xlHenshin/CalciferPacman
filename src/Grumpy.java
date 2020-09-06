import processing.core.PApplet;
import processing.core.PImage;

public class Grumpy extends Raindrops {

	PApplet app;
	PImage grumpy;
	
	
	public Grumpy(int posx, int posy, PApplet app) {
		super(posx, posy, app);
		this.app=app;
		
		grumpy=app.loadImage("./Resources/Grumpy.png");
		app.image(grumpy, getPosX(), getPosY());
		
		
		// TODO Auto-generated constructor stub
		
	}

}
