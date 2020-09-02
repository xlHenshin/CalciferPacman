
public abstract class Characters {

	private int posX;
	private int posY;
	private int dirX;
	private int dirY;
	private int speed;
	
	public Characters(int posx, int posy, int dirx, int diry, int speed) {
		
		this.posX = posx;
		this.posY = posy;
		this.dirX = dirx;
		this.dirY = diry;
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

	public int getDirX() {
		return dirX;
	}

	public void setDirX(int dirX) {
		this.dirX = dirX;
	}

	public int getDirY() {
		return dirY;
	}

	public void setDirY(int dirY) {
		this.dirY = dirY;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}
	
	
	
}
