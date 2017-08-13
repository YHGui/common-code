package week10.hw4.hash;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class TestJankyOomage {
    private static class JankyOomage implements Oomage {
        private int val;

        @Override
        public void draw(double x, double y, double scalingFactor) {
            return;
        }

        @Override
        public int hashCode() {
            return val;
        }

        public static JankyOomage randomJankyOomage() {
            JankyOomage x = new JankyOomage();
            x.val = StdRandom.uniform(0, 2);
            return x;
        }

    }

    /** After you've written haveNiceHashCodeSpread,
     * run this and it should fail. */
    @Test
    public void testRandomOomagesHashCodeSpread() {
        List<Oomage> oomages = new ArrayList<>();
        int N = 10000;

        for (int i = 0; i < N; i += 1) {
            oomages.add(JankyOomage.randomJankyOomage());
        }

        assertTrue(OomageTestUtility.haveNiceHashCodeSpread(oomages, 10));
    }
}
