
public abstract class Characters {

	protected int posX;
	protected int posY;
	protected int speed;
	protected int matX;
	protected int matY;

	public Characters(int posx, int posy, int speed) {

		this.posX = posx;
		this.posY = posy;
		
		this.speed = speed;	
	}
	
	
	public int getMatX() {
		return matX;
	}

	public void setMatX(int matX) {
		this.matX = matX;
	}

	public int getMatY() {
		return matY;
	}

	public void setMatY(int matY) {
		this.matY = matY;
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
