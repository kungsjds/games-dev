package zelda_mini_clone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

// O extends é para herdar tudo que tiver da classe informada.
// O Rectangle é uma classe própria do java e contém todo o sistema de manipulação de vetores(como o x,y) 
// e pode ter dimensões e também tem métodos de deteção de colisão etc.
public class Player extends Rectangle {

	public int spd = 4;
	public boolean right, up, down, left;	
	
	public int curAnimation = 0; 
	
	public int curFrames = 0, targetFrames = 15;
	
	public boolean movedUp, movedDown, movedRight, movedLeft;
	
	public static List<Bullet> bullets = new ArrayList<Bullet>();
			
	public boolean shoot = false;
	public char direction;
	
	public int dir = 1;
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
//		Passando a posição e o tamanho do player.
	}
	
	public void tick() {
//		Movimentação do personagem
		boolean moved = false;
		movedUp = false;
		movedDown = false;
		movedRight = false;
		movedLeft = false;
		
		if(right && World.isFree(x+spd, y)) {
			x += spd;
			moved = true;
			movedRight = true;
			dir = 1;
			direction = 'r';
		} else if(left && World.isFree(x-spd, y)) {
			x -= spd;
			moved = true;
			movedLeft = true;
			dir = -1;
			direction = 'l';
		}
		
		if(up && World.isFree(x, y-spd)) {
			y -= spd;
			moved = true;
			movedUp = true;
			dir = -1;
			direction = 'u';
		} else if(down && World.isFree(x, y+spd)) {
			y += spd;
			moved = true;
			movedDown = true;
			dir = 1;
			direction = 'd';
		}
		
//		Animação, mudando de sprite(imagem) para fazer a movimentação do player
		if(moved) {
			curFrames++;
			if(curFrames == targetFrames) {
				curFrames = 0;
				curAnimation++;				
				if(curAnimation == Spritesheet.player_front.length) {				
					curAnimation = 0;					
				} 
			}
		}
		
		if(shoot) {
			shoot = false;
			bullets.add(new Bullet(x, y, dir, direction));
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).tick();
		}
	}
	
	public void render(Graphics g) {
		if(movedDown) {
			g.drawImage(Spritesheet.player_front[curAnimation], x, y, 32, 32, null);
		} else if(movedUp) {
			g.drawImage(Spritesheet.player_back[curAnimation], x, y, 32, 32, null);
		} else if(movedRight) {
			g.drawImage(Spritesheet.player_right[curAnimation], x, y, 32, 32, null);
		} else {
			g.drawImage(Spritesheet.player_front[curAnimation], x, y, 32, 32, null);
		}
		
		for(int i = 0; i < bullets.size(); i++) {
			bullets.get(i).render(g);
		}
//		Renderiza a imagem, passando a posição e o tamanho.
		
//		g.setColor(Color.blue);
		
//		g.fillRect(x, y, width, height);
//		Essas são as propriedades que já estão na classe Rectangle, o: x, y, width e height.
	}
	
}
