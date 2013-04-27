package me.bevilacqua.ld48.Mob;

import me.bevilacqua.ld48.InputHandler;
import me.bevilacqua.ld48.Level.Level;

public class Player extends Mob{

	private byte upID , downID , leftID , rightID;
	private int score;
//	private String collison;
	
	public Player(String imagePath , InputHandler handle , Level level) {
		super(imagePath , handle , level);
	}
	
	public int getScore() {
		return score;
	}

	@Override
	public byte Collision() { 
//		System.out.println(this.getX() / 32 + " , " + this.getY() / 32);
		try {
			if((this.getX() / 16) -1 > 0) {leftID = (byte) level.map.getTileId((this.getX() /16) -1, this.getY() / 16 , 0);}
			else leftID = -2;
			if(this.getY() / 16 - 1 > 0) {	upID = (byte) level.map.getTileId(this.getX() / 16  , (this.getY()/16) - 1 , 0);}
			else upID = -2;
			
			downID = (byte) level.map.getTileId((this.getX() / 16)  , (this.getY() / 16) + 1 , 0);
			rightID = (byte) level.map.getTileId((this.getX() /16) + 1 , (this.getY() / 16) , 0);
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("X: " + (this.getX()) /16 + " Y: " + ((this.getY() / 16)+1) + " ID: " + downID);
		
		return -3; //Error
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
