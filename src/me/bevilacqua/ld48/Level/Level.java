package me.bevilacqua.ld48.Level;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.tiled.TiledMap;

public class Level {
	
	private String mapPath;
	private String Name;
	
	private int height;
	private int width;
	
	private TiledMap map;
	
	public Level(String mapPath , String Name) throws SlickException {
		this.mapPath = mapPath;
		this.Name = Name;
		this.init();
	}

	private void init() throws SlickException {
		map = new TiledMap(mapPath);
		height = map.getHeight();
		width = map.getWidth();
		System.out.println("Loading map Name: " + Name + " Width: " + width + " Height: " + height);
	}
	
	public void render(int x , int y , int startX , int startY) {
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
}
