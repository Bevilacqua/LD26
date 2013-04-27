package me.bevilacqua.ld48.Mob;

import me.bevilacqua.ld48.InputHandler;
import me.bevilacqua.ld48.Level.Level;

public class Player extends Mob{

	private int score;
	
	public Player(String imagePath , InputHandler handle , Level level) {
		super(imagePath , handle , level);
	}
	
	public int getScore() {
		return score;
	}

	@Override
	public boolean Collision() {
		return false;
	}
	
	public int getX() {
		return (int) this.x;
	}
	
	public int getY() {
		return (int) this.y;
	}
	
	public void addX(int ammount) {
		this.x += ammount;
	}
	
	public void addY(int ammount) {
		this.y += ammount;
	}
	
	public void resetXY() {
		this.x = 0;
		this.y = 0;
	}

}
