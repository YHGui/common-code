package learning01Test;

import learning01.Fibonacci;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Katsura on 2017/2/17.
 */
public class FibonacciTest {

    @Test
    public void testCreateFib() {
        Fibonacci fibonacci = new Fibonacci();

        Assert.assertArrayEquals(new int[]{1}, fibonacci.createFib(1));
        Assert.assertArrayEquals(new int[]{1, 1}, fibonacci.createFib(2));
        Assert.assertArrayEquals(new int[]{1, 1, 2}, fibonacci.createFib(3));
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3}, fibonacci.createFib(4));
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3}, fibonacci.createFib(5));
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8}, fibonacci.createFib(10));
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8, 13}, fibonacci.createFib(20));
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8, 13, 21}, fibonacci.createFib(30));
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34}, fibonacci.createFib(40));
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34}, fibonacci.createFib(50));
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55}, fibonacci.createFib(60));
        Assert.assertArrayEquals(new int[]{1, 1, 2, 3, 5, 8, 13, 21, 34, 55}, fibonacci.createFib(70));

    }
}
