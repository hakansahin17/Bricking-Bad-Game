package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class FireballPU extends GameObject implements PowerUp{

	boolean collected = false;
	public FireballPU() {
		this.id = ID.FireBallPU;
	}

	@Override
	public ID getID() {
		// TODO Auto-generated method stub
		return ID.FireBallPU;
	}

	@Override
	public void activatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activateBall(Ball b) {
		// TODO Auto-generated method stub
		b.setFire(true);
	}

	@Override
	public void deactivatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateBall(Ball b) {
		// TODO Auto-generated method stub
		b.setFire(false);
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
	
	//Can destroy the brick it hits and its neighbours. galiba grid sistemi lazim
	//If hits a metal side of a brick, the fireball can crack it, in the next hit it can destroy it. 
	
	public boolean isCollected() {
		return collected;
	}

	public void setCollected(boolean collected) {
		this.collected = collected;
	}
}