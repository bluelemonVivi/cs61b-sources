package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  @Test
  public static void testThreeAddThreeRemove() {
      AListNoResizing<Integer> correct = new AListNoResizing<>();
      BuggyAList<Integer> broken = new BuggyAList<>();

      correct.addLast(5);
      correct.addLast(10);
      correct.addLast(15);

      broken.addLast(5);
      broken.addLast(10);
      broken.addLast(15);

      assertEquals(correct.size(), broken.size());

      assertEquals(correct.removeLast(), broken.removeLast());
      assertEquals(correct.removeLast(), broken.removeLast());
      assertEquals(correct.removeLast(), broken.removeLast());
      }

    @Test
    public static  void randomizedTest() {
        AListNoResizing<Integer> Correct = new AListNoResizing<>();
        BuggyAList<Integer> Broken = new BuggyAList<>();

        int N = 5000;
        for (int i = 0; i < N; i += 1) {
            int operationNumber = StdRandom.uniform(0, 4);
            if (operationNumber == 0) {
                // addLast
                int randVal = StdRandom.uniform(0, 100);
                Correct.addLast(randVal);
                Broken.addLast(randVal);
                //System.out.println("addLast(" + randVal + ")");
            } else if (operationNumber == 1) {
                // size
                assertEquals(Correct.size(),Broken.size());
            } else if (Correct.size() == 0) {
                continue;
            } else if (operationNumber == 2) {
                assertEquals(Correct.removeLast(),Broken.removeLast());
            } else if (operationNumber == 3) {
                assertEquals(Correct.getLast(),Broken.getLast());
            }
        }
    }

      public static void main(String[] args) {
      randomizedTest();
      //testThreeAddThreeRemove();
  }

}
