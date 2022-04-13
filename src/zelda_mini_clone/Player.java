package zelda_mini_clone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// O extends é para herdar tudo que tiver da classe informada.
// O Rectangle é uma classe própria do java e contém todo o sistema de manipulação de vetores(como o x,y) 
// e pode ter dimensões e também tem métodos de deteção de colisão etc.
public class Player extends Rectangle {

	public int spd = 4;
	public boolean right, up, down, left;	
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
//		Passando a posição e o tamanho do player.
	}
	
	public void tick() {
//		Movimentação do personagem
		if(right && World.isFree(x+spd, y)) {
			x += spd;
		} else if(left && World.isFree(x-spd, y)) {
			x -= spd;
		}
		
		if(up && World.isFree(x, y-spd)) {
			y -= spd;
		} else if(down && World.isFree(x, y+spd)) {
			y += spd;
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(Spritesheet.player_front, x, y, 32, 32, null);
//		Renderiza a imagem, passando a posição e o tamanho.
		
//		g.setColor(Color.blue);
		
//		g.fillRect(x, y, width, height);
//		Essas são as propriedades que já estão na classe Rectangle, o: x, y, width e height.
	}
	
}
