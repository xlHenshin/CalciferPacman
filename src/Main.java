
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{


	PImage dot;
	
	
	public Screens screens;
	public Calcifer player;
	public Blinky blinky;
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PApplet.main("Main");
	}

	int [][] maze;
	int col, row;	
	int matX , matY;
	int screen;
	int score;
	boolean dots=false;
	int posX, posY;
	int posobjectX, posobjectY;
	int matobjectX, matobjectY;
	ArrayList<String> tName;

	public void settings() {
		size(616, 728);
	}



	public void setup() {

		screens = new Screens(this);

		col=28;
		row= 33;
		screen=1;

		posX=22;
		posY=60;
		matX=1;
		matY=3;
		
		dot=loadImage("./Resources/dot.png");

		tName= new ArrayList<String>();

		maze = new int [][] {
			//1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28

			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //1
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //1
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //1
			{0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, //2
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //3
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //4
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //5
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, //6
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //7
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //8
			{0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0 }, //9
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, //10
			{2, 2, 2, 2, 2, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 2, 2, 2, 2, 2 }, //11
			{2, 2, 2, 2, 2, 0, 1, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 1, 0, 2, 2, 2, 2, 2 }, //12
			{2, 2, 2, 2, 2, 0, 1, 0, 0, 2, 0, 0, 0, 2, 2, 0, 0, 0, 2, 0, 0, 1, 0, 2, 2, 2, 2, 2 }, //13
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 2, 2, 2, 2, 2, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, //14
			{3, 1, 1, 1, 1, 1, 1, 1, 1, 2, 0, 2, 2, 2, 2, 2, 2, 0, 2, 1, 1, 1, 1, 1, 1, 1, 1, 3 }, //15
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 2, 2, 2, 2, 2, 0, 2, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, //16
			{2, 2, 2, 2, 2, 0, 1, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 2, 0, 0, 1, 0, 2, 2, 2, 2, 2 }, //17
			{2, 2, 2, 2, 2, 0, 1, 0, 0, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 0, 0, 1, 0, 2, 2, 2, 2, 2 }, //18
			{2, 2, 2, 2, 2, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 2, 2, 2, 2, 2 }, //19
			{0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0 }, //20
			{0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0 }, //21
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //22
			{0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0 }, //23
			{0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0 }, //24
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
				}else if (maze[j][i] == 2){
					fill(0,255,0);
				}else if (maze[j][i] == 3){
					fill(255,0,0);
				}else if (maze[j][i] == 4){
					fill(0,0,255);
				}	

				rect( (i*22),(j*22),22,22);
			}

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
			text("SCORE: "+ score,80, 40);
			textSize(20);
			for (int i = 0; i<28; i++) {
                for (int j = 0; j<33; j++) { 
                    if (maze[j][i] == 1) { 
                        image(dot,i*22+6,j*22+8);
                    }
                }
            }
			
			player= new Calcifer(posX, posY,this);
			
			
			break;
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

		switch (keyCode) {
		case RIGHT:
			if(maze[matY][matX+1]!=0) {
				posX += 22;
				matX++; 
			}
			
			if(maze[matY][matX]==1) {
				dots=true;
				score+=100;
			}
			maze[matY][matX] = 2;
			
			if (maze[matY][matX]==2) {
				dots = false;
			}
			
			break;
		case LEFT:
			if(maze[matY][matX-1]!=0) {
				posX -= 22;
				matX--;
			}
			
			if(maze[matY][matX]==1) {
				dots=true;
				score+=100;
			}
			maze[matY][matX] = 2;
			
			if (maze[matY][matX]==2) {
				dots = false;
			}
			break;
		case UP:
			if(maze[matY-1][matX]!=0) {
				posY -= 22;
				matY--;
			}
			
			if(maze[matY][matX]==1) {
				dots=true;
				score+=100;
			}
			maze[matY][matX] = 2;
			
			if (maze[matY][matX]==2) {
				dots = false;
			}
			break;
		case DOWN:
			if(maze[matY+1][matX]!=0) {
				posY += 22;
				matY++;
			}
			
			if(maze[matY][matX]==1) {
				dots=true;
				score+=100;
			}
			maze[matY][matX] = 2;
			
			if (maze[matY][matX]==2) {
				dots = false;
			}
			break;
		default:
			break;
		}

	}
}
