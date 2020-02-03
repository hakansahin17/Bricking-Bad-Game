package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.LinkedList;

import main.Game;


public class UIController {

	public LinkedList<GUIGameObject> objects = new LinkedList<GUIGameObject>();
	int lives,score;
	boolean gameOver;
	
	public void render(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GUIGameObject temp = (GUIGameObject) objects.get(i);
			temp.render(g);
		}
		g.setColor(Color.black);
		g.setFont(new Font("TimesRoman",Font.PLAIN,22));
		g.drawString("Score: " + score, Game.WIDTH-270, Game.HEIGHT-80);
		g.drawString("Lives: " + lives, Game.WIDTH-90, Game.HEIGHT-80);
		if(gameOver) {
			g.setFont(new Font("TimesRoman",Font.PLAIN,48));
			g.drawString("GAME OVER", Game.WIDTH/2 - 160, Game.HEIGHT/2 - 24);
		}
	}

	public void addObject(GUIGameObject obj) {
		this.objects.add(obj);
	}

	public void removeObject(GUIGameObject obj) {
		this.objects.remove(obj);
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isGameOver() {
		return gameOver;
	}

	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}
	
	
	
	
}