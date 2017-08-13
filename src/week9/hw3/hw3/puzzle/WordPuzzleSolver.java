package week9.hw3.hw3.puzzle;

import edu.princeton.cs.introcs.StdOut;

public class WordPuzzleSolver {
//    public WorldState initState;
//    public SearchNode initNode;
//
//    public WordPuzzleSolver(WorldState initState) {
//        initNode = new SearchNode(initState, 0, null);
//        this.initState = initState;
//    }
    /***********************************************************************
     * Test routine for your Solver class. Uncomment and run to test
     * your basic functionality. Make sure to set your current working directory
     * to be the one containing words10000.txt.
     **********************************************************************/
    public static void main(String[] args) {
        String start = "horse";
        String goal = "nurse";
        Word startState = new Word(start, goal);
        Solver solver = new Solver(startState);
        StdOut.println("Minimum number of moves = " + solver.moves());
        for (WorldState ws : solver.solution()) {
            StdOut.println(ws);
        }
    }
//    Map<WorldState, Integer> hash = new HashMap<>(16);
//    Comparator<SearchNode> comp = new Comparator<SearchNode>() {
//        @Override
//        public int compare(SearchNode o1, SearchNode o2) {
//            int distance1 = 0;
//            if (hash.containsKey(o1.worldState)) {
//                distance1 = hash.get(o1.worldState);
//            } else {
//                distance1 = o1.worldState.estimatedDistanceToGoal();
//                hash.put(o1.worldState, distance1);
//            }
//            int num1 = o1.number + distance1;
//            int distance2 = 0;
//            if (hash.containsKey(o2.worldState)) {
//                distance2 = hash.get(o2.worldState);
//            } else {
//                distance2 = o2.worldState.estimatedDistanceToGoal();
//                hash.put(o2.worldState, distance2);
//            }
//            int num2 = o2.number + distance2;
//            return num1 - num2;
//        }
//    };
//    //Set<WorldState> set = new HashSet<>();//为什么通过hashSet去重失败呢？
//    ArrayList<WorldState> listResult = new ArrayList<>();
//    private int moves() {
//        MinPQ<SearchNode> heap = new MinPQ<SearchNode>(comp);
//        heap.insert(initNode);
//        while (!heap.isEmpty()) {
//            SearchNode temp = heap.delMin();
//            //set.add(temp.worldState);
//            if (temp.worldState.isGoal()) {
//                int result = temp.number;
//                WorldState[] list = new WorldState[result];
//                for (int i = result - 1; i >= 0; i--) {
//                    list[i] = temp.worldState;
//                    temp = temp.prev;
//                }
//                for (int i = 0; i < list.length; i++) {
//                    listResult.add(list[i]);
//                }
//                return result;
//            }
//            Iterable<WorldState> neighbors = temp.worldState.neighbors();
//            for (WorldState neighbor : neighbors) {
////                if (set.contains(neighbor)) {
////                    continue;
////                }
////                SearchNode newNode = new SearchNode(neighbor, temp.number + 1, temp);
////                    heap.insert(newNode);
//
//                if (temp.prev == null || !neighbor.equals(temp.prev.worldState)) {
//                    SearchNode newNode = new SearchNode(neighbor, temp.number + 1, temp);
//                    heap.insert(newNode);
//                }
//            }
//        }
//        return -1;
//    }
//
//    private Iterable<WorldState> solution() {
//        return listResult;
//    }
}
