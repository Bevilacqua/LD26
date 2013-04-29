package me.bevilacqua.ld48;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Splash extends BasicGameState {
	
	public int elapsedTime;
	public final int Delay = 7000; 
	
	private Image splashImage;
	private Music music;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1) throws SlickException {
		splashImage = new Image("res/Intro.png");
		music = new Music("/music/intro.wav");
		music.play();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		g.setColor(Color.yellow);
		splashImage.draw(400 - 32 * 3, 300 - 32 * 5, 5);
		g.drawString("            JEB_001\n\nCreated By: Jacob Bevilacqua \nFor LD48 #26", 250, 300);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int Delta) throws SlickException {	
		elapsedTime += Delta;
		
		if(elapsedTime >= Delay) {
			music.stop();
			sbg.enterState(Game.menuId);
		}
	}

	@Override
	public int getID() {
		return 0;
	}

}
