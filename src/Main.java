import processing.core.PApplet;

public class Main extends PApplet{

	public Calcifer player;
	public boolean movR;
	public boolean movL;
	public boolean movU;
	public boolean movD;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}

	public void settings() {
		size(600, 720);
	}

	public void setup() {
		player = new Calcifer(300, 300, 5, this);
	}

	public void draw() {
		background (0);
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
