package me.bevilacqua.ld48.Level;

import me.bevilacqua.ld48.Play;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Level {
	
	private String mapPath;
	private String Name;
	
	private int height;
	private int width;
	
	private String musicPath;
	private Music music;
	
	private int timer;
	private int elapsedTime;
	
	public TiledMap map; //I know i shouldn't do this sorry Java gods have mercy
	
	public Level(String mapPath , String Name , String musicPath , int timer ) throws SlickException {
		this.mapPath = mapPath;
		this.Name = Name;
		this.musicPath = musicPath;
		this.timer = timer;
		this.init();
	}

	private void init() throws SlickException {
		map = new TiledMap(mapPath);
		music = new Music(musicPath);
		height = map.getHeight();
		width = map.getWidth();
		System.out.println("Loading map Name: " + Name + " Width: " + width + " Height: " + height);
	}
	
	public void render(int x , int y , int startX , int startY , Graphics g) {
		if(music.playing() == false) music.loop();
		map.render(0, 0 , startX + x , startY + y , 100 , 100);
		g.drawString(" " + (float)((timer - elapsedTime) / 1000), 350 , 25);
	}
	
	public void failLevel() {
		music.stop();
	}
	
	public void update(int Delta) {
		if(elapsedTime > timer) {
			Play.lf = true;
		}
		elapsedTime += Delta;
	}
	
	public String getName() {
		return Name;
	}
	
	public String getMapPath() {
		return this.mapPath;
	}
	
	public String getSoundPath() {
		return this.musicPath;
	}
	
	public int getTimer() {
		return this.timer;
	}
	
	public int getHeight() {
		return height;
	}
	public int getWidth() {
		return width;
	}
	
	public void endMusic() {
		music.fade(1000, 0, true);
	}

	public void setElapsedTime(int i) {
		this.elapsedTime = i;
	}
}
