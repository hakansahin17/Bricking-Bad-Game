package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class MagnetPU extends GameObject implements PowerUp{
	
	boolean collected = false;
	public MagnetPU() {
		this.id = ID.MagnetPU;
	}

	@Override
	public ID getID() {
		return ID.MagnetPU;
	}

	@Override
	public void activatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		p.setMagnet(true);
	}

	@Override
	public void activateBall(Ball b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		p.setMagnet(false);
	}

	@Override
	public void deactivateBall(Ball b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		y += 10;
		
	}
	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub , 
		Rectangle rect = new Rectangle(Game.WIDTH / 80, 50);
		rect.setLocation((int) x, (int)y);
		return rect;
	}
	
	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}
	
}