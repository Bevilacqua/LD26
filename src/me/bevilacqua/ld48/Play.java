package me.bevilacqua.ld48;

import me.bevilacqua.ld48.Level.Level;
import me.bevilacqua.ld48.Mob.Player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

	private Level level;
	private static float x , y;
	private InputHandler handler;
	private Player player;
	
	private byte playerMovementID = -1;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		level = new Level("/res/Lvl1.tmx" , "Level1"); //Probably not lvl1 ...
		handler = new InputHandler(gc);
		player = new Player("/res/Mob/player.png" , handler , level);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		level.render(Math.round(x), Math.round(y), 0, 0);
		player.render();
		g.drawString(" " + playerMovementID, 150, 20);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int Delta) throws SlickException {	
		handler.update(); //That was terrifying DO NOT FORGET THIS!!!
		playerMovementID = player.update(Delta);
		
		if(playerMovementID != -1) 
		if(playerMovementID == 0) {
			if( y > 0 ) {
				y -= 1;
			}
		}
		
		if(playerMovementID == 1) {
			if(x > 0 ) {
				x -= 1;
			}
		}
		
		if(playerMovementID == 3) {
			if(y < level.getHeight() - 19 ) { //TODO: fix height limits
				y += 1;
			}
		}
		
		if(playerMovementID == 2) {
			if(x < level.getWidth() - 25 ) {
				x += 1;
			}
		}
		if(handler.Reset()) {
			x = 0;
			y= 0;
			player.resetXY();
		}

		
	}

	public static int getX() {
		return (int) x;
	}
	
	public static int getY() {
		return (int) y;
	}
	
	@Override
	public int getID() {
		return 2;
	}

}
