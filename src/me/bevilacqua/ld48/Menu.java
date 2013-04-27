package me.bevilacqua.ld48;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {		
		g.setColor(Color.green);
		g.drawRoundRect(200, 200, 400, 100, 10);
		g.drawRoundRect(200 , 310 , 400 , 100 , 10 );
		g.setColor(Color.white);
		g.drawString("Start!", 350 , 250);
		g.drawString("QUIT :(", 350 , 350);

//		sbg.enterState(2);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int arg2) throws SlickException {
		Input input = gc.getInput();
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			if(input.getMouseX() > 200 && input.getMouseX() < 600) {
				if(input.getMouseY() > 200 && input.getMouseY() < 300) {
					sbg.enterState(2);
				}
			}
		}
		
		if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
			if(input.getMouseX() > 200 && input.getMouseX() < 600) {
				if(input.getMouseY() > 310 && input.getMouseY() < 410) {
					System.exit(0);
					System.out.println(".");
				}
			}
		}
		
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
