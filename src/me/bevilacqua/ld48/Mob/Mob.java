package me.bevilacqua.ld48.Mob;

import me.bevilacqua.ld48.InputHandler;
import me.bevilacqua.ld48.Level.Level;

import org.newdawn.slick.Image;

public abstract class Mob {

	protected float x , y;
	protected Image[] images = new Image[4];
	protected String imagePath;
	protected float pace = 1;
	protected InputHandler handle;
	protected Level level;
	protected int elapsedTime;
	protected final int DELAY = 5;
	protected byte dir; //AS always same directions
	
	protected byte upID , downID , leftID , rightID;
	protected boolean collideUP = true, collideDOWN , collideLEFT , collideRIGHT;
	
	protected final byte blockLength = 32;
	protected byte currentLengthL , currentLengthR , currentLengthU , currentLengthD;
	private int currentImage = 0; //0 = up 1 = left 2 = right 3 = down
	
	public Mob(Image[] images , int pace , InputHandler handle , Level level) {
		this.images = images;
		this.pace = pace;
		this.handle = handle;
		this.level = level;
	}
	
	public Mob(Image[] images , InputHandler handle , Level level) {
		this.images = images;
		this.handle = handle;
		this.level = level;
	}
	
	public abstract void move(int dir , int Delta);
	
	public void render() {
		images[currentImage].draw(Math.round(x), Math.round(y));
	}
	
	public byte update(int Delta) {
				
		currentImage = dir;
		
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
