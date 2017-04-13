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

  public long evaluate(long visitMap) {
    if (goal) return 1;

    visitMap = nextVisitMap(visitMap);
    long count = 0;
    if (x > 0 && isVisitable(grid[x - 1][y], visitMap)) {
      count += grid[x - 1][y].evaluate(visitMap);
    }
    if (y > 0 && isVisitable(grid[x][y - 1], visitMap)) {
      count += grid[x][y - 1].evaluate(visitMap);
    }
    if (x < n && isVisitable(grid[x + 1][y], visitMap)) {
      count += grid[x + 1][y].evaluate(visitMap);
    }
    if (y < n && isVisitable(grid[x][y + 1], visitMap)) {
      count += grid[x][y + 1].evaluate(visitMap);
    }
    return count;
  }

  public long getPoint() {
    return point;
  }

  private long nextVisitMap(long visitMap) {
    return visitMap | point;
  }

  private static boolean isVisitable(Node node, long visitMap) {
    return (visitMap & node.getPoint()) == 0;
  }
}
