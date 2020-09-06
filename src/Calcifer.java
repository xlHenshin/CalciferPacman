import processing.core.PApplet;
import processing.core.PImage;

public class Calcifer extends Characters {
	
	PApplet app;
	PImage calcifer;
	
	int lives =3;
	int aspect;

	public Calcifer(int posx, int posy, PApplet app) {
		super(posx, posy);
		this.app = app;
		calcifer=app.loadImage("./Resources/calcifer.png");
		
		app.image(calcifer , getPosX(), getPosY());

	}
	
	protected void eatCalcifer() {

	}

	@Override
	protected void paint() {
		// TODO Auto-generated method stub
		
	}

}
