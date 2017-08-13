package week10.lab14;

import week10.lab14.lab14lib.Generator;

/**
 * Created by Katsura on 2017/5/11.
 */
public class StrangeBitwiseGenerator implements Generator{
    private int state;
    private int period;

    public StrangeBitwiseGenerator(int period) {
        this.state = 0;
        this.period = period;
    }

    @Override
    public double next() {
        state = state + 1;
        int weirdState = state & (state >>> 3) & (state >>> 8) % period;
        return normalize((weirdState % period) * 1.0 / period);
    }

    private double normalize(double num) {
        return  2 * num - 1;
    }
}
