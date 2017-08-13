package week8.live;

/**
 * Created by Katsura on 2017/3/3.
 */
public class WeighedQuickUnion implements DisjointSets {
    private int parent[];
    private int size[];

    public WeighedQuickUnion(int num) {
        parent = new int[num];
        size = new int[num];
        for (int i = 0; i < num; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }

    private int find(int p) {
        if (parent[p] != p) {
            p = parent[p];
        }

        return p;
    }
    @Override
    public void connect(int p, int q) {
        int i = find(p);
        int j = find(q);
        if (size[i] < size[j]) {
            parent[i] =j;
            size[j] += size[i];
        } else {
            parent[j] = i;
            size[i] += size[j];
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }
}
