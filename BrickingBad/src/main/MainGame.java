package main;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import UI.Window;

public class MainGame {

	private Window a = new Window(Toolkit.getDefaultToolkit().getScreenSize(), "Breaking Bad", this);
	
	
	public MainGame() {
		
		a.getGame().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a.dispose();
				Game.setGame(new Game());
			}
		});
		
		a.getBuildMode().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				a.dispose();
				new BuildMode();
			}
		});
	}
	
	public static void main(String[] args) {
		
		new MainGame();
	}
	
	
}
