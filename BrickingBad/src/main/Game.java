package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;


import domain.Ball;
import domain.Brick;
import domain.BrickFactory;
import domain.ChemicalBallPU;
import domain.DatabaseController;
import domain.FireballPU;
import domain.GameController;
import domain.GangOfBallsPU;
import domain.HotKeys;
import domain.ID;
import domain.LaserPU;
import domain.MagnetPU;
import domain.Paddle;
import domain.SimpleBrick;
import domain.TallerPaddlePU;
import UI.GUIBall;
import UI.GUILaser;
import UI.GUIPaddle;
import UI.GUISimpleBrick;
import UI.UIController;
import UI.Window;

public class Game extends Canvas implements Runnable {


	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Thread thread;
	private boolean running = false;
	private GameController GC;
	private UIController UIC;
	private DatabaseController DC;
	private Paddle p = new Paddle();
	private GUIPaddle p1 = new GUIPaddle();
	private Ball b = new Ball();
	private GUIBall b1 = new GUIBall();
	private Window a = new Window(Toolkit.getDefaultToolkit().getScreenSize(), "Breaking Bad", this);
	private boolean pauseChecker = false;
	private static Game game;
	private LaserPU laserpu = new LaserPU();
	private GUILaser guilaser = new GUILaser();
	private GUILaser guilaser1 = new GUILaser();
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while (running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while (delta >= 1) {
				update();
				delta--;
			}
			if (running)
				render();
			frames++;

			if (System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS: " + frames);
				frames = 0;
			}
		}
		stop();
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.cyan);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		UIC.render(g);
		g.dispose();
		bs.show();
	}
	
	public void update() {     
		GC.update();
		if(b.isGang()) {
			createBalls(b);
			b.setGang(false);
		}
		
		if(b.isChemical()) {
			b1.setChemical(true);
		}else {
			b1.setChemical(false);
		}
		
		if(b.isFire()) {
			b1.setFire(true);
		} else {
			b1.setFire(false);
		}
		
		if(p.isMagnet()) {
			p1.setMagnet(true);
		} else {
			p1.setMagnet(false);
		}
		
	}
	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public Game() {
		
		UIC = new UIController();
		GC = new GameController(UIC, a);
		DC = new DatabaseController(GC, UIC);
		this.addKeyListener(new HotKeys(GC));
		this.requestFocus();
		GC.addObject(p);
		UIC.addObject(p1);
		GC.addObject(b);
		UIC.addObject(b1);
		
		laserpu = new LaserPU();
		guilaser = new GUILaser();
		guilaser1 = new GUILaser();
		/*
		GC.getCollected().add(new TallerPaddlePU());

		GC.getCollected().add(new ChemicalBallPU());

		GC.getCollected().add(laserpu);
		GC.addObject(laserpu.getLeftLaser());
		GC.addObject(laserpu.getRightLaser());
		UIC.addObject(guilaser);
		UIC.addObject(guilaser1);

		GC.getCollected().add(new FireballPU());
		GC.getCollected().add(new GangOfBallsPU());

		// yarim calisiyor collisiondan dolayi
		GC.getCollected().add(new MagnetPU());
		*/
		
		a.getSaveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("SAVED");
				DC.saveGame("saves.ser");
			}
		});
		//error
		a.getLoadButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("LOADED");
				DC.loadGame("saves.ser");
				GC.addObject(p);
				UIC.addObject(p1);
				GC.addObject(b);
				UIC.addObject(b1);
				GC.addObject(laserpu.getLeftLaser());
				GC.addObject(laserpu.getRightLaser());
				UIC.addObject(guilaser);
				UIC.addObject(guilaser1);


			}
		});
		a.getQuitButton().addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// are you sure to go back sorucak
				a.dispose();
				thread.stop();
				running=false;
				new MainGame();
			}
		});
		
		a.getPauseButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(pauseChecker == false) {
				thread.stop();
				running = false;
				pauseChecker = true;
				a.getPauseButton().setText("Resume");
				} else {
					start();
					pauseChecker = false;
					a.getPauseButton().setText("Pause");
				}
			}
		});
		
		a.getRestartButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a.dispose();
				thread.stop();
				running=false;
				game = new Game();

			}
		});
		
		a.getLoginButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				DC.login("bbingol");

			}
		});

		a.getLogoutButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				DC.logout();

			}
		});
	}
	
	public void createBalls(Ball ball) {
		for(int i = 1; i< 11; i++) {
			Ball powerBall = new Ball();
			powerBall.setId(ID.Ball);
			powerBall.setX(ball.getX());
			powerBall.setY(ball.getY());

			if(i == 1) {
				powerBall.setVelX(-1 * 3);
				powerBall.setVelY(1);
			}
			if(i==2) {
				powerBall.setVelX(-1 * 3);
				powerBall.setVelY(0.6 * 3);
			}
			if(i==3) {
				powerBall.setVelX(-1 * 3);
				powerBall.setVelY(1.2 * 3);
			}
			if(i==4) {
				powerBall.setVelX(1 * 3);
				powerBall.setVelY(1.2 * 3);
			}
			if(i==5) {
				powerBall.setVelX(1 * 3);
				powerBall.setVelY(0.6 * 3);
			}
			if(i==6) {
				powerBall.setVelX(1 * 3);
				powerBall.setVelY(1);
			}
			if(i==7) {
				powerBall.setVelX(-1 * 3);
				powerBall.setVelY(-0.6 * 3);
			}
			if(i==8) {
				powerBall.setVelX(-1 * 3);
				powerBall.setVelY(-1.2 * 3);
			}
			if(i==9) {
				powerBall.setVelX(1 * 3);
				powerBall.setVelY(-0.6 * 3);
			}
			if(i==10) {
				powerBall.setVelX(1 * 3);
				powerBall.setVelY(-1.2 * 3);
			}
			GUIBall GUIPowerball = new GUIBall();
			GC.addObject(powerBall);
			UIC.addObject(GUIPowerball);
			powerBall.setLaunched(true);
		}		
	}
	
	public static void main(String[] args) {
		game = new Game();
	}
	public GameController getGC() {
		return GC;
	}
	public void setGC(GameController gC) {
		GC = gC;
	}
	public static Game getGame() {
		return game;
	}
	public static void setGame(Game game) {
		Game.game = game;
	}
	public Paddle getP() {
		return p;
	}
	public void setP(Paddle p) {
		this.p = p;
	}
	public LaserPU getLaserpu() {
		return laserpu;
	}
	public void setLaserpu(LaserPU laserpu) {
		this.laserpu = laserpu;
	}

}