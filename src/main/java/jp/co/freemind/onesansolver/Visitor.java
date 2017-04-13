package jp.co.freemind.onesansolver;

public class Visitor {
  private long visitMap;
  private long count = 0;

  public Visitor(long visitMap) {
    this.visitMap = visitMap;
  }

  public boolean visit(Node node) {
    visitMap = visitMap | node.getPoint();

    if (node.isGoal()) {
      this.count++;
      return true;
    }

    return false;
  }

  public void leave(Node node) {
    visitMap = visitMap & (~node.getPoint());
  }

  public long getResult() {
    return count;
  }

  public boolean isVisitable(Node node) {
    return (visitMap & node.getPoint()) == 0;
  }
}
