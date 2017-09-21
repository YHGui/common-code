package recurit.ch6;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combinations {
    /**
     * generate all combinations and output them
     * @param data
     * @param n
     */
    public void combinations(List<Integer> selected, List<Integer> data, int n) {

        if (n == 0) {
            //output all selected elements
            for (Integer integer : selected) {
                System.out.print(integer);
                System.out.print(" ");
            }
            System.out.println();
            return;
        }
        if (data.isEmpty()) {
            return;
        }

        if (n < 0) {
            return;
        }
        //select 0 element
        selected.add(data.get(0));
        combinations(selected, data.subList(1, data.size()), n - 1);

        //unselect 0 element
        selected.remove(selected.size() - 1);
        combinations(selected, data.subList(1, data.size()), n);

    }

    public static void main(String[] args) {
        Combinations comb = new Combinations();
        comb.combinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 2);
        comb.combinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 1);
        comb.combinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4), 0);
        comb.combinations(new ArrayList<>(), Arrays.asList(1, 2, 3, 4, 5, 6, 7, 9), 4);
        comb.combinations(new ArrayList<>(), new ArrayList<>(), 2);
        comb.combinations(new ArrayList<>(), new ArrayList<>(), 0);
    }
}
