package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

@SuppressWarnings("serial")
public class ChemicalBallPU extends GameObject implements PowerUp {
	
	//Can destroy any brick it hits; it does not reflect after hitting a brick
	//To activate this feature after catching it the player needs to press C or click the related 
	//icon on the screen. Unlike the fireball, the chemical ball ability decays with time. 
	//Its effect can stay for one minute, after this the ball will return to its original state.
	private boolean collected = false;
	
	public ChemicalBallPU() {
		this.id = ID.ChemicalBallPU;
	}

	@Override
	public ID getID() {
		// TODO Auto-generated method stub
		return ID.ChemicalBallPU;
	}

	@Override
	public void activatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activateBall(Ball b) {
		// TODO Auto-generated method stub
		b.setChemical(true);
	}

	@Override
	public void deactivatePaddle(Paddle p) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deactivateBall(Ball b) {
		// TODO Auto-generated method stub
		b.setChemical(false);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
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