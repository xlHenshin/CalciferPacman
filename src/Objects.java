
public abstract class Objects {
	
	private int positionX;
	private int positionY;
	private int points;
	private boolean power;
	private int time;
	
	public Objects(int posx, int posy) {
		// TODO Auto-generated constructor stub
		this.positionX = posx;
		this.positionY = posy;
	}

	protected abstract void paintObject();

	
	
	
	public int getPositionX() {
		return positionX;
	}

	public void setPositionX(int positionX) {
		this.positionX = positionX;
	}

	public int getPositionY() {
		return positionY;
	}

	public void setPositionY(int positionY) {
		this.positionY = positionY;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public boolean isPower() {
		return power;
	}

	public void setPower(boolean power) {
		this.power = power;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	
	

}
