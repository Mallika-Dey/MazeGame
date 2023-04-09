package mazegame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.TimerTask;

import javax.swing.*;

import mazegame.maze.Draw;

public class GamePanel extends JPanel implements ActionListener {
	Timer timer; // action
	Random random;
	private char key;
	Draw draw;
	private long t0;

	GamePanel() {
		random = new Random();
		draw = new Draw();
		this.setFocusable(true);
		this.addKeyListener(new KeyListener());
		startGame();
	}

	public void startGame() {
		timer = new Timer(1000, this);
		timer.start();
		t0 = System.currentTimeMillis();
	}

	public void moveItem() {
		int status = draw.isMovePossible(key);
		if (status != 0) {
			draw.paintAgain(key);
			if (status == 2) {
				System.out.println("gamewin");
				this.timer.stop();
			}
		}
		key = '*';
	}

	public class KeyListener extends KeyAdapter {
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();
			if (keyCode == e.VK_LEFT || keyCode == e.VK_KP_LEFT)
				key = 'l';
			else if (keyCode == e.VK_UP || keyCode == e.VK_KP_UP)
				key = 'u';
			else if (keyCode == e.VK_RIGHT || keyCode == e.VK_KP_RIGHT)
				key = 'r';
			else if (keyCode == e.VK_DOWN || keyCode == e.VK_KP_DOWN)
				key = 'd';
			else
				key = '*';
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (System.currentTimeMillis() - t0 > 100000) {
			timer.stop();
			System.out.println("game over");
		}
		if (this.key != '*')
			moveItem();
	}

}
