package tests;

import static org.junit.Assert.*;
import domain.Ball;
import domain.ID;
import main.Game;

public class BallTest implements TestRep {

	@org.junit.Test
	public void BallUpdateXTest() {
		Ball dummyBall = new Ball();
		double oldX = dummyBall.getX();
		dummyBall.setVelX(5);
		dummyBall.update();
		assertNotEquals(dummyBall.getX(), oldX);
	}
	
	@org.junit.Test
	public void BallUpdateYTest() {
		Ball dummyBall = new Ball();
		double oldY = dummyBall.getY();
		dummyBall.setVelY(5);
		dummyBall.update();
		assertNotEquals(dummyBall.getY(), oldY);
	}
	
	@org.junit.Test
	public void BallIsLaunchedTest() {
		Ball dummyBall = new Ball();
		boolean oldState = dummyBall.isLaunched();
		dummyBall.setLaunched(true);
		assertNotEquals(dummyBall.isLaunched(), oldState);
	}
	
	@org.junit.Test
	public void BallXBoundaryTest(){
		Ball b=new Ball();
		b.setX(Game.WIDTH);
		b.update();
		assertNotEquals(b.getX(), Game.WIDTH);
	}

	@org.junit.Test
	public void BallYBoundaryTest(){
		Ball b=new Ball();
		b.setY(-5);
		b.update();
		assertNotEquals(b.getY(), -5);
	}

	@Override
	public boolean repOk() {
		// TODO Auto-generated method stub
		Ball dummyBall = new Ball();
		
		if(dummyBall.getId() != ID.Ball)
			return false;
		if(dummyBall.getX() != Game.WIDTH/ 2 - 8)
			return false;
		if(dummyBall.getY() != Game.HEIGHT - 120)
			return false;
		if(dummyBall.getVelX() != 0)
			return false;
		if(dummyBall.getVelY() != 0)
			return false;
		if(dummyBall.isLaunched() == true)
			return false;
		
		return true;
	}

	public String toString() {
		Ball dummyBall = new Ball();
		return "\nBall ID = " + dummyBall.getId() + "\nBall X = " + dummyBall.getX() + "\nBall Y = " +
				dummyBall.getY() + "\nBall VelX = " + dummyBall.getVelX() + "\nBall VelY = " +
				dummyBall.getVelY() + "\nBall isLaunched: " + dummyBall.isLaunched();
	}
	
	
	
	

}