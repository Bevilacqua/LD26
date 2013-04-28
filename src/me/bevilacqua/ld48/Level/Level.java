package me.bevilacqua.ld48.Level;

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
	
	public TiledMap map; //I know i shouldn't do this sorry Java gods have mercy
	
	public Level(String mapPath , String Name , String musicPath ) throws SlickException {
		this.mapPath = mapPath;
		this.Name = Name;
		this.musicPath = musicPath;
		this.init();
	}

	private void init() throws SlickException {
		map = new TiledMap(mapPath);
		music = new Music(musicPath);
		height = map.getHeight();
		width = map.getWidth();
		System.out.println("Loading map Name: " + Name + " Width: " + width + " Height: " + height);
	}
	
	public void render(int x , int y , int startX , int startY) {
		if(music.playing() == false) music.loop();
		map.render(0, 0 , startX + x , startY + y , 100 , 100);
	}
	
	public String getName() {
		return Name;
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
}
