package jp.co.freemind.onesansolver;

public class Node {
  private final int n;
  private final Node[][] grid;
  private final int x;
  private final int y;
  private final boolean goal;

  public Node(int n, Node[][] grid, int x, int y, boolean goal) {
    this.n = n;
    this.grid = grid;
    this.x = x;
    this.y = y;
    this.goal = goal;
  }

  public int getX() {
    return x;
  }
  public int getY() {
    return y;
  }
  public boolean isGoal() {
    return goal;
  }

  public void accept(Visitor visitor) {
    visitor.visit(this);

    if (x > 0 && visitor.isVisitable(x - 1, y)) {
      grid[x - 1][y].accept(visitor);
    }
    if (y > 0 && visitor.isVisitable(x, y - 1)) {
      grid[x][y - 1].accept(visitor);
    }
    if (x < n && visitor.isVisitable(x + 1, y)) {
      grid[x + 1][y].accept(visitor);
    }
    if (y < n && visitor.isVisitable(x, y + 1)) {
      grid[x][y + 1].accept(visitor);
    }
    visitor.leave(this);
  }
}