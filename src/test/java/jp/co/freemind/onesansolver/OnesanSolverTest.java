package jp.co.freemind.onesansolver;

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class OnesanSolverTest {

  @DataPoints
  public static Fixture[] fixtures = {
    f(1, 2),
    f(2, 12),
    f(3, 184),
    f(4, 8512),
    f(5, 1262816),
    f(6, 575780564),
  };

  @Theory
  public void test(Fixture f) throws Exception {
    System.out.println("### evaluating " + f.n + " x " + f.n);
    long start = System.nanoTime();
    long actual = new OnesanSolver(f.n).solve();
    printTime(start);
    Assert.assertEquals(actual, f.expected);
  }

  private void printTime(long start) {
    long time = System.nanoTime() - start;

    String timeStr;
    if (time >= 1_000_000_000) {
      timeStr = (time / 1_000_000_000.0) + "s";
    }
    else if (time >= 1_000_000) {
      timeStr = (time / 1_000_000.0) + "ms";
    }
    else if (time >= 1_000) {
      timeStr = (time / 1_000.0) + "μs";
    }
    else {
      timeStr = time + "ns";
    }
    System.out.println("  spent time: " + timeStr);
  }


  private static Fixture f(int n, long expected) { return new Fixture(n, expected); }
  public static class Fixture {
    private final int n;
    private final long expected;
    public Fixture(int n, long expected) {
      this.n = n;
      this.expected = expected;
    }
  }
}
