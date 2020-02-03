package UI;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import main.BuildMode;
import main.Game;
import main.MainGame;

public class Window extends Canvas {

	private static final long serialVersionUID = 1L;
	public static int WIDTH = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth(),
			HEIGHT = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
	private JPanel sidebar = new JPanel();
	private JButton saveButton = new JButton("Save");
	private JButton loadButton = new JButton("Load");
	private JButton pauseButton = new JButton("Pause");
	private JButton quitButton = new JButton("Quit");
	private JButton loginButton = new JButton("Login");
	private JButton logoutButton = new JButton("Logout");
	private JTextField brickType1 = new JTextField();
	private JTextField brickCount1 = new JTextField(10); 
	private JTextField brickType2 = new JTextField(); 
	private JTextField brickCount2 = new JTextField(10); 
	private JTextField brickType3 = new JTextField(); 
	private JTextField brickCount3 = new JTextField(10);
	private JTextField brickType4 = new JTextField();
	private JTextField brickCount4 = new JTextField(10);
	private JPanel gui = new JPanel(new GridLayout(0,1));
	private JPanel simpleGui = new JPanel(new FlowLayout());  
	private JPanel halfmetalGui = new JPanel(new FlowLayout()); 
	private JPanel mineGui = new JPanel(new FlowLayout());  
	private JPanel wrapperGui = new JPanel(new FlowLayout());
	private JCheckBox deleteBox = new JCheckBox("delete?", false);
	private boolean canAddBricks = false;
	private JFrame frame;
	private JPanel gamePanel = new JPanel(new FlowLayout());
	private JButton Game = new JButton ("Play Game");
	private JButton buildMode = new JButton("Build Mode");
	private JButton restartButton = new JButton("Restart");

	public Window(Dimension d, String title, Game game) {
		frame = new JFrame(title);
		frame.setMaximumSize(d);
		frame.setMinimumSize(new Dimension(1, 1));
		frame.setSize(frame.getMaximumSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		sidebar.add(saveButton);
		sidebar.add(loadButton);
		sidebar.add(pauseButton);
		sidebar.add(quitButton);
		sidebar.add(restartButton);
		sidebar.add(loginButton);
		sidebar.add(logoutButton);
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, 10, 550, 40);
		
		frame.add(sidebar);
		
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
	public Window(Dimension d, String title, BuildMode buildmode) {
		
		frame = new JFrame(title);
		
		frame.setMaximumSize(d);
		frame.setMinimumSize(new Dimension(1, 1));
		frame.setSize(frame.getMaximumSize());
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		sidebar.add(saveButton);
		sidebar.add(loadButton);
		sidebar.add(pauseButton);
		sidebar.add(quitButton);
		sidebar.add(loginButton);
		sidebar.add(logoutButton);
		sidebar.add(deleteBox);
		sidebar.setBackground(Color.white);
		sidebar.setBounds(10, HEIGHT - 90, 500, 40);
		
		frame.add(sidebar);
		
		brickType1.setText("Simple Bricks");
		brickType1.setEditable(false);
		brickCount1.setEditable(true);
		brickCount1.setText("0");

		brickType2.setText("Half-Metal Bricks");
		brickType2.setEditable(false);
		brickCount2.setEditable(true);
		brickCount2.setText("0");

		brickType3.setText("Mine Bricks");
		brickType3.setEditable(false);
		brickCount3.setEditable(true);
		brickCount3.setText("0");

		brickType4.setText("Wrapper Bricks");
		brickType4.setEditable(false);
		brickCount4.setEditable(true);
		brickCount4.setText("0");


		simpleGui.add( brickType1 );
		simpleGui.add( brickCount1 );

		halfmetalGui.add( brickType2 );
		halfmetalGui.add( brickCount2 );

		mineGui.add( brickType3 );
		mineGui.add( brickCount3 );

		wrapperGui.add( brickType4 );
		wrapperGui.add( brickCount4 );

		simpleGui.setBackground(Color.gray);
		halfmetalGui.setBackground(Color.gray);
		mineGui.setBackground(Color.gray);
		wrapperGui.setBackground(Color.gray);

		gui.add(simpleGui);
		gui.add(halfmetalGui);
		gui.add(mineGui);
		gui.add(wrapperGui);
		gui.setBounds(WIDTH- gui.getWidth() - 370, HEIGHT - 200 , 350, 150);
		
		frame.add(gui);
		
		JLabel label = new JLabel("EDITING AREA FOR THE PLAYER", SwingConstants.CENTER);
		label.setBounds(WIDTH/2 - 100, HEIGHT/2+100, 200, 100);
		frame.add(label);
		

		
		frame.add(buildmode);

		frame.setVisible(true);
		buildmode.start();
		
		
	}
	
	public Window() {}

	public Window(Dimension screenSize, String title, MainGame mainGame) {
		frame = new JFrame(title);
		frame.setVisible(true);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gamePanel.add(Game);
		gamePanel.add(buildMode);
		frame.add(gamePanel);
	}

	public JTextField getBrickCount1() {
		return brickCount1;
	}

	public void setBrickCount1(JTextField brickCount1) {
		this.brickCount1 = brickCount1;
	}

	public JTextField getBrickCount2() {
		return brickCount2;
	}

	public void setBrickCount2(JTextField brickCount2) {
		this.brickCount2 = brickCount2;
	}

	public JTextField getBrickCount3() {
		return brickCount3;
	}

	public void setBrickCount3(JTextField brickCount3) {
		this.brickCount3 = brickCount3;
	}

	public JTextField getBrickCount4() {
		return brickCount4;
	}

	public void setBrickCount4(JTextField brickCount4) {
		this.brickCount4 = brickCount4;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


	public boolean isCanAddBricks() {
		return canAddBricks;
	}

	public void setCanAddBricks(boolean canAddBricks) {
		this.canAddBricks = canAddBricks;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public void setSaveButton(JButton saveButton) {
		this.saveButton = saveButton;
	}

	public JButton getLoadButton() {
		return loadButton;
	}

	public void setLoadButton(JButton loadButton) {
		this.loadButton = loadButton;
	}

	public JButton getQuitButton() {
		return quitButton;
	}

	public void setQuitButton(JButton quitButton) {
		this.quitButton = quitButton;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}

	public void setPauseButton(JButton pauseButton) {
		this.pauseButton = pauseButton;
	}
	
	public JButton getGame() {
		return Game;
	}

	public void setGame(JButton game) {
		Game = game;
	}

	public JButton getBuildMode() {
		return buildMode;
	}

	public void setBuildMode(JButton buildMode) {
		this.buildMode = buildMode;
	}

	public void dispose() {
		frame.dispose();
	}
	
	public JCheckBox getDeleteBox() {
		return this.deleteBox;
	}
	
	public JButton getRestartButton() {
		return this.restartButton;
	}
	
	public JButton getLoginButton(){
		return loginButton;
	}

	public JButton getLogoutButton() {
		return logoutButton;
	}
	
	
}