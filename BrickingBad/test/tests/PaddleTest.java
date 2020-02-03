package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import UI.UIController;
import domain.Brick;
import domain.BrickFactory;
import domain.GameController;
import domain.ID;
import domain.Paddle;
import domain.SimpleBrick;
import main.Game;

public class PaddleTest implements TestRep{
	
	double cos = Math.cos(Math.PI / 540), sin = Math.sin(Math.PI / 540); // 1/3 * 60 = 20 derece

	@org.junit.Test
	public void PaddleRotateCCWTest() {
		Paddle dummyPaddle = new Paddle();
		double x0 = dummyPaddle.getX();
		
		dummyPaddle.rotateCCW(cos,sin);

		assertNotEquals((int) x0, (int) dummyPaddle.getX());
	}
	
	@org.junit.Test
	public void PaddleRotateCWTest() {
		Paddle dummyPaddle = new Paddle();
		double x0 = dummyPaddle.getX();

		dummyPaddle.rotateCW(cos,sin);

		assertNotEquals((int) x0, (int) dummyPaddle.getX());
	}
	
	@org.junit.Test
	public void PaddleXBoundaryTest(){
		Paddle pd=new Paddle();
		pd.setX(-5);
		pd.checkBounds();
		assertNotEquals(pd.getX(), -5);

	}

	@org.junit.Test
	public void PaddleX1BoundaryTest(){
		Paddle pd=new Paddle();
		pd.setX1(Game.WIDTH+1);
		pd.checkBounds();
		assertNotEquals(pd.getX1(), Game.WIDTH+1);

	}

	@org.junit.Test
	public void PaddleX2BoundaryTest(){
		Paddle pd=new Paddle();
		pd.setX2(-5);
		pd.checkBounds();
		assertNotEquals(pd.getX2(), -5);

	}

	@org.junit.Test
	public void PaddleX3BoundaryTest(){
		Paddle pd=new Paddle();
		pd.setX3(Game.WIDTH+1);
		pd.checkBounds();
		assertNotEquals(pd.getX3(), Game.WIDTH+1);

	}

	@Override
	public boolean repOk() {
		// TODO Auto-generated method stub
		Paddle dummyPaddle = new Paddle();
		if(dummyPaddle.isRotateLeft() == true) return false;
		if(dummyPaddle.isRotateRight() == true) return false;
		if(dummyPaddle.centerX != Game.WIDTH / 2) return false;
		if(dummyPaddle.centerY != Game.HEIGHT - 90) return false;
		if(dummyPaddle.getId() != ID.Paddle) return false;
		
		/*dummyPaddle.rotateCCW();
		if(dummyPaddle.isRotateLeft() == false) return false;
		dummyPaddle.rotateCW();
		if(dummyPaddle.isRotateRight() == false) return false;
		*/
		return true;
	}
	
	public String toString() {
		Paddle dummyPaddle = new Paddle();
		return "\nPaddle ID = " + dummyPaddle.getId() + "\nPaddle Center X = " + dummyPaddle.centerX +
				"\nPaddle Center Y = " + dummyPaddle.centerY;
	}
	

}