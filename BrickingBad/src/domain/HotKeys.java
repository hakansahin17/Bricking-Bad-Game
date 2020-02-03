package domain;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;
import java.util.TimerTask;

import main.Game;

public class HotKeys implements KeyListener {

	private GameController GC;
	private TallerPaddlePU tp = new TallerPaddlePU();
	private Timer tallPaddleTimer = new Timer();
	private Timer chemicalBallTimer = new Timer();

	private ChemicalBallPU chem = new ChemicalBallPU();

	public HotKeys(GameController GC) {
		this.GC = GC;
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (!GC.isGameOver()) {
			int key = e.getKeyCode();
			for (int i = 0; i < GC.objects.size(); i++) {
				GameObject tempObject = GC.objects.get(i);
				if (tempObject.getId() == ID.Paddle) {
					Paddle temp = (Paddle) tempObject;
					if (key == KeyEvent.VK_LEFT && temp.getX() > 0)
						tempObject.setVelX(-Game.WIDTH / 40);
					else if (key == KeyEvent.VK_D)
						temp.setRotateRight(true);
					else if (key == KeyEvent.VK_A)
						temp.setRotateLeft(true);
					else if (key == KeyEvent.VK_RIGHT && temp.getX1() < Game.WIDTH)
						tempObject.setVelX(Game.WIDTH / 40);
					// else if(key == KeyEvent.VK_W || ) tempObject.setVelX();
					// else (key == KeyEvent.D) obj.setVelX();

					if (GC.getIDs(GC.getCollected()).contains(ID.TallPaddlePU)) {
						if (key == KeyEvent.VK_T) {

							tp.activatePaddle(temp);

							tallPaddleTimer.schedule(new TimerTask() {
								public void run() {
									tp.deactivatePaddle(temp);
								}
							}, 1000 * 30);

							GC.getCollected().remove(GC.getIDs(GC.getCollected()).indexOf(ID.TallPaddlePU));

						}
					}

					if (GC.getIDs(GC.getCollected()).contains(ID.MagnetPU)) {
						if (key == KeyEvent.VK_M) {
							MagnetPU magnet = new MagnetPU();
							magnet.activatePaddle(temp);

							GC.getCollected().remove(GC.getIDs(GC.getCollected()).indexOf(ID.MagnetPU));
						}
					}

					if (GC.getIDs(GC.getCollected()).contains(ID.LaserPU)) {
						if (key == KeyEvent.VK_L) {
							if (!Game.getGame().getLaserpu().getLeftLaser().isAlive()) {
								Game.getGame().getLaserpu().activatePaddle(Game.getGame().getP());
								Game.getGame().getLaserpu().getLeftLaser().setHitHalfMetal(false);
								Game.getGame().getLaserpu().getRightLaser().setHitHalfMetal(false);
							}
							if (Game.getGame().getLaserpu().getShotsCount() == -1) {
								Game.getGame().getLaserpu().deactivatePaddle(Game.getGame().getP());
								GC.getCollected().remove(GC.getIDs(GC.getCollected()).indexOf(ID.LaserPU));
							}
						}
					}

				}
				if ((tempObject.getId() == ID.Ball)) {
					Ball b = (Ball) tempObject;
					if (!b.isLaunched() && key == KeyEvent.VK_LEFT) {
						tempObject.setVelX(-Game.WIDTH / 40);
					} else if (!b.isLaunched() && key == KeyEvent.VK_RIGHT) {
						tempObject.setVelX(Game.WIDTH / 40);
					} else if (!b.isLaunched() && key == KeyEvent.VK_W) {
						GC.setGameActive(true);
						b.setLaunched(true);
						b.setVelY(-5);
						if (b.getVelX() > 0)
							b.setVelX(Game.WIDTH / 100);
						else if (b.getVelX() == 0)
							b.setVelX(0);
						else
							b.setVelX(-Game.WIDTH / 100);
					}

					if (GC.getIDs(GC.getCollected()).contains(ID.ChemicalBallPU)) {
						if (key == KeyEvent.VK_C) {

							chem.activateBall(b);
							chemicalBallTimer.schedule(new TimerTask() {
								public void run() {
									chem.deactivateBall(b);
								}
							}, 1000 * 60);
							GC.getCollected().remove(GC.getIDs(GC.getCollected()).indexOf(ID.ChemicalBallPU));
						}
					}

					if (GC.getIDs(GC.getCollected()).contains(ID.FireBallPU)) {
						if (key == KeyEvent.VK_F) {
							FireballPU fire = new FireballPU();
							fire.activateBall(b);
							GC.getCollected().remove(GC.getIDs(GC.getCollected()).indexOf(ID.FireBallPU));
						}
					}

					if (GC.getIDs(GC.getCollected()).contains(ID.GangOfBallsPU)) {
						if (key == KeyEvent.VK_G) {
							GangOfBallsPU gang = new GangOfBallsPU();
							gang.activateBall(b);
							GC.getCollected().remove(GC.getIDs(GC.getCollected()).indexOf(ID.GangOfBallsPU));
						}
					}
				}
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (!GC.isGameOver()) {
			int key = e.getKeyCode();
			for (int i = 0; i < GC.objects.size(); i++) {
				GameObject tempObject = GC.objects.get(i);
				if (tempObject.getId() == ID.Paddle) {
					Paddle temp = (Paddle) tempObject;
					if (key == KeyEvent.VK_LEFT)
						tempObject.setVelX(0);
					else if (key == KeyEvent.VK_D)
						temp.setRotateRight(false);
					else if (key == KeyEvent.VK_A)
						temp.setRotateLeft(false);
					else if (key == KeyEvent.VK_RIGHT)
						tempObject.setVelX(0);
					// else if(key == KeyEvent.VK_W || ) tempObject.setVelX();
					// else (key == KeyEvent.D) obj.setVelX();
				}
				if (tempObject.getId() == ID.Ball) {
					Ball b = (Ball) tempObject;
					if (!b.isLaunched() && key == KeyEvent.VK_LEFT)
						tempObject.setVelX(0);
					// else if(key == KeyEvent.VK_D) tempObject.setVelX();
					// else if(key == KeyEvent.VK_A) tempObject.setVelX();
					else if (!b.isLaunched() && key == KeyEvent.VK_RIGHT)
						tempObject.setVelX(0);
					// else if(key == KeyEvent.VK_W || ) tempObject.setVelX();
					// else (key == KeyEvent.D) obj.setVelX();
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}
	/*
	 * private GameController GC; //This has to be main or game class' handler not
	 * its private handler!
	 * 
	 * public Hotkeys(GameController GC) { this.GC = GC; }
	 * 
	 * public void keyPressed(KeyEvent e) { int key = e.getKeyCode(); for(GameObj
	 * obj : handler.getObjects()) { if(obj.getClass().equals(Paddle.class)) { NOT
	 * SURE ABOUT THIS LINE if(key == KeyEvent.VK_A) obj.setVelX(); MUST ROTATE
	 * COUNTERCLOCKWISE!! else if(key == KeyEvent.VK_D) obj.setVelX(); MUST ROTATE
	 * CLOCKWISE!! else if(key == KeyEvent.VK_LEFT) obj.setVelX(); else if(key ==
	 * KeyEvent.VK_RIGHT) obj.setVelX(); else if(key == KeyEvent.VK_W || )
	 * obj.setVelX(); NOT SURE HOW TO LISTEN TO MOUSE LEFT CLICK else (key ==
	 * KeyEvent.D) obj.setVelX(); THIS ONE IS FOR THE POWER UP USE WITH FIRST
	 * LETTER, LOOKING FOR A GETFIRSTLETTER TYPE IMPLEMENTATION } }
	 */

}