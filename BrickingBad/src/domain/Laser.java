package domain;

import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class Laser extends GameObject{
	
	private boolean isLaunched = false;
	private boolean isAlive = false; // bi tanesi firlatilmisken ikinciyi firlatmayi engelliyor obur turlu ikinciyi firlattiginda birinciyi kesiyor
	private boolean hitHalfMetal = false;
	
	// id'ye gore collision
	public Laser() {
		this.setId(ID.Laser);
		this.setVelY(0);
		this.setX(-10);
	}
	
	public boolean isLaunched() {
		return isLaunched;
	}
	
	public void setLaunched(boolean isLaunched) {
		this.isLaunched = isLaunched;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(isLaunched && y > - 10) {
			y -= 10;
			isAlive= true;
		}
		if(y < 0) {
			isAlive = false;
		}
		
		if(!isLaunched) {
			this.setY(Game.HEIGHT - 100);
		}
		
		if(hitHalfMetal) {
			this.setY(-10);
		}
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	public boolean isHitHalfMetal() {
		return hitHalfMetal;
	}

	public void setHitHalfMetal(boolean hitHalfMetal) {
		this.hitHalfMetal = hitHalfMetal;
	}

	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		return null;
	}
}