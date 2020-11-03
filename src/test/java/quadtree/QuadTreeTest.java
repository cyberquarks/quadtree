package quadtree;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class QuadTreeTest {
  /**
   * Rigorous Test :-)
   */
  @Test
  public void shouldAnswerWithTrue() {
    int M = 4;
    int N = 16;

    QuadTree<Integer, String> st = new QuadTree<Integer, String>();

    // insert N random points in the unit square
    for (int i = 0; i < N; i++) {
      Integer x = (int) (100 * Math.random());
      Integer y = (int) (100 * Math.random());
      System.out.println("(" + x + ", " + y + ")");
      st.insert(x, y, "P" + i);
    }
    System.out.println("Done preprocessing " + N + " points");

    // do some range searches
    for (int i = 0; i < M; i++) {
      Integer xmin = (int) (100 * Math.random());
      Integer ymin = (int) (100 * Math.random());
      Integer xmax = xmin + (int) (10 * Math.random());
      Integer ymax = ymin + (int) (20 * Math.random());
      Interval<Integer> intX = new Interval<Integer>(xmin, xmax);
      Interval<Integer> intY = new Interval<Integer>(ymin, ymax);
      Interval2D<Integer> rect = new Interval2D<Integer>(intX, intY);
      System.out.println(rect + " : ");
      st.query2D(rect);
    }
    assertTrue(true);
  }
}
