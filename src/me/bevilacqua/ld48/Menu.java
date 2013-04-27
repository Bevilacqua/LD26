package me.bevilacqua.ld48;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Menu extends BasicGameState {

	public boolean startUp = false;
	
	private int elapsedTime;
	private final int Delay = 5000;
	private int pictureID = 0;
	
	private Image decom;
	private Image howTo;
	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		decom = new Image("/res/Decomission.png");
		howTo = new Image("/res/HowTo.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {		
		if(!startUp) {
			g.setColor(Color.green);
			g.drawRoundRect(200, 200, 400, 100, 10);
			g.drawRoundRect(200 , 310 , 400 , 100 , 10 );
			g.setColor(Color.white);
			g.drawString("Start!", 350 , 250);
			g.drawString("QUIT :(", 350 , 350);
		} else {
			if(pictureID == 0) {
				decom.draw();
			}
			if(pictureID ==1) {
				howTo.draw();
			}
		}
		
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int Delta) throws SlickException {
		Input input = gc.getInput();
		
		if(startUp) {
			if(pictureID == 0 && elapsedTime > Delay) {
				pictureID = 1;
				elapsedTime = 0;
			} if(pictureID == 1 && elapsedTime > Delay) {
				sbg.enterState(Game.playId);
			}
			elapsedTime += Delta;
			
		} else {
		
			if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
				if(input.getMouseX() > 200 && input.getMouseX() < 600) {
					if(input.getMouseY() > 200 && input.getMouseY() < 300) {
						startUp = true;
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
		
	}

	@Override
	public int getID() {
		return 1;
	}

}
