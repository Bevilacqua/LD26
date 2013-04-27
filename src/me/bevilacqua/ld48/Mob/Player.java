package me.bevilacqua.ld48.Mob;

import me.bevilacqua.ld48.Game;
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

	public void move(int Direction , int Delta) {
		if(y > 0) { 
			if(Direction == 0) {
				y -= pace;
				currentLengthU += pace;
			}
		}
		
		if(x > 0) {
			if(Direction == 1) { 
				x -= pace;
				currentLengthL += pace;
			}
		}
		
		if(x < Game.WIDTH - 32) {
			if(Direction == 2) { 
				x += pace;
				currentLengthR += pace;
			}
		}
		
		if(y < Game.HEIGHT - 32) { 
			if(Direction == 3) { 
				y += pace;
				currentLengthD += pace;
			}
			
		}		
	}
	
	@Override
	public void Collision() { 
		collideUP = collideDOWN = collideLEFT = collideRIGHT = false;
		try {
			if((this.getX() / 16) -1 > 0) {leftID = (byte) level.map.getTileId((this.getX() /16) -1, this.getY() / 16 , 0);}
			else leftID = -2;
			if(this.getY() / 16 -1 > 0) {	upID = (byte) level.map.getTileId(this.getX() / 16  , (this.getY()/16) - 1 , 0);}
			else upID = -2;
			
			downID = (byte) level.map.getTileId((this.getX() / 16)  , (this.getY() / 16) + 1 , 0);
			rightID = (byte) level.map.getTileId((this.getX() /16) + 1 , (this.getY() / 16) , 0);
		} catch(Exception e) {
			e.printStackTrace();
		}

		if(upID == 2 || upID == 3) {
			collideUP = true;
		}
		
		if(downID == 2 || downID == 3) {
			collideDOWN = true;
		}
		
		if(leftID == 2 || leftID == 3) {
			collideLEFT = true;
		}
		
		if(rightID == 2 || rightID == 3) {
			collideRIGHT = true;
		}

		
	
	}
	
	public byte update(int Delta) {
		try {
		Collision();
		} catch(NullPointerException e) {
			e.printStackTrace();
		}
		return super.update(Delta);
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
	
	public boolean collideUP() {
		return collideUP;
	}
	public boolean collideDOWN() {
		return collideDOWN;
	}
	public boolean collideLEFT() {
		return collideLEFT;
	}
	public boolean collideRIGHT() {
		return collideRIGHT;
	}

}
