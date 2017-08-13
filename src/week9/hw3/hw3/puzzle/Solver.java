package week9.hw3.hw3.puzzle;

import edu.princeton.cs.algs4.MinPQ;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Katsura on 2017/5/1.
 */
public class Solver {
    public WorldState initState;
    public SearchNode initNode;

    public Solver(WorldState initState) {
        initNode = new SearchNode(initState, 0, null);
        this.initState = initState;
    }
    Map<WorldState, Integer> hash = new HashMap<>(16);
    Comparator<SearchNode> comp = new Comparator<SearchNode>() {
        @Override
        public int compare(SearchNode o1, SearchNode o2) {
            int distance1 = 0;
            if (hash.containsKey(o1.worldState)) {
                distance1 = hash.get(o1.worldState);
            } else {
                distance1 = o1.worldState.estimatedDistanceToGoal();
                hash.put(o1.worldState, distance1);
            }
            int num1 = o1.number + distance1;
            int distance2 = 0;
            if (hash.containsKey(o2.worldState)) {
                distance2 = hash.get(o2.worldState);
            } else {
                distance2 = o2.worldState.estimatedDistanceToGoal();
                hash.put(o2.worldState, distance2);
            }
            int num2 = o2.number + distance2;
            return num1 - num2;
        }
    };
    ArrayList<WorldState> listResult = new ArrayList<>();
    public int moves() {
        MinPQ<SearchNode> heap = new MinPQ<SearchNode>(comp);
        heap.insert(initNode);
        while (!heap.isEmpty()) {
            SearchNode temp = heap.delMin();
            //set.add(temp.worldState);
            if (temp.worldState.isGoal()) {
                int result = temp.number;
                WorldState[] list = new WorldState[result];
                for (int i = result - 1; i >= 0; i--) {
                    list[i] = temp.worldState;
                    temp = temp.prev;
                }
                for (int i = 0; i < list.length; i++) {
                    listResult.add(list[i]);
                }
                return result;
            }
            Iterable<WorldState> neighbors = temp.worldState.neighbors();
            for (WorldState neighbor : neighbors) {
                if (temp.prev == null || !neighbor.equals(temp.prev.worldState)) {
                    SearchNode newNode = new SearchNode(neighbor, temp.number + 1, temp);
                    heap.insert(newNode);
                }
            }
        }
        return -1;
    }
    public Iterable<WorldState> solution() {
        return listResult;
    }
}
