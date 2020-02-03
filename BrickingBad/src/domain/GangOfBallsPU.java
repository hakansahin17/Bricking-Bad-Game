package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class GangOfBallsPU extends GameObject implements PowerUp{
	
	boolean collected = false;
	public GangOfBallsPU() {
		this.id = ID.GangOfBallsPU;
	}
	

	@Override
	public ID getID() {
		// TODO Auto-generated method stub
		return ID.GangOfBallsPU;
	}

	@Override
	public void activatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activateBall(Ball b) {
		// TODO Auto-generated method stub
		b.setGang(true);
		
	}

	@Override
	public void deactivatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateBall(Ball b) {
		// TODO Auto-generated method stub
		b.setGang(false);
		
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