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
	
	protected void move(int Direction) {
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
		
		if(y < level.getWidth()) {
			if(Direction == 2) { 
				x += pace;
				currentLengthR += pace;
			}
		}
		
		if(y < level.getHeight()) {
			if(Direction == 3) { 
				y += pace;
				currentLengthD += pace;
			}
			
		}		
	}
	
	public void render() {
		image.draw(Math.round(x), Math.round(y));
	}
	
	public byte update() {
		if(handle.Up()) {
			move(0);
		}
		if(handle.Down()) {
			move(3);
		}
		if(handle.Left()) {
			move(1);
		}
		if(handle.Right()) {
			move(2);
		}
		System.out.println(currentLengthD);
		if(currentLengthU >= blockLength) { currentLengthU = 0 ; return 0;}
		if(currentLengthL >= blockLength) { currentLengthL = 0 ; return 1;}
		if(currentLengthR >= blockLength) { currentLengthR = 0 ; return 2;}
		if(currentLengthD >= blockLength) { currentLengthD = 0 ; return 3;}
		
		else return -1;

	}
	
	public abstract boolean Collision();
}
