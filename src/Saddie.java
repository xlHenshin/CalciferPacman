import processing.core.PApplet;
import processing.core.PImage;

public class Saddie extends Raindrops {
	
	PApplet app;
	PImage saddie;
	
	public Saddie(int posx, int posy, PApplet app) {
		super(posx, posy, app);
		this.app=app;
		
		saddie=app.loadImage("./Resources/Saddie.png");
		
	}
	
	protected void paint () {
		app.image(saddie, getPosX(), getPosY());
	}

}
