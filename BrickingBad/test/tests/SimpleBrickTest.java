package tests;

import static org.junit.Assert.*;

import domain.ID;
import domain.Paddle;
import domain.SimpleBrick;
import main.Game;

public class SimpleBrickTest implements TestRep{

	
	@org.junit.Test
	public void PaddleRotateCCWTest() {
		SimpleBrick dummyBrick = new SimpleBrick();
		assertEquals(dummyBrick.getId(), ID.SimpleBrick);
	}
	
	@Override
	public boolean repOk() {
		// TODO Auto-generated method stub
		SimpleBrick dummyBrick = new SimpleBrick();
		if(dummyBrick.getId() != ID.SimpleBrick) return false;
		if(dummyBrick.getLength() != Game.WIDTH/50) return false;
		if(dummyBrick.getHeight() != 20) return false;

		return true;
	}
	
	public String toString() {
		SimpleBrick dummySimpleBrick = new SimpleBrick();
		return "\nSimple Brick ID = " + dummySimpleBrick.getId() + "\nSimple Brick Length = " + dummySimpleBrick.getLength() +
				"\nSimple Brick Height = " + dummySimpleBrick.getHeight();
	}

}