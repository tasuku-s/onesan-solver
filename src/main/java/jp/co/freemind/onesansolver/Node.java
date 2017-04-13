package jp.co.freemind.onesansolver;

public class Node {
  private final boolean goal;
  private final long point;

  private final Index left;
  private final Index right;
  private final Index top;
  private final Index bottom;

  public Node(Node[][] grid, int x, int y) {
    int n = grid.length - 1;
    this.goal = n == x && n == y;
    this.point = 1L << (x + (n + 1) * y);

    this.left = x > 0 ? new Index(grid, x - 1, y) : null;
    this.right = x < n ? new Index(grid, x + 1, y) : null;
    this.top = y > 0 ? new Index(grid, x, y - 1) : null;
    this.bottom = y < n ? new Index(grid, x, y + 1) : null;
  }

  public long evaluate(long visitMap) {
    if (goal) return 1;

    visitMap = nextVisitMap(visitMap, point);
    return
      (isVisitable(left, visitMap) ? left.get().evaluate(visitMap) : 0)
    + (isVisitable(right, visitMap) ? right.get().evaluate(visitMap) : 0)
    + (isVisitable(top, visitMap) ? top.get().evaluate(visitMap) : 0)
    + (isVisitable(bottom, visitMap) ? bottom.get().evaluate(visitMap) : 0)
    ;
  }

  public long getPoint() {
    return point;
  }

  private static long nextVisitMap(long visitMap, long point) {
    return visitMap | point;
  }

  private static boolean isVisitable(Index index, long visitMap) {
    return index != null && (visitMap & index.get().getPoint()) == 0;
  }
}
