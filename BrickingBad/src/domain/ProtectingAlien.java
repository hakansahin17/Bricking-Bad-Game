package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class ProtectingAlien extends Alien {

	public ProtectingAlien() {
		this.id = ID.ProtectingAlien;
	}
	public Shape getBounds() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(Game.WIDTH / 50, 20);
		rect.setLocation((int) x, (int)y);
		return rect;
	}
	
	public void update() {
		x +=5;
		move();
	
		
		
	}
	
	public void move() {
		if(x>Game.WIDTH-50) {
			x = 0;
		}
	}
}
