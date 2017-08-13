package week9.hw3.hw3.puzzle;

/**
 * Created by Katsura on 2017/4/30.
 */
public class SearchNode {
    public WorldState worldState;
    //the number of moves made to reach this world state from the initial state;
    public int number;
    public SearchNode prev;

    public SearchNode(WorldState worldState, int number, SearchNode prev) {
        this.worldState = worldState;
        this.number = number;
        this.prev = prev;
    }
}
