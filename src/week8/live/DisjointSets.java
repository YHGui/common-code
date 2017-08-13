package week8.live;

/**
 * Created by Katsura on 2017/3/3.
 */
public interface DisjointSets {
    void connect(int p, int q);

    boolean isConnected(int p, int q);
}
