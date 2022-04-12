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
		if(right) {
			x += spd;
		} else if(left) {
			x -= spd;
		}
		
		if(up) {
			y -= spd;
		} else if(down) {
			y += spd;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
//		Essas são as propriedades que já estão na classe Rectangle.
	}
	
}
