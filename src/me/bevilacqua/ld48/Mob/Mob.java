package me.bevilacqua.ld48.Mob;

import me.bevilacqua.ld48.InputHandler;
import me.bevilacqua.ld48.Level.Level;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class Mob {

	protected float x , y;
	protected Image image;
	protected String imagePath;
	protected float pace = 1;
	protected InputHandler handle;
	protected Level level;
	protected int elapsedTime;
	protected final int DELAY = 5;
	
	protected byte upID , downID , leftID , rightID;
	protected boolean collideUP = true, collideDOWN , collideLEFT , collideRIGHT;
	
	protected final byte blockLength = 32;
	protected byte currentLengthL , currentLengthR , currentLengthU , currentLengthD;
	
	public Mob(String imagePath , int pace , InputHandler handle , Level level) {
		this.imagePath = imagePath;
		this.pace = pace;
		this.handle = handle;
		this.level = level;
		this.init();
	}
	
	public Mob(String imagePath , InputHandler handle , Level level) {
		this.imagePath = imagePath;
		this.handle = handle;
		this.level = level;
		this.init();
	}

	protected void init() {
		try {
			image = new Image(imagePath);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
	
	public abstract void move(int dir , int Delta);
	
	public void render() {
		image.draw(Math.round(x), Math.round(y));
	}
	
	public byte update(int Delta) {
				
		if(elapsedTime > DELAY) {
			if(handle.Up() && this.collideUP == false) {
				move(0 , Delta);
			}
			if(handle.Down() && this.collideDOWN == false) {
				move(3 , Delta);
			}
			if(handle.Left() && this.collideLEFT == false) {
				move(1 , Delta);
			}
			if(handle.Right() && this.collideRIGHT == false) {
				move(2 , Delta);
			}
			elapsedTime = 0;
		}
		elapsedTime += Delta;
		if(currentLengthU >= blockLength) { currentLengthU = 0 ; return 0;}
		if(currentLengthL >= blockLength) { currentLengthL = 0 ; return 1;}
		if(currentLengthR >= blockLength) { currentLengthR = 0 ; return 2;}
		if(currentLengthD >= blockLength) { currentLengthD = 0 ; return 3;}
		
		else return -1;

	}
	
	public abstract void Collision();
}
