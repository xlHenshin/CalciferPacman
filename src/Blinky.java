import processing.core.PApplet;
import processing.core.PImage;

public class Blinky extends Raindrops {
	
	PApplet app;
	PImage blinky;
	
	public Blinky(int posx, int posy, PApplet app) {
		super(posx, posy, app);
		this.app=app;
		
		blinky=app.loadImage("./Resources/Blinky.png");
		app.image(blinky, getPosX(), getPosY());
	}

}
