package zelda_mini_clone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	public static int WIDTH = 640, HEIGHT = 480;
	public static int SCALE = 3;
	public World world;
	public Player player;		
	public List<Inimigo> inimigos = new ArrayList<Inimigo>();
	
	public Game() {
//		Adiciona eventos de teclado. Os eventos foram criados no final do c�digo, com o implements do KeyListener.
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//		Tamanho da janela
		new Spritesheet();
		
		world  = new World();
		
//		Cria o player passando a posi��o
		player = new Player(32, 32);		
		
		inimigos.add(new Inimigo(32, 32));
		
		inimigos.add(new Inimigo(32, 64));
	}
	
	public void tick() {
//		Aqui ficar� tudo sobre a l�gica do jogo, colis�es, movimenta��o, etc
		player.tick();
		
		for(int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).tick();
		}
	}
	
	public void render() {
//		Aqui ficar� toda a renderiza��o dos gr�ficos.
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
//			Otimiza��o da parte gr�fica.
		}
		
		Graphics g = bs.getDrawGraphics();
		
//		Cor verde
		g.setColor(new Color(0, 135, 13));
		g.fillRect(0, 0, WIDTH*SCALE, HEIGHT*SCALE);
//		Cria ret�ngulos na tela.
		
		player.render(g);		
		
		for(int i = 0; i < inimigos.size(); i++) {
			inimigos.get(i).render(g);
		}
		
		world.render(g);
		
		bs.show();
	}
	
	public static void main(String[] args) {
		Game game = new Game();
//		Instancia a classe game
		
		JFrame frame = new JFrame();
//		Janela do jogo
		
		frame.add(game);
		frame.setTitle("Mini Zelda");
		frame.pack();
//		Empacota tudo que foi feito no frame e calcula o tamanho certo da janela. 
		
		frame.setLocationRelativeTo(null);
//		Abre a janela centralizada. Deve ficar ap�s o frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Quando fechar o JFrame o processo do java tamb�m finaliza, para n�o ocupar mem�ria.
		
		frame.setVisible(true);
//		Deixar a janela visivel
		
		new Thread(game).start();
//		Loop. Procura o m�todo run() dentro da classe informada, no caso game.
	}	
	
	@Override
	public void run() {
//		O loop � executado aqui dentro
		
		while(true) {
			tick();
			render();			
	//		Executa o loop em 60fps
			try {
				Thread.sleep(1000/60);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
//		Manter a execu��o da movimenta��o dentro da classe do Player, pois ele ser� executado dentro do loop do game e rodar� em 60fps, como foi definido na Thread.
//		Aqui ficar� apenas a execu��o da l�gica dos eventos de cliques.
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = true;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = true;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = true;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = true;
		}
		
		if(e.getKeyCode() == KeyEvent.VK_Z) {
			player.shoot = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_RIGHT) {
			player.right = false;
		} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			player.left = false;
		}
		
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			player.up = false;
		} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			player.down = false;
		}
		
	}

	
	
}
