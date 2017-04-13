package jp.co.freemind.onesansolver;

public class Node {
  private final int n;
  private final Node[][] grid;
  private final int x;
  private final int y;
  private final boolean goal;
  private final long point;

  public Node(int n, Node[][] grid, int x, int y, boolean goal) {
    this.n = n;
    this.grid = grid;
    this.x = x;
    this.y = y;
    this.goal = goal;
    this.point = 1L << (x + (n + 1) * y);
  }

  public boolean isGoal() {
    return goal;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);

    if (x > 0 && visitor.isVisitable(grid[x - 1][y])) {
      grid[x - 1][y].accept(visitor);
    }
    if (y > 0 && visitor.isVisitable(grid[x][y - 1])) {
      grid[x][y - 1].accept(visitor);
    }
    if (x < n && visitor.isVisitable(grid[x + 1][y])) {
      grid[x + 1][y].accept(visitor);
    }
    if (y < n && visitor.isVisitable(grid[x][y + 1])) {
      grid[x][y + 1].accept(visitor);
    }
    visitor.leave(this);
  }

  public long getPoint() {
    return point;
  }
}
