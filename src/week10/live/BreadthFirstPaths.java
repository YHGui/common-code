package week10.live;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Katsura on 2017/5/2.
 */
public class BreadthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private void bfs(Graph G, int s) {
        Queue<Integer> fringe = new LinkedList<>();
        fringe.offer(s);
        marked[s] = true;
        while (!fringe.isEmpty()) {
            int v = fringe.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    fringe.offer(w);
                    marked[w] = true;
                    edgeTo[w] = v;
                }
            }
        }
    }
}
