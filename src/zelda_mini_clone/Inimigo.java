package zelda_mini_clone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Inimigo extends Rectangle {

	public int spd = 4;
	public int right = 1, left = 0, up = 0, down = 0;
	
	public int curAnimation = 0;
	public int curFrames = 0, targetFrames = 15;
	
	public Inimigo(int x, int y) {
		super(x, y, 32, 32);
	}
	
	public void tick() {
		boolean moved = true;
		
		if(right == 1 && World.isFree(x+spd, y)) {
			x++;
		}
		
		if(moved) {
			curFrames++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;
				if(curAnimation == Spritesheet.inimigo_front.length) {
					curAnimation = 0;
				}
			}
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(Spritesheet.inimigo_front[curAnimation], x, y, 32, 32, null);
	}
	
}
