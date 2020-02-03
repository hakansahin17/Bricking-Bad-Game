package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class WrapperBrick extends Brick{

	public WrapperBrick() {
		this.setLength(Game.WIDTH/50);
		this.setHeight(20);
		this.setId(ID.WrapperBrick);

	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(getLength(), getHeight());
		rect.setLocation((int) x, (int)y);
		return rect;
	}

}
