
import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

public class Main extends PApplet{


	PImage dot;
	
	public Screens screens;
	public Calcifer player;
	public Blinky blinky;
	public Glutton glutton;
	public Grumpy grumpy;
	public Saddie saddie;

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
	int seg, min;
	boolean time;

	public void settings() {
		size(616, 728);
	}



	public void setup() {

		screens = new Screens(this);

		//Columns and rows of the matrix
		col=28;
		row= 33;
		
		//Variable to change the screen
		screen=1;

		//Calcifer's position on canvas and matrix
		posX=22; 
		posY=60;
		matX=1;
		matY=3;
		
		//Variables for timer
		min=0;
		seg=0;
		time=false;
		
		//Position of Raindrops
		blinky = new Blinky(250, 345 , this);
		glutton = new Glutton(280, 345, this);
		grumpy = new Grumpy(310, 345, this);
		saddie = new Saddie(340, 345, this);
		
		//Dot's PNG
		dot=loadImage("./Resources/dot.png");

		
		maze = new int [][] {
			//1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28

			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //empty space
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, //empty space
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

		
		//Paint the matrix structure
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

		
		//Switch to change the screen
		switch (screen) {
		case 1:
			
			//Main menu
			screens.screen1();
			break;

		case 2:
			
			//Name screen
			screens.screen2();
			break;

		case 3:
			
			//Score screen
			screens.screen3();
			break;

		case 4:
			
			//Game screen
			screens.maze();
			
			//Score counter
			text("SCORE: "+ score,20, 40);
			textSize(20);
			
			//Print dots in the maze
			for (int i = 0; i<28; i++) {
                for (int j = 0; j<33; j++) { 
                    if (maze[j][i] == 1) { 
                        image(dot,i*22+6,j*22+8);
                    }
                }
            }
	            	
			
			
			//Print characters
			player= new Calcifer(posX, posY,this);
			blinky.paint();
			glutton.paint();
			grumpy.paint();
			saddie.paint();
			
			
			//Timer: when time variable is true, timer will be enabled until the player gets max score
			time=true;
			
			if (score == 26700) {
            	time=false;
            	text("YOU WON", 320, 40);
            	
			}
			
			if (time==true) {
			
				if (frameCount % 60 == 0) {
					seg += 1;
				}
				if (seg == 60) {
					seg = 0;
					min += 1;
				}
			}
			
			//Show timer in the screen
			text("TIME: "+ min + ":" + seg, 180, 40);
			
			break;
		}
		
	}
	
	//Method to use mouse
	public void mousePressed() {

		//Get mouse coordinates
		PApplet.println(mouseX);
		PApplet.println(mouseY);
		
		
		//Each case is a screen in the game. Each if is a button conditional
		//If player clicks a button in the screen, it will be taken to another screen
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

	//Method to use arrow keys. When an arrow key is pressed, it will move Calcifer in the CANVAS and in the Matrix
	//Walls in matrix are represented with number 0, dots with 1 and empty spaces with 2
	//Score variable will change when Calcifer is in the position of a dot
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
