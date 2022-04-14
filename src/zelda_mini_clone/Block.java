package zelda_mini_clone;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Block extends Rectangle {

	public Block(int x, int y){
		super(x, y, 32, 32);
	}
	
	public void render(Graphics g) {
		g.drawImage(Spritesheet.flameWall, x, y, 32, 32, null);
//		Renderiza a imagem passando a posição e o tamanho.
		
//		g.setColor(Color.MAGENTA);
//		g.fillRect(x, y, width, height);
//		g.setColor(Color.black);
//		g.drawRect(x, y, width, height);
//		drawRect preenche apenas a borda do retângulo.
	}
	
}
