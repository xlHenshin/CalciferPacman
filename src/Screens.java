import processing.core.PApplet;
import processing.core.PImage;

public class Screens {


	PApplet app;
	PImage screen1;
	PImage screen2;
	PImage screen3;
	PImage maze;
	
	public Screens (PApplet app) {
		
		this.app = app;
		
		screen1=app.loadImage("./Resources/screen1.png");
		screen2=app.loadImage("./Resources/screen2.png");
		screen3=app.loadImage("./Resources/screen3.png");
		maze=app.loadImage("./Resources/maze.png");
		
	}
	

	public void screen1(){

		app.image (screen1, 0, 0);
		

	}

	public void screen2(){

		app.image (screen2, 0, 0);

	}


	public void screen3(){

		app.image (screen3, 0, 0);
	}
	
	public void maze() {
		
		app.image (maze, 0, 0);
		
	}

}
