package jp.co.freemind.onesansolver;

public class Visitor {
  private final boolean[][] visitMap;
  private long count = 0;

  public Visitor(boolean[][] visitMap) {
    this.visitMap = visitMap;
  }

  public boolean visit(Node node) {
    visitMap[node.getX()][node.getY()] = true;

    if (node.isGoal()) {
      this.count++;
      return true;
    }

    return false;
  }

  public void leave(Node node) {
    visitMap[node.getX()][node.getY()] = false;
  }

  public long getResult() {
    return count;
  }

  public boolean isVisitable(int x, int y) {
    return !visitMap[x][y];
  }
}
