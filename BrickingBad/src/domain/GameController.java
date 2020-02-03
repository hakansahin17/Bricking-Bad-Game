package domain;

import java.awt.geom.Area;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import UI.GUIChemicalBallPU;
import UI.GUICooperativeAlien;
import UI.GUIDrunkAlien;
import UI.GUIFireballPU;
import UI.GUIGangOfBallsPU;
import UI.GUILaserPU;
import UI.GUIMagnetPU;
import UI.GUIPaddle;
import UI.GUIProtectingAlien;
import UI.GUIRepairingAlien;
import UI.GUISimpleBrick;
import UI.GUITallerPaddlePU;
import UI.UIController;
import UI.Window;
import main.Game;

/**
 * OVERVIEW: This class is used for controlling all domain objects. Basically
 * how it works is it contains a list of GameObjects and with a loop, it calls
 * their updates every time GameController's update method is called. Every game
 * object has its own update method and it is called. It also takes UIController
 * as an input since it is the only class allowed to communicate with UI.
 *
 * @author The Hackermen Team
 *
 */
public class GameController {

	private UIController UIC;

	private ArrayList<PowerUp> collected = new ArrayList<PowerUp>();

	private Window window;

	private String username;
	private boolean connected, gameActive = false, gameOver = false;
	private int score = 0, time = 0, counter = 0, lives = 3, initialBrickCount;

	private final Random rand = new Random();
	public LinkedList<GameObject> objects = new LinkedList<GameObject>();

	/**
	 * REQUIRES: UI != null EFFECTS: initializes the GameController object by
	 * setting the field.
	 * 
	 * @param UI Takes the object UIController
	 */
	public GameController(UIController UI, Window window) {
		this.UIC = UI;
		this.window = window;
	}

