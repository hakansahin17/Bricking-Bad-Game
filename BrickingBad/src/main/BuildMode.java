package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferStrategy;
import java.util.Random;

import UI.GUIBrick;
import UI.GUIHalfMetalBrick;
import UI.GUIMineBrick;
import UI.GUISimpleBrick;
import UI.GUIWrapperBrick;
import UI.UIController;
import UI.Window;
import domain.Brick;
import domain.BrickFactory;
import domain.BuildModeKeys;
import domain.DatabaseController;
import domain.GameController;

public class BuildMode extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private Thread thread;
	private boolean running = false;
	private Window a = new Window(Toolkit.getDefaultToolkit().getScreenSize(), "Breaking Bad", this);
	private UIController UIC = new UIController();
	private GameController GC = new GameController(UIC, a);
	private DatabaseController DC = new DatabaseController(GC, UIC);
	private BuildModeKeys bmKeys = new BuildModeKeys(GC, UIC);

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
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
		g.setColor(new Color(238, 238, 238));
		g.fillRect(0, 0, WIDTH, HEIGHT);
		UIC.render(g);
		g.dispose();
		bs.show();
	}

	public void update() {
		GC.update();
		if (bmKeys.isBuild()) {
			addBricks(GC, UIC);
			bmKeys.setBuild(false);
		}

	}

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

	public BuildMode() {
		this.addKeyListener(bmKeys);
		this.addMouseListener(bmKeys);
		this.addMouseMotionListener(bmKeys);

		a.getSaveButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("SAVED");
				DC.saveGame("saves.ser");
			}
		});
		a.getLoadButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("LOADED");
				DC.loadGame("saves.ser");

			}
		});
		a.getQuitButton().addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// are you sure to go back sorucak
				a.dispose();
				thread.stop();
				running = false;
				new MainGame();
			}
		});

		a.getPauseButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

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

	public void addBricks(GameController GC, UIController UIC) {
		String s1 = a.getBrickCount1().getText();
		String s2 = a.getBrickCount2().getText();
		String s3 = a.getBrickCount3().getText();
		String s4 = a.getBrickCount4().getText();

		if (!s1.equals(null) && !s2.equals(null) && !s3.equals(null) && !s4.equals(null)) {

			int simpleCount = Integer.parseInt(s1);
			int halfmetalCount = Integer.parseInt(s2);
			int mineCount = Integer.parseInt(s3);
			int wrapperCount = Integer.parseInt(s4);

			for (int i = 0; i < simpleCount; i++) {
				Brick a = BrickFactory.getBrick("Simple");
				int x = new Random().nextInt(WIDTH - WIDTH / 50);
				int y = new Random().nextInt(HEIGHT / 2 + 80);

				a.setX(x);
				a.setY(y);

				GUIBrick a1 = new GUISimpleBrick();

				GC.addObject(a);
				UIC.addObject(a1);

			}
			for (int i = 0; i < halfmetalCount; i++) {
				Brick a = BrickFactory.getBrick("Half-metal");
				int x = new Random().nextInt(WIDTH - WIDTH / 50);
				int y = new Random().nextInt(HEIGHT / 2 + 80);

				a.setX(x);
				a.setY(y);

				GUIBrick a1 = new GUIHalfMetalBrick();

				GC.addObject(a);
				UIC.addObject(a1);

			}
			for (int i = 0; i < mineCount; i++) {
				Brick a = BrickFactory.getBrick("Mine");
				int x = new Random().nextInt(WIDTH - WIDTH / 50);
				int y = new Random().nextInt(HEIGHT / 2 + 80);

				a.setX(x);
				a.setY(y);

				GUIBrick a1 = new GUIMineBrick();

				GC.addObject(a);
				UIC.addObject(a1);
			}
			for (int i = 0; i < wrapperCount; i++) {
				Brick a = BrickFactory.getBrick("Wrapper");
				int x = new Random().nextInt(WIDTH - WIDTH / 50);
				int y = new Random().nextInt(HEIGHT / 2 + 80);

				a.setX(x);
				a.setY(y);

				GUIBrick a1 = new GUIWrapperBrick();

				GC.addObject(a);
				UIC.addObject(a1);
			}
		}
	}

	public static void main(String[] args) {
		new BuildMode();
	}

}