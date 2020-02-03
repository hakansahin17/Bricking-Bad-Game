package UI;

import java.awt.Color;
import java.awt.Graphics;


public class GUIBall extends GUIGameObject{
	
	private boolean isChemical = false;
	private boolean isFire = false;
	
	public GUIBall() {
		super();
	}

	public void render(Graphics g) {
		if(isChemical) {
			g.setColor(Color.GREEN);
		} else if (isFire){
			g.setColor(Color.YELLOW);
		} else {
			g.setColor(Color.red);
		}
		
		g.fillOval((int) getX(),(int) getY(), 17, 17);
	}

	public boolean isChemical() {
		return isChemical;
	}

	public void setChemical(boolean isChemical) {
		this.isChemical = isChemical;
	}

	public boolean isFire() {
		return isFire;
	}

	public void setFire(boolean isFire) {
		this.isFire = isFire;
	}
	
	
}