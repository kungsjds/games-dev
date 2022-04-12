package zelda_mini_clone;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Game extends Canvas implements Runnable, KeyListener {

	public static int WIDTH = 480, HEIGHT = 480;
	public Player player;
	
	public Game() {
//		Adiciona eventos de teclado. Os eventos foram criados no final do código, com o implements do KeyListener.
		this.addKeyListener(this);
		this.setPreferredSize(new Dimension(WIDTH, HEIGHT));
//		Tamanho da janela
		
//		Criando o player passando a posição
		player = new Player(0, 0);
	}
	
	public void tick() {
//		Aqui ficará tudo sobre a lógica do jogo, colisões, movimentação, etc
		player.tick();
	}
	
	public void render() {
//		Aqui ficará toda a renderização dos gráficos.
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
//			Otimização da parte gráfica.
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
//		Cria retângulos na tela.
		
		player.render(g);		
		
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
//		Abre a janela centralizada. Deve ficar após o frame.pack();
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		Quando fechar o JFrame o processo do java também finaliza, para não ocupar memória.
		
		frame.setVisible(true);
//		Deixar a janela visivel
		
		new Thread(game).start();
//		Loop. Procura o método run() dentro da classe informada, no caso game.
	}	
	
	@Override
	public void run() {
//		O loop é executado aqui dentro
		
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
//		Manter a execução da movimentação dentro da classe do Player, pois ele será executado dentro do loop do game e rodará em 60fps, como foi definido na Thread.
//		Aqui ficará apenas a execução da lógica dos eventos de cliques.
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
