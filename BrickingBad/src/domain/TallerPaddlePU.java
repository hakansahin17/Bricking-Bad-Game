package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;
@SuppressWarnings("serial")
public class TallerPaddlePU extends GameObject implements PowerUp{
	
	boolean collected = false;
	public TallerPaddlePU() {
		this.id = ID.TallPaddlePU;
		
	}

	@Override
	public ID getID() {
		return ID.TallPaddlePU;
	}

	@Override
	public void activatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		p.setTall(true);
		p.setX(p.getX() - Game.WIDTH / 20);
		p.setX1(p.getX1() + Game.WIDTH / 20);
		p.setX2(p.getX2() - Game.WIDTH / 20);
		p.setX3(p.getX3() + Game.WIDTH / 20);
		p.setLength(p.getX1() - p.getX());
	}

	@Override
	public void activateBall(Ball b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		p.setTall(false);
		p.setX(p.getX() + Game.WIDTH / 20);
		p.setX1(p.getX1() - Game.WIDTH / 20);
		p.setX2(p.getX2() + Game.WIDTH / 20);
		p.setX3(p.getX3() - Game.WIDTH / 20);
		p.setLength(p.getX1() - p.getX());
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