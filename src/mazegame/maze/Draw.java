package mazegame.maze;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;

public class Draw extends JPanel {
	private int pensz;
	private Maze maze;

	public Draw(int pensz, Maze maze) {
		super();
		this.pensz = pensz;
		this.maze = maze;
	}

	public void paintComponent(Graphics g) {
		int[][] mz = maze.getMaze();
		int row = maze.getRow();
		int col = maze.getCol();
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {
				if (i == 0 && j == 0) {
					g.setColor(Color.yellow);
				} else if (mz[i][j] == 0) {
					g.setColor(Color.white);
				} else if (mz[i][j] == 1)
					g.setColor(Color.black);
				else
					g.setColor(Color.blue);
				g.fillRect(i * 15, j * 15, 15, 15);
			}
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setSize(480, 507);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Maze mz = new Maze();
		Draw draw = new Draw(12, mz);
		frame.setLocation(600, 120);
		frame.add(draw);
		frame.setVisible(true);
	}
}
