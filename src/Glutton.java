import processing.core.PApplet;
import processing.core.PImage;

public class Glutton extends Raindrops {

	PApplet app;
	PImage glutton;
	
	public Glutton(int posx, int posy, PApplet app) {
		super(posx, posy, app);
		this.app=app;
		
		glutton=app.loadImage("./Resources/Glutton.png");
		
	}
	
	protected void paint () {
		app.image(glutton, getPosX(), getPosY());
	}


}
