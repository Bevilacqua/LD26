package me.bevilacqua.ld48;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.tiled.TiledMap;

public class Splash extends BasicGameState {
	
	public int elapsedTime;
	public final int Delay = 5000; 
	
	private Image splashImage;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		splashImage = new Image("res/Intro.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.yellow);
		splashImage.draw(400 - 32 * 3, 300 - 32 * 5, 5);
		g.drawString("Enter Title", 325, 300);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int Delta) throws SlickException {	

		elapsedTime += Delta;
		
		if(elapsedTime >= Delay) {
			sbg.enterState(1);
		}
	}

	@Override
	public int getID() {
		return 0;
	}

}
