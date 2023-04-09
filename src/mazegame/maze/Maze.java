package mazegame.maze;

import java.util.Vector;
import java.util.Random;

public class Maze {

	private int[][] maze = new int[1000][1000];
	private int[] par = new int[1000001];
	private int size[] = new int[1000001];
	private int row, col, start, end;

	public Maze() {
		this.row = 31;
		this.col = 31;
		start = 0;
		createMaze();
	}

	public int getRow() {
		return this.row;
	}

	public int getCol() {
		return this.col;
	}

	public int[][] getMaze() {
		return maze;
	}

	public int isblocked(int x, int y) {
		if (x < 0 || y < 0 || x > this.row || y > this.col || this.maze[x][y] == 1)
			return 0;
		return (this.maze[x][y] == 0) ? 1 : 2;
	}

	private int find(int u) {
		if (this.par[u] == u)
			return u;
		return this.par[u] = find(this.par[u]);
	}

	private void union(int x, int y, int x1, int y1, int px, int py, int k, int k1, int pk) {
		if (this.size[k] > this.size[k1]) {
			this.par[k1] = this.par[k];
			this.par[pk] = this.par[k];
			this.size[k] += this.size[k1] + 1;
		} else {
			this.par[k] = this.par[k1];
			this.par[pk] = this.par[k1];
			this.size[k1] += this.size[k] + 1;
		}
		this.maze[x][y] = this.maze[x1][y1] = this.maze[px][py] = 0;
	}

	public void kruskal(Vector<Pair> wall) {
		Random rand = new Random();
		int sz = (int) wall.size();
		int lastCell = this.row * this.col;
		while (find(1) != find(lastCell)) {
			int i = rand.nextInt(sz);
			Pair in = wall.get(i);
			int x = in.k / row;
			int y = in.k % col;
			x = (y == 0) ? x - 1 : x;
			y = (y == 0) ? col - 1 : y - 1;
			if (in.d == 1) {
				int u = find(in.k - 1);
				int v = find(in.k + 1);
				if (u != v) {
					union(x, y - 1, x, y + 1, x, y, u, v, in.k);
					wall.remove(i);
					sz--;
				}
			} else if (in.d == 2) {
				int u = find(in.k - col);
				int v = find(in.k + col);
				if (u != v) {
					union(x - 1, y, x + 1, y, x, y, u, v, in.k);
					wall.remove(i);
					sz--;
				}

			}
		}
		this.maze[row - 1][col - 1] = 3;
	}

	private class Pair {
		int k, d;

		Pair(int k, int d) {
			this.k = k;
			this.d = d;
		}
	}

	public void createMaze() {
		Vector<Pair> wall = new Vector<Pair>();
		Random rand = new Random();
		int k = 1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++, k++) {
				this.par[k] = k;// rand.nextInt(10);
				size[k] = 1;
				if (k != (row * col) && !(j % 2 == 1 && i % 2 == 1) && (j % 2 == 1 || i % 2 == 1)) {
					if (j > 0 && j < col - 1 && i % 2 == 0)
						wall.add(new Pair(k, 1));
					if (i > 0 && i < row - 1 && j % 2 == 0)
						wall.add(new Pair(k, 2));
				}
				if (k != row * col && (i % 2 == 1 || j % 2 == 1))
					this.maze[i][j] = 1;
				else
					this.maze[i][j] = 0;
			}
		}

		kruskal(wall);
	}

}
