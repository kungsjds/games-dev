package zelda_mini_clone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet;
	
	public static BufferedImage player_front;
	public static BufferedImage fireWall;
	
	public Spritesheet() {
		try {
//			Carrega a imagem.
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		player_front = Spritesheet.getSprite(0, 11, 16, 16);
		fireWall     = Spritesheet.getSprite(191, 185, 16, 16);
//		Chama o método para pegar a subImagem, dentro de uma imagem, nas coordenadas e dimensões informadas.
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
//		Pega a subImagem nas coordenadas(x,y) e o tamanho da dimensão dentro da imagem.
	}
}
