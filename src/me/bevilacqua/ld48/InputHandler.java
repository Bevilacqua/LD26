package me.bevilacqua.ld48;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class InputHandler {

	private GameContainer gc;
	private Input input;
	private boolean Left , Right , Up , Down , Jump , Action , Reset;
	
	public InputHandler(GameContainer gc) {
		this.gc = gc;
		this.init();
	}

	private void init() {
		input = gc.getInput();
	}
	
	public void update() {
		Left = Right = Up = Down = Jump = Action = false;
		keyDown();
	}
	
	private void keyDown() {
		if(input.isKeyDown(Input.KEY_W) ||input.isKeyDown(Input.KEY_UP))  Up = true;
		if(input.isKeyDown(Input.KEY_A) ||input.isKeyDown(Input.KEY_LEFT))  Left = true;
		if(input.isKeyDown(Input.KEY_D) ||input.isKeyDown(Input.KEY_RIGHT))  Right = true;
		if(input.isKeyDown(Input.KEY_S) ||input.isKeyDown(Input.KEY_DOWN))  Down = true;
		if(input.isKeyDown(Input.KEY_0)) Reset = true;
		if(input.isKeyDown(Input.KEY_SPACE)) Jump = true;
		if(input.isKeyDown(Input.KEY_ENTER)) Action = true;
	}
	
	public boolean Left() {
		return Left;		
	}
	public boolean Right() {
		return Right;		
	}
	public boolean Up() {
		return Up;		
	}
	public boolean Down() {
		return Down;		
	}
	public boolean Jump() {
		return Jump;		
	}
	public boolean Action() {
		return Action;		
	}

	public boolean Reset() {
		return Reset;
	}
}
