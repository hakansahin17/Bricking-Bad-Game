package domain;

import java.awt.Polygon;
import java.awt.Shape;

import main.Game;
/**
 * OVERVIEW: This class is used for the most essential component of the game.
 * Paddle has 6 values; centerX and centerY is for calculating the rotation and 
 * x1,x2,y1,y2 are the corner coordinate values of the paddle. 
 * Boolean rotateLeft, and rotateRight are for turning the rotation on or off.
 * 
 * @author The Hackermen Team
 *
 */
@SuppressWarnings("serial")
public class Paddle extends GameObject{

	public double centerX, centerY;
	private boolean rotateLeft = false, rotateRight = false;
	double cos = Math.cos(Math.PI / 540), sin = Math.sin(Math.PI / 540); // 1/3 * 60 = 20 derece
	double cos45 = Math.cos(Math.PI / 240), sin45 = Math.sin(Math.PI / 240); // 1/3 * 60 = 20 derece
	double tx = x, ty = y, tx1 = x1, ty1 = y1, tx2 = x2, ty2 = y2, tx3 = x3, ty3 = y3; //temporary x/y values for rotation calculations
	double limit = Math.cos(45)*(10 + (Game.WIDTH/20)); //rotation limit
	double normX = 0, normY = -1, tempNormX = normX, tempNormY = normY; //normal vector for collision and rotations
	private boolean isMagnet = false;
	private boolean isTall = false;
	private boolean isLaser = false;
	private double length;
	
	
	public double getCenterX() {
		return centerX;
	}
	public void setCenterX(double centerX) {
		this.centerX = centerX;
	}
	public double getCenterY() {
		return centerY;
	}
	public void setCenterY(double centerY) {
		this.centerY = centerY;
	}
	/**
	 * EFFECTS: initializes the initial position of paddle
	 */
	public Paddle() {
		this.centerX = Game.WIDTH / 2;
		this.centerY = Game.HEIGHT - 90;
		this.setX(Game.WIDTH / 2 - Game.WIDTH / 20);
		this.setY(Game.HEIGHT - 100);
		this.setId(ID.Paddle);
		this.x1 = x + (Game.WIDTH / 10);
		this.y1 = Game.HEIGHT - 100;
		this.x2 = Game.WIDTH / 2 - Game.WIDTH / 20;
		this.y2 = Game.HEIGHT - 80;
		this.x3 = x + (Game.WIDTH / 10);
		this.y3 = Game.HEIGHT - 80;
		this.length = x1 - x;
	}
	/**
	 * EFFECTS: Updates the position of the paddle or rotates the paddle
	 * accordance to the user key input. Checks the bounds of the screen
	 * and blocks the paddle for getting out.
	 */
	public void update() {
		centerX += velX;
		x1 += velX;
		x2 += velX;
		x3 += velX;
		x += velX;
		checkBounds();
		tx = x; 
		ty = y;
		tx1 = x1; 
		ty1 = y1;
		tx2 = x2;
		ty2 = y2;
		tx3 = x3;
		ty3 = y3;
		tempNormX = normX;
		tempNormY = normY;
		rotate();
	}
	/**
	 * EFFECTS: Checks whether left side or right side of the paddle is 
	 * in the screen boundaries. 
	 */
	public void checkBounds() {
		if (x < 0) {
			double add = -x;
			centerX += add;
			x1 += add;
			x2 += add;
			x3 += add;
			x += add;
			return;
		} else if (x1 > Game.WIDTH) {
			double sub = x1 - Game.WIDTH;
			centerX -= sub;
			x1 -= sub;
			x2 -= sub;
			x3 -= sub;
			x -= sub;
			return;
		} else if (x2 < 0) {
			double add = -x2;
			centerX += add;
			x1 += add;
			x2 += add;
			x3 += add;
			x += add;
			return;
		} else if (x3 > Game.WIDTH) {
			double sub = x3 - Game.WIDTH;
			centerX -= sub;
			x1 -= sub;
			x2 -= sub;
			x3 -= sub;
			x -= sub;
			return;
		}
	}
	/**
	 * EFFECTS: Rotates the paddle according to the rotation way. 
	 */
	public void rotate() {
		//Rotate limitleri 45 ve 135 derecede!!!
		if (rotateLeft && y < centerY + limit) {
			rotateCCW(cos,sin);
			normX = (cos * tempNormX) + (sin * tempNormY);
			normY = (-sin * tempNormX) + (cos * tempNormY);
		} else if (rotateRight && y2 > centerY - limit) {
			rotateCW(cos,sin);
			normX = (cos * tempNormX) - (sin * tempNormY);
			normY = (sin * tempNormX) + (cos * tempNormY);
		} else {
			if(y - (centerY-10) > 1) {
				rotateCW(cos45, sin45);
				normX = (cos45 * tempNormX) - (sin45 * tempNormY);
				normY = (sin45 * tempNormX) + (cos45 * tempNormY);
			}else if(y - (centerY-10) < -1){
				rotateCCW(cos45, sin45);
				normX = (cos45 * tempNormX) + (sin45 * tempNormY);
				normY = -(sin45 * tempNormX) + (cos45 * tempNormY);
			}
		}
	}
	/**
	 * MODIFIES: Changes the x1,x2,y1,y2 values of the paddle
	 * EFFECTS: Calculates the paddle coordinates
	 * according to the counter clockwise rotation
	 * @param cos Trigonometric expression 
	 * @param sin Trigonometric expression
	 */

