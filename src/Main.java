import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{

	public Calcifer player;
	PImage bg;
	
	
	
	public boolean movR;
	public boolean movL;
	public boolean movU;
	public boolean movD;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	
	int [] [] maze = {
      // 1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28
		
		{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //1
		{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, //2
		{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //3
		{0, 2, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 2, 0 }, //4
		{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //5
		{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, //6
		{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //7
		{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //8
		{0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0 }, //9
		{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, //10
		{1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1 }, //11
		{1, 1, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1 }, //12
		
	}
	

	public void settings() {
		size(600, 720);
	}

	public void setup() {
		player = new Calcifer(290, 540, 3, this);
		bg = loadImage("./Resources/maze.png");
	}

	public void draw() {
		//background (0);
		
		image(bg,0,0);
		
		player.paint();
		
		if (movR==true){

			player.moveRight();
		}

		if (movL==true){

			player.moveLeft();
		}
		
		if (movU==true){

			player.moveUp();
		}

		if (movD==true){

			player.moveDown();
		}
	}

	public void mousePressed() {

	}

	public void keyPressed() {
		   if(keyCode == RIGHT) {
	            movR = true;
	        }
	        if(keyCode == LEFT) {
	            movL = true;
	        }
	        if(keyCode == DOWN) {
	            movD = true;
	        }
	        if(keyCode == UP) {
	            movU = true;
	        }
	}

	public void keyReleased() {
		 if(keyCode == RIGHT) {
	            movR = false;
	        }
	        if(keyCode == LEFT) {
	            movL = false;
	        }
	        if(keyCode == DOWN) {
	            movD = false;
	        }
	        if(keyCode == UP) {
	            movU = false;
	        }
	}



}
