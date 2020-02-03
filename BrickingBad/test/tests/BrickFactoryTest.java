package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import domain.Ball;
import domain.Brick;
import domain.BrickFactory;
import domain.Paddle;
import domain.SimpleBrick;

public class BrickFactoryTest implements TestRep{

	@org.junit.Test
	public void BrickFactoryTest() {
		Brick dummyBrick1 = new SimpleBrick();
		Brick dummyBrick2 = BrickFactory.getBrick("Simple");
		assertEquals(dummyBrick1.getId(), dummyBrick2.getId());
	}

	@Override
	public boolean repOk() {
		// TODO Auto-generated method stub
		Brick dummyBrick1 = new SimpleBrick();
		Brick dummyBrick2 = BrickFactory.getBrick("Simple");
		
		if(dummyBrick1.getId() != dummyBrick2.getId())
			return false;
		
		return true;
	}
	
	public String toString() {
		Brick dummyBrick = new SimpleBrick();
		Brick dummyBrick2 = BrickFactory.getBrick("Simple");
		return "\nBrick ID = " + dummyBrick.getId() + "\nBrick ID which is created from factory = " + dummyBrick2.getId();
	}
}