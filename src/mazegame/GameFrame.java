package mazegame;

import javax.swing.JFrame;

import mazegame.maze.Draw;

public class GameFrame extends JFrame {
	public GameFrame() {
		GamePanel game = new GamePanel();
		//Draw dr=new Draw();
		this.setSize(480, 507);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocation(600, 120);
		this.setTitle("First Maze Game");
		this.add(game);
		this.add(game.draw);
		this.setVisible(true);

	}
}
