package mazegame.maze;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.*;

public class Draw extends JPanel {
	private Maze maze;
	private Item item;

	public Draw() {
		super();
		this.setFocusable(true);
		this.setVisible(true);
		this.maze = new Maze();
		this.item = new Item(0, 0);
	}

	synchronized public void paintComponent(Graphics g) {
		int[][] mz = maze.getMaze();
		int row = maze.getRow();
		int col = maze.getCol();
		super.paintComponent(g);
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
		g.setColor(Color.RED);
		g.fillOval(item.getX() * 15, item.getY() * 15, 14, 14);
	}

	public int isMovePossible(char dir) {
		// row-->x, col-->y
		int x = this.item.getX();
		int y = this.item.getY();
		if (dir == 'l')
			x--;
		else if (dir == 'r')
			x++;
		else if (dir == 'u')
			y--;
		else if (dir == 'd')
			y++;
		else
			return 0;
		return maze.isblocked(x, y);
	}

	public void paintAgain(char dir) {
		int x = this.item.getX();
		int y = this.item.getY();
		if (dir == 'l')
			x--;
		else if (dir == 'r')
			x++;
		else if (dir == 'u')
			y--;
		else if (dir == 'd')
			y++;
		this.item.setX(x);
		this.item.setY(y);
		repaint();
	}
}
