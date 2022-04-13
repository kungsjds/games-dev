package zelda_mini_clone;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class World {

	public static List<Block> bloco = new ArrayList<Block>();
	
	public World() {
//		Incluindo o bloco ao redor da janela do jogo.
		for(int xx = 0; xx < 15; xx++) {
			bloco.add(new Block(xx*32, 0));
		}		
		for(int xx = 0; xx < 15; xx++) {
			bloco.add(new Block(xx*32, 480-32));
		}
		
		for(int yy = 0; yy < 15; yy++) {
			bloco.add(new Block(0, yy*32));
		}
		for(int yy = 0; yy < 15; yy++) {
			bloco.add(new Block(480-32, yy*32));
		}
	
	}
	
	public static boolean isFree(int x, int y) {
//		Sistema de colisão.
		for(int i = 0; i < bloco.size(); i++) {
			Block blocoAtual = bloco.get(i);
//			O intersects verifica as colisões.
			if(blocoAtual.intersects(new Rectangle(x, y, 32, 32))) {
				return false;
			}
		}
		
		return true;
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < bloco.size(); i++) {
			bloco.get(i).render(g);
		}
	}
	
}
