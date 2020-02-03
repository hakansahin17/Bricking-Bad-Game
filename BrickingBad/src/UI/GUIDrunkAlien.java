package UI;

import main.Game;

import java.awt.*;

public class GUIDrunkAlien extends GUIAlien {

    public GUIDrunkAlien() {
        super();
    }

    @Override
    public void render(Graphics g){
        g.setColor(Color.PINK);
        g.fillOval((int) getX(), (int) getY(), Game.WIDTH / 50, 20);

    }
}
