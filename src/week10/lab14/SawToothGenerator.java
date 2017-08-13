package week10.lab14;

import week10.lab14.lab14lib.Generator;

/**
 * Created by Katsura on 2017/5/11.
 */
public class SawToothGenerator implements Generator{
    private int state;
    private int period;

    public SawToothGenerator(int period) {
        this.state = 0;
        this.period = period;
    }

    @Override
    public double next() {
        state = state + 1;
        return normalize((state % period) * 1.0 / period);
    }

    private double normalize(double num) {
        return  2 * num - 1;
    }
}
