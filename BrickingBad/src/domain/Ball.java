package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")

/**
 * OVERVIEW: This class is used for creating the ball domain object for the
 * Bricking Bad Game. It extends the GameObject Class, therefore inheriting the
 * methods of it. It also has its own fields and methods which are special to
 * the ball.
 * 
 * @author The Hackermen Team
 *
 */
public class Ball extends GameObject {
	private boolean isLaunched = false;
	private boolean isGang = false;
	private boolean isChemical = false;
	private boolean isFire = false;

	// ROTATION LAZIM TOP ATILMADAN �NCE
	/**
	 * EFFECTS: Constructs Ball Object, which is also a GameObject and sets
	 * GameObject's fields as: x = Game.WIDTH / 2 - 8, y = Game.HEIGHT - 120, ID =
	 * ID.Ball, velX = 0, velY = 0
	 */
	public Ball() {
		this.setX(Game.WIDTH / 2 - 8);
		this.setY(Game.HEIGHT - 120);
		this.setId(ID.Ball);
		this.setVelY(0);
		this.setVelX(0);
	}

	/**
	 * EFFECTS: This method returns the current state of isLaunched field when
	 * called upon.
	 * 
	 * @return isLaunched
	 */
	public boolean isLaunched() {
		return isLaunched;
	}

	/**
	 * REQUIRES: The parameter needs to be either true or false. 
	 * 
	 * MODIFIES: isLaunched
	 *  
	 * EFFECTS: This method sets the field of the ball, isLaunched.
	 *
	 * @param isLaunched It takes a boolean, which is true or false.
	 */
	public void setLaunched(boolean isLaunched) {
		this.isLaunched = isLaunched;
	}

	/**
	 * MODIFIES: GameObject's x, y, velX, velY. 
	 * 
	 * EFFECTS: This method updates the position of the ball object every time 
	 * it is called upon. If isLaunched is false, then it moves with the other  
	 * GameObject, Paddle. If it is true, it is  given an initial velocity and 
	 * moves independently.
	 */
	public void update() {
		x += velX;
		y += velY;
		if (isLaunched && x > Game.WIDTH - 17) {
			x = Game.WIDTH - 17;
			velX *= -1;
		}
		if (isLaunched && x < 0) {
			x = 0;
			velX *= -1;
		}
		if (isLaunched && y < 0) {
			y = 0;
			velY *= -1;
		}
		
		if(!isLaunched) {
			velY = 0;
		}

		if (!isLaunched && x > Game.WIDTH - Game.WIDTH / 20) {
			x = Game.WIDTH - Game.WIDTH / 20 - 9;
			
		}

		if (!isLaunched && x < Game.WIDTH / 20) {
			x = Game.WIDTH / 20 - 9;
			
		}
	}

	public boolean isGang() {
		return isGang;
	}

	public void setGang(boolean isGang) {
		this.isGang = isGang;
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

	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		Rectangle ball = new Rectangle(16, 16);
		ball.setLocation((int) x, (int)y);
		return ball;
	}
	
}