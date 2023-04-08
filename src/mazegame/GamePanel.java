package mazegame;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
	static final int SCREEN_WIDTH = 600;
	static final int SCREEN_HEIGHT = 1000;
	static final int UNIT_SIZE = 20;
	static final int GAME_UNIT = (SCREEN_WIDTH * SCREEN_HEIGHT) / UNIT_SIZE;
	static final int DELAY = 75;
	int targetX, targetY;
	boolean start = false;
	final int x[] = new int[GAME_UNIT];
	final int y[] = new int[GAME_UNIT];
	Timer timer;
	Random random;

	GamePanel() {
		random = new Random();
		this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
		this.setBackground(Color.white);
		this.setFocusable(true);
		this.addKeyListener(new MyKeyAdapter());
		startGame();
	}

	public void startGame() {
		createTarget();
		timer = new Timer(DELAY, this);
		start = true;
		timer.start();
	}

	public void PaintComponent(Graphics g) {

	}

	public void draw(Graphics g) {

	}

	public void createTarget() {

	}

	public void checkCollisions() {

	}

	public void gameover(Graphics g) {

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public class MyKeyAdapter extends KeyAdapter {
		public void keyPressed() {

		}
	}

}
