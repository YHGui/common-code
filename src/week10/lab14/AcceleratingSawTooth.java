package week10.lab14;

import week10.lab14.lab14lib.Generator;

/**
 * Created by Katsura on 2017/5/11.
 */
public class AcceleratingSawTooth implements Generator{
    private int state;
    private int period;
    private double factor;

    public AcceleratingSawTooth(int period, double factor) {
        this.state = 0;
        this.period = period;
        this.factor = factor;
    }

    @Override
    public double next() {
        state = state + 1;
        if (state == period) {
            state = 0;
            period = (int)(period * factor);
        }
        return normalize((state % period) * 1.0 / period);
    }

    private double normalize(double num) {
        return  2 * num - 1;
    }
}
