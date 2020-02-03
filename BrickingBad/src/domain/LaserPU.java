package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;
@SuppressWarnings("serial")
public class LaserPU extends GameObject implements PowerUp{
	
	private Laser leftLaser = new Laser();
	private Laser rightLaser = new Laser();
	private int shotsCount = 5; // 5 per each power-up
	boolean collected = false;
	public LaserPU() {
		this.id = ID.LaserPU;
	}
	
	//can destroy full column of blocks. 
	//if it hits a metal side of a brick it will not have any effect.

	public ID getID() {
		// TODO Auto-generated method stub
		return ID.LaserPU;
	}

	public void activatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		this.leftLaser.setX(p.getX());
		this.leftLaser.setY(p.getY());
		this.rightLaser.setX(p.getX1());
		this.rightLaser.setY(p.getY1());
		this.leftLaser.setLaunched(true);
		this.rightLaser.setLaunched(true);
		this.shotsCount -= 1;
		p.setLaser(true);
		
		// gui paddle'da iki yani da farkli renk yapsin
		
	}

	public void activateBall(Ball b) {
		// TODO Auto-generated method stub
		
	}

	public void deactivatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		p.setLaser(false);
		this.leftLaser.setLaunched(false);
		this.rightLaser.setLaunched(false);
		Game.getGame().getGC().removeObject(Game.getGame().getLaserpu().getLeftLaser());
		Game.getGame().getGC().removeObject(Game.getGame().getLaserpu().getRightLaser());
	}

	public void deactivateBall(Ball b) {
		// TODO Auto-generated method stub
		
	}
	
	public int getShotsCount() {
		return shotsCount;
	}

	public void setShotsCount(int shotsCount) {
		this.shotsCount = shotsCount;
	}

	public Laser getLeftLaser() {
		return leftLaser;
	}

	public void setLeftLaser(Laser leftLaser) {
		this.leftLaser = leftLaser;
	}

	public Laser getRightLaser() {
		return rightLaser;
	}

	public void setRightLaser(Laser rightLaser) {
		this.rightLaser = rightLaser;
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