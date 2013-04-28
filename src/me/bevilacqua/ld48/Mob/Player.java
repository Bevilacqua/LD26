package me.bevilacqua.ld48.Mob;

import me.bevilacqua.ld48.Game;
import me.bevilacqua.ld48.InputHandler;
import me.bevilacqua.ld48.Play;
import me.bevilacqua.ld48.Level.Level;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;

public class Player extends Mob{

	private int screwdrivers;
	private Sound coin , coin1 , death , death1;
	
	public Player(String imagePath , InputHandler handle , Level level) throws SlickException {
		super(imagePath , handle , level);
		coin = new Sound("/sfx/coin.wav");
		coin1 = new Sound("/sfx/coin1.wav");
		death = new Sound("/sfx/death.wav");
		death1 = new Sound("/sfx/death1.wav");
	}
	
	public int getScore() {
		return screwdrivers;
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
		float xt = 0 , yt = 0;
		
		try{
			for(int c = 0 ; c < 4 ; c++) {
				xt = ((this.getX() -1) / 16);
				yt = ((this.getY() -1) / 16);
				
				if((this.getX() / 16) -1 > 0) {leftID = (byte) level.map.getTileId((int)Math.round(xt) -1, (int)Math.round(yt) , 0);}
				else leftID = -2;
				if(this.getY() / 16 -1 > 0) {	upID = (byte) level.map.getTileId((int) Math.round(xt)  , (int) Math.round(yt) - 1 , 0);}
				else upID = -2;
				
				downID = (byte) level.map.getTileId((int) Math.round(xt)  , (int) Math.round(yt) + 1 , 0);
				rightID = (byte) level.map.getTileId((int) Math.round(xt) + 1 , (int) Math.round(yt) , 0);
			}
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
		
		double r =0;
		
		if(level.map.getTileId((int) Math.round(xt), Math.round(yt), 0) == 4) {
			this.resetXY();
			Play.resetXY();
			r = Math.random();
			if(r > 0.5d) {
				death.play();
			} else death1.play();
		}
		
		if(level.map.getTileId((int) Math.round(xt), Math.round(yt), 0) == 6 && this.handle.Action()) {
			if(screwdrivers >= 3) {
				Play.switchLevel();
				resetXY();
				System.out.println("confirm");
			} else {
				//TODO: print message explaining need for more srewdrivers
			}
		}

		
		if(level.map.getTileId((int)Math.round(xt) , (int)Math.round(yt) , 0) == 5) {
			screwdrivers++;
			level.map.setTileId((int)Math.round(xt), (int)Math.round(yt), 0, 1);
			r = Math.random();
			System.out.println(r);
			if(r >= 0.5d) {
				coin.play();
			} else coin1.play();
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
