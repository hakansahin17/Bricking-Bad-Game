package domain;

import java.awt.Rectangle;
import java.awt.Shape;

import main.Game;

/**
 * SimpleBrick class represents the simplest brick type in the game and extends the abstract class Brick.
 */

@SuppressWarnings("serial")
public class SimpleBrick extends Brick {

    /**
     * EFFECTS: creates a simple brick object with predetermined length and height.
     */
    public SimpleBrick() {
        this.setLength(Game.WIDTH / 50);
        this.setHeight(20);
        this.setId(ID.SimpleBrick);

    }

    @Override
    public void update() {

    }
    @Override
	public Shape getBounds() {
		// TODO Auto-generated method stub
		Rectangle rect = new Rectangle(getLength(), getHeight());
		rect.setLocation((int) x, (int)y);
		return rect;
	}

}
