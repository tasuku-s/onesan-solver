package jp.co.freemind.onesansolver;

public class OnesanSolver {

  private final Node[][] grid;

  public OnesanSolver(int n) {
    grid = new Node[n + 1][n + 1];
    for (int x = 0; x <= n; x++) for (int y = 0; y <= n; y++) {
      grid[x][y] = new Node(grid, x, y);
    }
  }

  public long solve() {
    return 2 * grid[0][1].evaluate(grid[0][0].getPoint());
  }
}