	/**
	 * MODIFIES: All object's x (if it is a paddle x, x1, x2, x3), y (if it is a
	 * paddle x, x1, x2, x3) EFFECTS: It controls the game by calling every object's
	 * update method and checking certain conditions like collision between ball and
	 * paddle, brick.
	 */
	public void update() {
		UIC.setScore(score);
		UIC.setLives(lives);

		for (int i = 0; i < objects.size(); i++) {
			GameObject tempobject = (GameObject) objects.get(i);
			UIC.objects.get(i).setX((int) tempobject.getX());
			UIC.objects.get(i).setY((int) tempobject.getY());
			if (tempobject.getId() == ID.Paddle) {
				GUIPaddle gPaddle = (GUIPaddle) UIC.objects.get(i);
				int[] xs1 = new int[] { (int) tempobject.getX(), (int) tempobject.getX1(), (int) tempobject.getX3(),
						(int) tempobject.getX2(), };
				int[] ys1 = new int[] { (int) tempobject.getY(), (int) tempobject.getY1(), (int) tempobject.getY3(),
						(int) tempobject.getY2() };
				gPaddle.setXs(xs1);
				gPaddle.setYs(ys1);
				Paddle paddle = (Paddle) tempobject;

				for (int j = 0; j < objects.size(); j++) {
					GameObject tempobject1 = (GameObject) objects.get(j);
					if (tempobject1.getId() == ID.MagnetPU) {
						MagnetPU pu = (MagnetPU) tempobject1;
						Area puArea = new Area(pu.getBounds());
						Area paddleArea = new Area(paddle.getBounds());
						puArea.intersect(paddleArea);
						if (!puArea.isEmpty()) {
							collected.add(pu);
							pu.setCollected(true);
							objects.remove(j);
							UIC.objects.remove(j);
						}
					}
					if (tempobject1.getId() == ID.TallPaddlePU) {
						TallerPaddlePU pu = (TallerPaddlePU) tempobject1;
						Area puArea = new Area(pu.getBounds());
						Area paddleArea = new Area(paddle.getBounds());
						puArea.intersect(paddleArea);
						if (!puArea.isEmpty()) {
							collected.add(pu);
							pu.setCollected(true);
							objects.remove(j);
							UIC.objects.remove(j);
						}
					}
					if (tempobject1.getId() == ID.LaserPU) {
						LaserPU pu = (LaserPU) tempobject1;
						Area puArea = new Area(pu.getBounds());
						Area paddleArea = new Area(paddle.getBounds());
						puArea.intersect(paddleArea);
						if (!puArea.isEmpty()) {
							collected.add(pu);
							pu.setCollected(true);
							objects.remove(j);
							UIC.objects.remove(j);
						}
					}
					if (tempobject1.getId() == ID.FireBallPU) {
						FireballPU pu = (FireballPU) tempobject1;
						Area puArea = new Area(pu.getBounds());
						Area paddleArea = new Area(paddle.getBounds());
						puArea.intersect(paddleArea);
						if (!puArea.isEmpty()) {
							collected.add(pu);
							pu.setCollected(true);
							objects.remove(j);
							UIC.objects.remove(j);
						}
					}
					if (tempobject1.getId() == ID.ChemicalBallPU) {
						ChemicalBallPU pu = (ChemicalBallPU) tempobject1;
						Area puArea = new Area(pu.getBounds());
						Area paddleArea = new Area(paddle.getBounds());
						puArea.intersect(paddleArea);
						if (!puArea.isEmpty()) {
							collected.add(pu);
							pu.setCollected(true);
							objects.remove(j);
							UIC.objects.remove(j);
						}
					}
					if (tempobject1.getId() == ID.GangOfBallsPU) {
						GangOfBallsPU pu = (GangOfBallsPU) tempobject1;
						Area puArea = new Area(pu.getBounds());
						Area paddleArea = new Area(paddle.getBounds());
						puArea.intersect(paddleArea);
						if (!puArea.isEmpty()) {
							collected.add(pu);
							pu.setCollected(true);
							objects.remove(j);
							UIC.objects.remove(j);
						}
					}
				}
			}

			if (tempobject.getId() == ID.SimpleBrick) {
				SimpleBrick ball = (SimpleBrick) tempobject;
				if (ball.isHit()) {
					UIC.objects.remove(i);
					objects.remove(i);
				}
			}

			if (tempobject.getId() == ID.HalfMetalBrick) {
				HalfMetalBrick ball = (HalfMetalBrick) tempobject;
				if (ball.isHit()) {
					UIC.objects.remove(i);
					objects.remove(i);
				}
			} else if (tempobject.getId() == ID.CooperativeAlien) {

				CooperativeAlien temp = (CooperativeAlien) tempobject;

				for (int j = 0; j < objects.size(); j++) {
					GameObject obj = (GameObject) objects.get(j);

					if (obj.getId() == ID.WrapperBrick) {
						WrapperBrick br = (WrapperBrick) obj;
						if (temp.getX() + Game.WIDTH / 50 > br.getX() && temp.getX() < br.getX() + Game.WIDTH / 50) {
							if (temp.getY() > br.getY() - 20 && temp.getY() < br.getY() + 20) {
								br.setHit(true);

							}
						}
					}
					if (obj.getId() == ID.HalfMetalBrick) {
						HalfMetalBrick br = (HalfMetalBrick) obj;
						if (temp.getX() + Game.WIDTH / 50 > br.getX() && temp.getX() < br.getX() + Game.WIDTH / 50) {
							if (temp.getY() > br.getY() - 20 && temp.getY() < br.getY() + 20) {
								br.setHit(true);

							}
						}
					}
					if (obj.getId() == ID.SimpleBrick) {
						SimpleBrick br = (SimpleBrick) obj;
						if (temp.getX() + Game.WIDTH / 50 > br.getX() && temp.getX() < br.getX() + Game.WIDTH / 50) {
							if (temp.getY() > br.getY() - 20 && temp.getY() < br.getY() + 20) {
								br.setHit(true);

							}
						}
					}
					if (obj.getId() == ID.MineBrick) {
						MineBrick br = (MineBrick) obj;
						if (temp.getX() + Game.WIDTH / 50 > br.getX() && temp.getX() < br.getX() + Game.WIDTH / 50) {
							if (temp.getY() > br.getY() - 20 && temp.getY() < br.getY() + 20) {
								br.setHit(true);

							}
						}
					}
				}
			}

			else if (tempobject.getId() == ID.MineBrick) {
				MineBrick ball = (MineBrick) tempobject;
				if (ball.isHit()) {
					UIC.objects.remove(i);
					objects.remove(i);
					for (GameObject a : objects) {
						if (a.getId() == ID.SimpleBrick || a.getId() == ID.HalfMetalBrick || a.getId() == ID.MineBrick
								|| a.getId() == ID.WrapperBrick) {
							if (Math.sqrt(Math.pow(ball.getX() - a.getX(), 2)
									+ (Math.pow(ball.getY() - a.getY(), 2))) < 100) {
								Brick brick = (Brick) a;
								brick.setHit(true);

							}
						}
					}
				}
			}

			if (tempobject.getId() == ID.WrapperBrick) {
				int random = rand.nextInt(10);
				WrapperBrick temp = (WrapperBrick) tempobject;
				if (temp.isHit()) {
					System.out.println(random + " RANDOM VALUE IS");
					if (random == 0) {
						System.out.println(" CHEMBALL");
						ChemicalBallPU generated = new ChemicalBallPU();
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUIChemicalBallPU chemball = new GUIChemicalBallPU();
						UIC.addObject(chemball);
					} else if (random == 1) {
						System.out.println(" FIREBALL");
						FireballPU generated = new FireballPU();
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUIFireballPU fireball = new GUIFireballPU();
						UIC.addObject(fireball);
					} else if (random == 2) {
						System.out.println(" GANGOFBALLS");
						GangOfBallsPU generated = new GangOfBallsPU();
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUIGangOfBallsPU gang = new GUIGangOfBallsPU();
						UIC.addObject(gang);
					} else if (random == 3) {
						System.out.println(" LASERPU");
						LaserPU generated = new LaserPU();
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUILaserPU laserp = new GUILaserPU();
						UIC.addObject(laserp);
					} else if (random == 4) {
						System.out.println(" TALLERPADDLE");
						TallerPaddlePU generated = new TallerPaddlePU();
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUITallerPaddlePU tallerPU = new GUITallerPaddlePU();
						UIC.addObject(tallerPU);
					} else if (random == 5) {
						System.out.println(" MAGNETPU");
						MagnetPU generated = new MagnetPU();
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUIMagnetPU magnet = new GUIMagnetPU();
						UIC.addObject(magnet);
					} else if (random == 6) {
						System.out.println(" REP ALIEN");
						RepairingAlien generated = new RepairingAlien();
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUIRepairingAlien repAlien = new GUIRepairingAlien();
						UIC.addObject(repAlien);
					} else if (random == 7) {
						System.out.println(" PROTECTING ALIEN");
						ProtectingAlien generated = new ProtectingAlien();
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUIProtectingAlien protecting = new GUIProtectingAlien();
						UIC.addObject(protecting);
					} else if (random == 8) {
						System.out.println("DRUNK ALIEN");
						DrunkAlien generated = new DrunkAlien(remainingBrickPercentage());
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUIDrunkAlien drunk = new GUIDrunkAlien();
						UIC.addObject(drunk);
					} else if (random == 9) {
						System.out.println("Cooperative ALIEN");
						CooperativeAlien generated = new CooperativeAlien();
						generated.setX(temp.getX());
						generated.setY(temp.getY());
						objects.add(generated);
						GUICooperativeAlien drunk = new GUICooperativeAlien();
						UIC.addObject(drunk);
					}
					UIC.objects.remove(i);
					objects.remove(i);
				}
			}
			// collision
			if (tempobject.getId() == ID.Ball) {
				Ball ball = (Ball) tempobject;
				for (int j = 0; j < objects.size(); j++) {
					GameObject obj = (GameObject) objects.get(j);

					// duz bir paddle icin collision var bunu degistirmek lazim

					if (obj.getId() == ID.Paddle) {
						Paddle tempPaddle = (Paddle) obj;
						if (ball.getY() > Game.HEIGHT) {
							if (lives > 1) {
								lives--;
								Paddle p = (Paddle) obj;
								ball.setVelX(0);
								ball.setVelY(0);
								ball.setX(p.getCenterX() - 8);
								ball.setY(p.centerY - 35);
								ball.setLaunched(false);
								p.setMagnet(false);
								p.setTall(false);
								ball.setChemical(false);
								ball.setFire(false);
								p.setLaser(false);
								gameActive = false;
							} else {
								lives = 0;
								gameOver = true;
								UIC.setGameOver(true);
							}
						}
						if (!tempPaddle.isMagnet()) {
							Area ballArea = new Area(ball.getBounds());
							Area paddleArea = new Area(tempPaddle.getBounds());
							ballArea.intersect(paddleArea);
							if (!ballArea.isEmpty()) {
								double newVelX = ball.getVelX() - 2 * (ball.getVelX() * tempPaddle.getNormX()
										+ ball.getVelY() * tempPaddle.getNormY()) * tempPaddle.getNormX();
								double newVelY = ball.getVelY() - 2 * (ball.getVelX() * tempPaddle.getNormX()
										+ ball.getVelY() * tempPaddle.getNormY()) * tempPaddle.getNormY();
								ball.setVelX(newVelX);
								ball.setVelY(newVelY);
							}
							/*
							 * if (ball.getX() > obj.getX() && ball.getX() < obj.getX() +
							 * tempPaddle.getLength()) { if (ball.getY() > obj.getY() - 20 && ball.getY() <
							 * obj.getY() + 20) { ball.setVelY(ball.getVelY() * -1); } }
							 */
						}
						if (tempPaddle.isMagnet()) {
							Area ballArea = new Area(ball.getBounds());
							Area paddleArea = new Area(tempPaddle.getBounds());
							ballArea.intersect(paddleArea);
							if (!ballArea.isEmpty()) {
								ball.setVelX(0);
								ball.setVelY(0);
								ball.setX(tempPaddle.getCenterX() - 8);
								ball.setY(tempPaddle.centerY - 35);
								ball.setLaunched(false);
							}
							/*
							 * if (ball.getX() > obj.getX() && ball.getX() < obj.getX() +
							 * tempPaddle.getLength()) { if (ball.getY() > obj.getY() - 20 && ball.getY() <
							 * obj.getY() + 20) { ball.setLaunched(false); } }
							 */
						}
					}
					if (!ball.isChemical() && !ball.isFire()) {
						if (obj.getId() == ID.SimpleBrick) {
							SimpleBrick br = (SimpleBrick) obj;
							Area ballArea = new Area(ball.getBounds());
							Area breakArea = new Area(br.getBounds());

							ballArea.intersect(breakArea);
							if (!ballArea.isEmpty()) {
								ball.setVelY(ball.getVelY() * -1);
								br.setHit(true);
							}
						} else if (obj.getId() == ID.CooperativeAlien) {
							Area ballArea = new Area(ball.getBounds());
							Area copA = new Area(obj.getBounds());
							ballArea.intersect(copA);
							if (!ballArea.isEmpty()) {
								CooperativeAlien copaa = (CooperativeAlien) obj;
								copaa.setHit(true);
							}
						} else if (obj.getId() == ID.HalfMetalBrick) {
							HalfMetalBrick br = (HalfMetalBrick) obj;
							Area ballArea = new Area(ball.getBounds());
							Area breakArea = new Area(br.getBounds());

							ballArea.intersect(breakArea);
							if (!ballArea.isEmpty()) {
								ball.setVelY(ball.getVelY() * -1);
								br.setHit(true);
							}
							Area metalArea = new Area(br.metalBounds());
							Area ballArea2 = new Area(ball.getBounds());
							ballArea2.intersect(metalArea);
							if (!ballArea2.isEmpty()) {
								ball.setVelY(ball.getVelY() * -1);
							}
						} else if (obj.getId() == ID.MineBrick) {
							MineBrick br = (MineBrick) obj;
							Area ballArea = new Area(ball.getBounds());
							Area breakArea = new Area(br.getBounds());
							ballArea.intersect(breakArea);
							if (!ballArea.isEmpty()) {
								ball.setVelY(ball.getVelY() * -1);
								br.setHit(true);
							}
						} else if (obj.getId() == ID.WrapperBrick) {
							WrapperBrick br = (WrapperBrick) obj;
							Area ballArea = new Area(ball.getBounds());
							Area breakArea = new Area(br.getBounds());
							ballArea.intersect(breakArea);
							if (!ballArea.isEmpty()) {
								ball.setVelY(ball.getVelY() * -1);
								br.setHit(true);
							}
						}

					}

					if (ball.isChemical()) {
						if (obj.getId() == ID.SimpleBrick) {
							SimpleBrick br = (SimpleBrick) obj;
							if (ball.getX() + Game.WIDTH / 50 > br.getX()
									&& ball.getX() < br.getX() + Game.WIDTH / 50) {
								if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
									br.setHit(true);
									// icinden geciyor bricklerin
								}
							}
						} else if (obj.getId() == ID.HalfMetalBrick) {
							HalfMetalBrick br = (HalfMetalBrick) obj;
							if (ball.getX() + Game.WIDTH / 50 > br.getX()
									&& ball.getX() < br.getX() + Game.WIDTH / 50) {
								if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
									br.setHit(true);
								}
							}
						} else if (obj.getId() == ID.MineBrick) {
							MineBrick br = (MineBrick) obj;
							if (ball.getX() + Game.WIDTH / 50 > br.getX()
									&& ball.getX() < br.getX() + Game.WIDTH / 50) {
								if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
									br.setHit(true);
								}
							}
						} else if (obj.getId() == ID.WrapperBrick) {
							WrapperBrick br = (WrapperBrick) obj;
							if (ball.getX() + Game.WIDTH / 50 > br.getX()
									&& ball.getX() < br.getX() + Game.WIDTH / 50) {
								if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
									br.setHit(true);
								}
							}
						}
						else if (obj.getId() == ID.ProtectingAlien) {
							ProtectingAlien br = (ProtectingAlien) obj;
							if (ball.getX() + Game.WIDTH / 50 > br.getX() && ball.getX() < br.getX() + Game.WIDTH / 50) {
								if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
									objects.remove(j);
									UIC.objects.remove(j);
								}
							}
						}
					}

					if (ball.isFire()) {
						if (obj.getId() == ID.HalfMetalBrick) {
							HalfMetalBrick br = (HalfMetalBrick) obj;
							Area ballArea = new Area(ball.getBounds());
							Area breakArea = new Area(br.metalBounds());
							ballArea.intersect(breakArea);
							if (!ballArea.isEmpty()) {
								ball.setVelY(ball.getVelY() * -1);
								br.setHit(true);
								SimpleBrick simplebr = new SimpleBrick();
								simplebr.setX(br.getX());
								simplebr.setY(br.getY());
								objects.add(simplebr);
								UIC.addObject(new GUISimpleBrick());
							}
						} else if (obj.getId() == ID.SimpleBrick) {
							SimpleBrick br = (SimpleBrick) obj;
							if (ball.getX() + Game.WIDTH / 50 > br.getX()
									&& ball.getX() < br.getX() + Game.WIDTH / 50) {
								if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
									ball.setVelY(ball.getVelY() * -1);
									br.setHit(true);
									// komsu patlatiyor
									for (GameObject a : objects) {
										if (a.getId() == ID.SimpleBrick) {
											if (Math.sqrt(Math.pow(br.getX() - a.getX(), 2)
													+ (Math.pow(br.getY() - a.getY(), 2))) < 100) {
												SimpleBrick brick = (SimpleBrick) a;
												brick.setHit(true);

											}
										}
									}
								}
							}
						} else if (obj.getId() == ID.MineBrick) {
							MineBrick br = (MineBrick) obj;
							if (ball.getX() + Game.WIDTH / 50 > br.getX()
									&& ball.getX() < br.getX() + Game.WIDTH / 50) {
								if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
									ball.setVelY(ball.getVelY() * -1);
									br.setHit(true);
									for (GameObject a : objects) {
										if (a.getId() == ID.MineBrick) {
											if (Math.sqrt(Math.pow(br.getX() - a.getX(), 2)
													+ (Math.pow(br.getY() - a.getY(), 2))) < 100) {
												MineBrick brick = (MineBrick) a;
												brick.setHit(true);

											}
										}
									}
								}
							}
						} else if (obj.getId() == ID.WrapperBrick) {
							WrapperBrick br = (WrapperBrick) obj;
							if (ball.getX() + Game.WIDTH / 50 > br.getX()
									&& ball.getX() < br.getX() + Game.WIDTH / 50) {
								if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
									ball.setVelY(ball.getVelY() * -1);
									br.setHit(true);
									for (GameObject a : objects) {
										if (a.getId() == ID.WrapperBrick) {
											if (Math.sqrt(Math.pow(br.getX() - a.getX(), 2)
													+ (Math.pow(br.getY() - a.getY(), 2))) < 100) {
												WrapperBrick brick = (WrapperBrick) a;
												brick.setHit(true);

											}
										}
									}
								}
							}
						}
						else if (obj.getId() == ID.ProtectingAlien) {
							ProtectingAlien br = (ProtectingAlien) obj;
							if (ball.getX() + Game.WIDTH / 50 > br.getX() && ball.getX() < br.getX() + Game.WIDTH / 50) {
								if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
									ball.setVelY(ball.getVelY() * -1);
									objects.remove(j);
									UIC.objects.remove(j);
								}
							}
						}
					}

					else if (obj.getId() == ID.ProtectingAlien) {
						ProtectingAlien br = (ProtectingAlien) obj;
						if (ball.getX() + Game.WIDTH / 50 > br.getX() && ball.getX() < br.getX() + Game.WIDTH / 50) {
							if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
								ball.setVelY(ball.getVelY() * -1);
								objects.remove(j);
								UIC.objects.remove(j);
							}
						}
					}	else if (obj.getId() == ID.RepairingAlien) {
						RepairingAlien br = (RepairingAlien) obj;
						if (ball.getX() + Game.WIDTH / 50 > br.getX() && ball.getX() < br.getX() + Game.WIDTH / 50) {
							if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
								ball.setVelY(ball.getVelY() * -1);
								SimpleBrick sb = new SimpleBrick();
								GUISimpleBrick sb1 = new GUISimpleBrick();
								sb.setX(br.getX());
								sb.setY(br.getY());
								objects.add(sb);
								UIC.objects.add(sb1);
								objects.remove(j);
								UIC.objects.remove(j);
								
							}
						}
					}
				}
			}

			if (tempobject.getId() == ID.Laser) {
				Laser ball = (Laser) tempobject;
				for (int j = 0; j < objects.size(); j++) {
					GameObject obj = (GameObject) objects.get(j);

					if (obj.getId() == ID.SimpleBrick) {
						SimpleBrick br = (SimpleBrick) obj;
						if (ball.getX() + Game.WIDTH / 50 > br.getX() && ball.getX() < br.getX() + Game.WIDTH / 50) {
							if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
								br.setHit(true);
							}
						}
					} else if (obj.getId() == ID.HalfMetalBrick) {
						HalfMetalBrick br = (HalfMetalBrick) obj;
						if (ball.getX() + Game.WIDTH / 50 > br.getX() && ball.getX() < br.getX() + Game.WIDTH / 50) {
							if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
								ball.setHitHalfMetal(true); // laser duruyor
							}
						}
					} else if (obj.getId() == ID.MineBrick) {
						MineBrick br = (MineBrick) obj;
						if (ball.getX() + Game.WIDTH / 50 > br.getX() && ball.getX() < br.getX() + Game.WIDTH / 50) {
							if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
								br.setHit(true);
							}
						}
					} else if (obj.getId() == ID.WrapperBrick) {
						WrapperBrick br = (WrapperBrick) obj;
						if (ball.getX() + Game.WIDTH / 50 > br.getX() && ball.getX() < br.getX() + Game.WIDTH / 50) {
							if (ball.getY() > br.getY() - 20 && ball.getY() < br.getY() + 20) {
								br.setHit(true);
							}
						}
					}
				}
			}
			tempobject.update();
		}
		timeNscore();

	}

	public boolean isGameActive() {
		return gameActive;
	}

	public void setGameActive(boolean gameActive) {
		this.gameActive = gameActive;
	}

	/**
	 * REQUIRES: obj != null MODIFIES: objects EFFECTS: Adds a game object from the
	 * objects field list.
	 * 
	 * @param obj Game Object (Paddle, Brick, Powerups, etc.)
	 */
	public void addObject(GameObject obj) {
		this.objects.add(obj);
	}

	/**
	 * REQUIRES: obj != null, obj should exist in the list. MODIFIES: objects
	 * EFFECTS: Removes a game object from the objects field list.
	 * 
	 * @param obj Game Object (Paddle, Brick, Powerups, etc.)
	 */
	public void removeObject(GameObject obj) {
		this.objects.remove(obj);
	}

	/**
	 * EFFECTS: Returns a list of SimpleBricks that are currently in the GameObject
	 * LinkedList.
	 * 
	 * @return simpleBricks
	 */
	public LinkedList<Brick> getBricks() {
		LinkedList<Brick> allBricks = new LinkedList<Brick>();
		for (int i = 0; i < objects.size(); i++) {
			GameObject tempobject = (GameObject) objects.get(i);
			if (tempobject.getId() == ID.SimpleBrick || tempobject.getId() == ID.WrapperBrick
					|| tempobject.getId() == ID.MineBrick || tempobject.getId() == ID.HalfMetalBrick) {

				allBricks.add((Brick) tempobject);
			}
		}
		return allBricks;
	}

	public ArrayList<PowerUp> getCollected() {
		return collected;
	}

	public void setCollected(ArrayList<PowerUp> collected) {
		this.collected = collected;
	}

	public ArrayList<ID> getIDs(ArrayList<PowerUp> collected) {
		ArrayList<ID> IDs = new ArrayList<ID>();
		for (PowerUp PU : collected) {
			IDs.add(PU.getID());
		}
		return IDs;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

	public void timeNscore() {
		if (gameActive && !gameOver) {
			if (counter == 60) {
				time++;
				score = score + (300 / time);
				counter = 0;
				System.out.println(time);
			} else {
				counter++;
			}
		}

	}

	public int getBrickCount() {
		return getBricks().size();
	}

	public double remainingBrickPercentage() {
		if (getInitialBrickCount() == 0) {
			return 0;
		}
		return getBrickCount() / getInitialBrickCount() * 100;
	}

	public int getInitialBrickCount() {
		return initialBrickCount;
	}

	public void setInitialBrickCount(int count) {
		initialBrickCount = count;
	}

	public Window getWindow() {
		return window;
	}
}