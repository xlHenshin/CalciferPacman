
public abstract class Characters {

	protected int posX;
	protected int posY;
	//private int dirX;
	//private int dirY;
	protected int speed;

	public Characters(int posx, int posy, int speed) {

		this.posX = posx;
		this.posY = posy;
		
		this.speed = speed;
	}

	protected abstract void paint();

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}



}
