
public abstract class Characters {

	private int posX;
	private int posY;
	
	
	public Characters(int posx, int posy) {

		this.posX = posx;
		this.posY = posy;
		
	}
	

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

	
}
