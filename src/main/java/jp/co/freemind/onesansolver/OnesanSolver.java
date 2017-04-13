package jp.co.freemind.onesansolver;

public class OnesanSolver {

  private final int n;
  private final Node[][] grid;

  public OnesanSolver(int n) {
    this.n = n;
    grid = new Node[n + 1][n + 1];
    for (int x = 0; x <= n; x++) for (int y = 0; y <= n; y++) {
      grid[x][y] = new Node(n, grid, x, y, (x == n && y == n));
    }
  }

  public long solve() {
    boolean[][] visitMap = new boolean[n + 1][n + 1];
    visitMap[0][0] = true;
    Visitor visitor = new Visitor(visitMap);
    grid[0][1].accept(visitor);
    return visitor.getResult() * 2;
  }
}