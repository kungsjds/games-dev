package zelda_mini_clone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

// O extends � para herdar tudo que tiver da classe informada.
// O Rectangle � uma classe pr�pria do java e cont�m todo o sistema de manipula��o de vetores(como o x,y) 
// e pode ter dimens�es e tamb�m tem m�todos de dete��o de colis�o etc.
public class Player extends Rectangle {

	public int spd = 4;
	public boolean right, up, down, left;	
	
	public Player(int x, int y) {
		super(x, y, 32, 32);
//		Passando a posi��o e o tamanho do player.
	}
	
	public void tick() {
//		Movimenta��o do personagem
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
//		Renderiza a imagem, passando a posi��o e o tamanho.
		
//		g.setColor(Color.blue);
		
//		g.fillRect(x, y, width, height);
//		Essas s�o as propriedades que j� est�o na classe Rectangle, o: x, y, width e height.
	}
	
}
