package jp.co.freemind.onesansolver;

public class Index {
  private final Node[][] grid;
  private final int x;
  private final int y;

  public Index(Node[][] grid, int x, int y) {
    this.grid = grid;
    this.x = x;
    this.y = y;
  }

  private Node cache;
  public Node get() {
    if (cache != null) return cache;
    return cache = grid[x][y];
  }
}
