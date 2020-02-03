package tests;
import static org.junit.Assert.*;

import UI.UIController;
import UI.Window;
import domain.Brick;
import domain.BrickFactory;
import domain.GameController;
import domain.Paddle;
import domain.SimpleBrick;

public class GameControllerTest implements TestRep{

	
	@org.junit.Test
	public void gameControllerAddTest() {
		GameController gc = new GameController(new UIController(), new Window());
		Paddle dummyPaddle = new Paddle();
		gc.addObject(dummyPaddle);
		assertEquals(gc.objects.get(0), dummyPaddle);
	}
	
	@org.junit.Test
	public void gameControllerRemoveTest() {
		GameController gc = new GameController(new UIController(), new Window());
		Paddle dummyPaddle = new Paddle();
		gc.addObject(dummyPaddle);
		gc.removeObject(dummyPaddle);
		assertEquals(gc.objects.size(), 0);
	}
	
	@org.junit.Test
	public void gameControllerGetBricksTest() {
		GameController gc = new GameController(new UIController(), new Window());
		gc.addObject(new SimpleBrick());
		gc.addObject(new SimpleBrick());
		gc.addObject(new SimpleBrick());
		int size = gc.getBricks().size();
		assertEquals(3, size);
	}

	@Override
	public boolean repOk() {
		// TODO Auto-generated method stub
		GameController gc = new GameController(new UIController(), new Window());
		
		if(gc.objects == null) return false;
		if(gc.objects.size() < 0) return false;
		// ex: 300 brick 1 paddle 10 ball 10 power-up 10 alien
		if(gc.objects.size() > 331) return false;
		return true;
	}
	
	
	public String toString() {
		GameController gc = new GameController(new UIController(), new Window());
		return "\nGC objects size = " + gc.objects.size();
	}
	
	

}