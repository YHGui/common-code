package week8.live;

/**
 * Created by Katsura on 2017/3/3.
 */
public class WeightedQuickUnionDSWithPathCompression implements  DisjointSets {
    int[] parent;
    int[] size;

    public WeightedQuickUnionDSWithPathCompression(int num) {
        parent = new int[num]; size = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = i;
            size[i] = 1;
        }

    }

    private int find(int p) {
        if (p == parent[p]) {
            return p;
        } else {
            parent[p] = find(parent[p]);
            return parent[p];
        }
    }

    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (i == j) return;
        if (size[i] < size[j]) {
            parent[i] = j; size[j] += size[i];
        } else {
            parent[j] = i; size[i] += size[j];
        }

    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
