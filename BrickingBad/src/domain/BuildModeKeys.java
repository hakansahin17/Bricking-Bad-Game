package domain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import UI.UIController;
import main.Game;

public class BuildModeKeys implements KeyListener, MouseListener, MouseMotionListener {
	private boolean isBuild = false;
	private boolean isMove = false;
	private boolean deleteMode = false;
	
	private static Brick a;

	public boolean isMove() {
		return isMove;
	}

	public void setMove(boolean isMove) {
		this.isMove = isMove;
	}

	private GameController GC;
	private UIController UIC;

	public BuildModeKeys(GameController GC, UIController UIC) {
		this.GC = GC;
		this.UIC = UIC;

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {

			setBuild(true);

		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public boolean isBuild() {
		return isBuild;
	}

	public void setBuild(boolean isBuild) {
		this.isBuild = isBuild;
	}

	public void mouseDragged(MouseEvent event) {
		deleteMode =  GC.getWindow().getDeleteBox().isSelected();
		if (isMove && !deleteMode) {
			if (event.getY() < Game.HEIGHT / 2 + 80 && event.getX() < Game.WIDTH - 20 && event.getY() > 0) {
				int x = event.getX();
				int y = event.getY();
				a.setX(x);
				a.setY(y);
			}
		}

	}


	@Override
	public void mouseClicked(MouseEvent e) {

	}

	@Override
	public void mousePressed(MouseEvent e) {

		int x = e.getX();
		int y = e.getY();

		LinkedList<Brick> simpleBricks = GC.getBricks();
		int maxX = x + Game.WIDTH / 50;
		int minX = x - Game.WIDTH / 50;
		int minY = y - 20;
		int maxY = y + 20;
		
		deleteMode =  GC.getWindow().getDeleteBox().isSelected();

		for (int i = 0; i < simpleBricks.size(); i++) {
			if (minX < simpleBricks.get(i).getX() && simpleBricks.get(i).getX() < maxX
					&& minY < simpleBricks.get(i).getY() && maxY > simpleBricks.get(i).getY()) {
				if(!deleteMode) {
					a = simpleBricks.get(i);
					isMove = true;
				} else {
					GC.objects.remove(i);
					UIC.objects.remove(i);
				}

			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		deleteMode =  GC.getWindow().getDeleteBox().isSelected();
		if (isMove && !deleteMode) {
			if (e.getY() < Game.HEIGHT / 2 + 80 && e.getX() < Game.WIDTH - 20 && e.getY() > 0) {
				int x = e.getX();
				int y = e.getY();
				a.setX(x);
				a.setY(y);
				isMove = false;
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	

}