import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{

	public Screens screens;
	public Calcifer player;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}
	
	public boolean movR;
	public boolean movL;
	public boolean movU;
	public boolean movD;

	int [][] maze;
	int col, row;	
	int matX , matY;
	int screen;

	public void settings() {
		size(616, 728);
	}

	public void setup() {
		player = new Calcifer(290, 540, 5, this);
		screens = new Screens(this);

		col=28;
		row= 33;
		screen=1;
		maze = new int [][] {
				// 1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28

				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //1
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //1
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
				{1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 }, //12
				{1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 }, //13
				{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, //14
				{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, //15
				{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, //16
				{1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 }, //17
				{1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 }, //18
				{1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1 }, //19
				{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, //20
				{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, //21
				{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //22
				{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //23
				{0, 2, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 2, 0 }, //24
				{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0 }, //25
				{0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0 }, //26
				{0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0 }, //27
				{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, //28
				{0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0 }, //29
				{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, //30
				{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //31
						
		};


	}

	public void draw() {
		background (0);


		
		
		

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				if(maze[j][i] == 0) {
					fill(255);
				}else if (maze[j][i] == 1) {
					fill(0);
				}else {
					fill(255,0,0);
				}
				
				rect( (i*22),(j*22),22,22);
			}
			
			switch (screen) {
			case 1:
				screens.screen1();
				break;
				
			case 2:
				screens.screen2();
				break;

			case 3:
				screens.screen3();
				break;
				
			case 4:
				screens.maze();
				break;
			}
			
			
		}

		
		
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

		PApplet.println(mouseX);
		PApplet.println(mouseY);
		
		switch (screen) {
		case 1:
			if (mouseX > 227 && mouseX < 277 + 163
				&& mouseY > 496 && mouseY < 496 + 38 )	// Play
				screen = 2;
			
			if (mouseX > 227 && mouseX < 277 + 163
				&& mouseY > 558 && mouseY < 558 +40)  // Score
				screen = 3;
			
			if (mouseX > 227 && mouseX < 277 + 163
				&& mouseY >  624 && mouseY< 624 + 39) //Exit
				exit (); 
			
			break;
			
		case 2:
			if (mouseX > 227 && mouseX < 277 + 163
				&& mouseY > 482 && mouseY < 482 + 40 )	// Continue
				screen = 4;
			
			if (mouseX > 477 && mouseX < 477 + 87
				&& mouseY > 14 && mouseY < 14 +25)  // Go back to Menu
				screen = 1;
			
			break;
			
		case 3:
			if (mouseX > 477 && mouseX < 477 + 87
				&& mouseY > 14 && mouseY < 14 +25)  // Go back to Menu
				screen = 1;
			
			break;
			
		case 4:
			if (mouseX > 477 && mouseX < 477 + 87
				&& mouseY > 14 && mouseY < 14 +25)  // Go back to Menu
				screen = 1;
			
			break;
		}
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
