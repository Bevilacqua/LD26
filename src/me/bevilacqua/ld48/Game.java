package me.bevilacqua.ld48;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame  {

	public static final String NAME = "LD48| JEB_001";
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	
	//States id---------------------- {Just for reference}
	public static byte splashId = 0;
	public static byte menuId = 1;
	public static byte playId = 2;
	
	public Game() {
		super(NAME);
	}

	public static void main(String[] args) {
		
		try {
			AppGameContainer container = new AppGameContainer(new Game());
			container.setDisplayMode(WIDTH, HEIGHT, false); //TODO: Maybe make this full screen later? IDK
			container.start();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {		
		addState(new Splash());
		addState(new Menu());
		addState(new Play());
		enterState(splashId);
	}

}