	public void rotateCCW(double cos, double sin) {
		x = cos * (tx - centerX) + sin * (ty - centerY) + centerX;
		x1 = cos * (tx1 - centerX)+ sin * (ty1 - centerY) + centerX;
		x2 = cos * (tx2 - centerX) + sin * (ty2 - centerY) + centerX;
		x3 = cos * (tx3 - centerX) + sin * (ty3 - centerY) + centerX;
		y = -(sin * (tx - centerX)) + cos * (ty - centerY) + centerY;
		y1 = -(sin * (tx1 - centerX)) + cos * (ty1 - centerY) + centerY;
		y2 = -(sin * (tx2 - centerX)) + cos * (ty2 - centerY) + centerY;
		y3 = -(sin * (tx3 - centerX)) + cos * (ty3 - centerY) + centerY;
	}
	/**
	 * MODIFIES: Changes the x1,x2,y1,y2 values of the paddle
	 * EFFECTS: Calculates the paddle coordinates
	 * according to the clockwise rotation
	 * @param cos Trigonometric expression
	 * @param sin Trigonometric expression
	 */
	public void rotateCW(double cos, double sin) {
		x = (cos * (tx - centerX) - (sin * (ty - centerY)) + centerX);
		x1 = (cos * (tx1 - centerX) - (sin * (ty1 - centerY)) + centerX);
		x2 = (cos * (tx2 - centerX) - (sin * (ty2 - centerY)) + centerX);
		x3 = (cos * (tx3 - centerX) - (sin * (ty3 - centerY)) + centerX);
		y = (sin * (tx - centerX) + (cos * (ty - centerY)) + centerY);
		y1 = (sin * (tx1 - centerX) + (cos * (ty1 - centerY)) + centerY);
		y2 = (sin * (tx2 - centerX) + (cos * (ty2 - centerY)) + centerY);
		y3 = (sin * (tx3 - centerX) + (cos * (ty3 - centerY)) + centerY);
	}		
	/**
	 * EFFECTS: Sets paddle rotation to left to true or false
	 * MODIFIES: Paddle starts to rotate according to param value
	 * @param rotateLeft boolean value for rotating right
	 */
	
	
	public void setRotateLeft(boolean rotateLeft) {
		this.rotateLeft = rotateLeft;
	}
	/**
	 * EFFECTS: Sets paddle rotation to right to true or false
	 * MODIFIES: Paddle starts to rotate according to param value
	 * @param rotateRight boolean value for rotating right
	 */
	public void setRotateRight(boolean rotateRight) {
		this.rotateRight = rotateRight;
	}

	public boolean isRotateLeft() {
		return rotateLeft;
	}

	public boolean isRotateRight() {
		return rotateRight;
	}
	public boolean isMagnet() {
		return isMagnet;
	}
	public void setMagnet(boolean isMagnet) {
		this.isMagnet = isMagnet;
	}
	public boolean isTall() {
		return isTall;
	}
	public void setTall(boolean isTall) {
		this.isTall = isTall;
	}
	public boolean isLaser() {
		return isLaser;
	}
	public void setLaser(boolean isLaser) {
		this.isLaser = isLaser;
	}
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
	@Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		int[] xs = new int[] { (int) x, (int) x1, (int) x3, (int) x2};
		int[] ys = new int[] { (int) y, (int) y1, (int) y3, (int) y2};
		Polygon bounds = new Polygon(xs, ys, 4);
		return bounds;
	}
	public double getNormX() {
		return normX;
	}
	public void setNormX(double normX) {
		this.normX = normX;
	}
	public double getNormY() {
		return normY;
	}
	public void setNormY(double normY) {
		this.normY = normY;
	}

}