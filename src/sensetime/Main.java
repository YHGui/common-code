package sensetime;


import java.util.*;

class Element {
    int row;
    int col;
    int val;
    public Element(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int[][] arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        //System.out.println(arr);
        int range = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int left = 0;
        while (minIndex < n) {

        }
    }

    public static List<Integer> mergeKSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        if (arrays == null || arrays.length == 0) {
            return result;
        }
        int len = arrays.length;
        Comparator<Element> comparator1 = new Comparator<Element>() {
            public int compare(Element left, Element right) {
                return left.val - right.val;
            }
        };

        Queue<Element> minHeap = new PriorityQueue<Element>(len, comparator1);
        for (int i = 0; i < len; i++) {
            if (arrays[i].length > 0) {
                Element ele = new Element(i, 0, arrays[i][0]);
                minHeap.offer(ele);

            }
        }
        Element max = new Element(0, 0, Integer.MIN_VALUE);
        while (!minHeap.isEmpty()) {
            Element num = minHeap.poll();
            result.add(num.val);
            Iterator<Element> iterator = minHeap.iterator();
            while (iterator.hasNext()) {
                Element element = iterator.next();
                if (element.val > max.val) {
                    max = element;
                }
            }
            if (num.col + 1 < arrays[num.row].length) {
                Element newEle = new Element(num.row, num.col + 1, arrays[num.row][num.col + 1]);
                minHeap.offer(newEle);
            }
        }
        return result;
    }
}
