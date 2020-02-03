package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class HalfMetalBrick extends Brick {
	
	public HalfMetalBrick() {
		this.setLength(Game.WIDTH/50);
		this.setHeight(20);
		this.setId(ID.HalfMetalBrick);

	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(getLength(), getHeight() / 2);
		rect.setLocation((int) x, (int)y);
		return rect;
	}
	
	public Shape metalBounds() {
		Rectangle rect = new Rectangle(getLength(), getHeight() / 2);
		rect.setLocation((int) x, ((int) y) + getHeight() / 2);
		return rect;
	}
}
