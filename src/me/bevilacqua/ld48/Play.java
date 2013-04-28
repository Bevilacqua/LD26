package me.bevilacqua.ld48;

import me.bevilacqua.ld48.Level.Level;
import me.bevilacqua.ld48.Mob.Player;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Play extends BasicGameState {

	private Level level1 , level2 , level3 , level4 , level5;
	private Image p1 , p2 , p3 , p4;
	private static Sound levelSwitch;
	private Image[] images = new Image[4];
	private static float x , y;
	private InputHandler handler;
	private Player player;
	private static Level[] levels = new Level[5]; //TODO:adjust number of levels acourdingly
	private static byte currentLevel = 0;
	private static boolean switchin = false;
	private static boolean endGame;
	
	private byte playerMovementID = 0;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
		level1 = new Level("/res/Lvl1.tmx" , "Level1" , "/music/Levels/5.wav"); //Probably not lvl1 ... nevermind it is :)
		level2 = new Level("/res/Lvl2.tmx" , "Level2" , "/music/Levels/5.wav");
		level3 = new Level("/res/Lvl3.tmx" , "Level3" , "/music/Levels/5.wav");
		level4 = new Level("/res/Lvl4.tmx" , "Level4" , "/music/Levels/5.wav");
		level5 = new Level("/res/Lvl5.tmx" , "Level5" , "/music/Levels/5.wav");
		levels[0] = level1;
		levels[1] = level2;
		levels[2] = level3;
		levels[3] = level4;
		levels[4] = level5;
		
		p1 = new Image("/res/Mob/playerUp.png");
		p2 = new Image("/res/Mob/playerLeft.png");
		p3 = new Image("/res/Mob/playerRight.png");
		p4 = new Image("/res/Mob/player.png");
		images[0] = p1;
		images[1] = p2;
		images[2] = p3;
		images[3] = p4;
		
		levelSwitch = new Sound("/sfx/levelSwitch.wav");
		
		handler = new InputHandler(gc);
	
		player = new Player(images, handler , levels[currentLevel]);
		System.out.println( levels.length + " Levels");

	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
		if(!endGame) {
			levels[currentLevel].render(Math.round(x), Math.round(y), 0, 0);
		}
		player.render();
		g.drawString("ScrewDrivers: " + player.getScore() + " / 3",300 , 40);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int Delta) throws SlickException {	
		handler.update(); //That was terrifying DO NOT FORGET THIS!!!
		playerMovementID = player.update(Delta);

		if(switchin) {
			player = new Player(images , handler , levels[currentLevel]);
			switchin = false;
		}
		
		if(endGame) {
			System.out.println("DoubleConfirm");
			sbg.enterState(Game.endgameId);
			endGame = false;
		}
		
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
			if(y < levels[currentLevel].getHeight()) { 
				y += 1;
			}
		}
		
		if(playerMovementID == 2) {
			if(x < levels[currentLevel].getWidth()) {
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
	
	public static void switchLevel() {
		levels[currentLevel].endMusic();
		currentLevel++;
		if(currentLevel > levels.length - 1) {
			endGame = true;
			System.out.println("Going to endGame");
		} else {
			System.out.println("Switching to: " + levels[currentLevel].getName());
			resetXY();
			levelSwitch.play();
			switchin = true;
		}
	}
	
	public static void resetXY() {
		Play.x =0;
		Play.y =0;
	}
	
	@Override
	public int getID() {
		return 2;
	}

}
