import processing.core.PApplet;
import processing.core.PImage;

public class Calcifer extends Characters {
	
	PApplet app;
	PImage calcifer;
	
	int lives =3;
	int aspect;

	public Calcifer(int posx, int posy,int speed, PApplet app) {
		super(posx, posy, speed);
		this.app = app;
		calcifer=app.loadImage("./Resources/calcifer.png");
		

	}
	
	protected void paint() {
		// TODO Auto-generated method stub
		app.image(calcifer ,getPosX(),getPosY());	
	}

	public void moveLeft() {
		posX -= speed;
		if(posX <= 0){
			posX += speed;
		}
	}

	public void moveRight() {
		posX += speed;
		if(posX >= 600){
			posX -= speed;
		}
	}

	public void moveUp() {
		posY += speed;
		if(posY >= 0){
			posY -= speed;
		}
	}

	public void moveDown() {
		posY -= speed;
		if(posY <= 720){
			posY += speed;
		}
	}

	//=========================================================



	protected void eatCalcifer() {

	}



}
