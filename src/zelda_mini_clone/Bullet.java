package zelda_mini_clone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet extends Rectangle {

	public int dir = 1;
	public int speed = 8;
	public char direction;
	
//	Para otimização
	public int frames = 0;
	
	public Bullet(int x, int y, int dir, char direction) {
		super(x+16, y+16, 10, 10);
		this.dir = dir;
		this.direction = direction;
	}
	
	public void tick() {
		
		if(direction == 'u' || direction == 'd') {
			y += speed*dir;
		} else {
			x += speed*dir;
		}		
		
//		Para otimização. As bullets serão excluídas ao chegar em 60, que seria 60fps. Para não ficar ocupando memória.
		frames++;
		if(frames == 60) {
			Player.bullets.remove(this);
			return;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(Spritesheet.bullets, x, y, 20, 35, null);
		
//		g.setColor(Color.YELLOW);
//		g.fillOval(x, y, width, height);
	}
}
