package zelda_mini_clone;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Spritesheet {

	public static BufferedImage spritesheet;
	
	public static BufferedImage[] player_front;
	public static BufferedImage[] player_back;
	public static BufferedImage[] player_left;
	public static BufferedImage[] player_right;
	
	public static BufferedImage bullets;
	
	public static BufferedImage flameWall;
	
	public Spritesheet() {
		try {
//			Carrega a imagem.
			spritesheet = ImageIO.read(getClass().getResource("/spritesheet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		player_front = new BufferedImage[2];
		player_back  = new BufferedImage[2];
		player_left  = new BufferedImage[2];
		player_right = new BufferedImage[2];
				
		player_front[0] = Spritesheet.getSprite(0, 11, 16, 16);
		player_front[1] = Spritesheet.getSprite(16, 11, 16, 16);
		
		player_back[0] = Spritesheet.getSprite(66, 11, 16, 16);
		player_back[1] = Spritesheet.getSprite(83, 11, 16, 16);
		
		player_right[0] = Spritesheet.getSprite(32, 11, 16, 16);
		player_right[1] = Spritesheet.getSprite(50, 11, 16, 16);
		
		flameWall = Spritesheet.getSprite(191, 185, 16, 16);
		bullets   = Spritesheet.getSprite(260, 185, 16, 16);
//		Chama o método para pegar a subImagem, dentro de uma imagem, nas coordenadas e dimensões informadas.
	}
	
	public static BufferedImage getSprite(int x, int y, int width, int height) {
		return spritesheet.getSubimage(x, y, width, height);
//		Pega a subImagem nas coordenadas(x,y) e o tamanho da dimensão dentro da imagem.
	}
}
