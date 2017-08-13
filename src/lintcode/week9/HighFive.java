package lintcode.week9;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by Katsura on 2017/4/8.
 */
public class HighFive {
    public Map<Integer, Double> highFive(Record[] results) {
        int COUNT = 5;
        Comparator<Record> cmp = new Comparator<Record>() {
            public int compare(Record record1, Record record2) {
                return record1.score - record2.score;
            }
        };
        Map<Integer, PriorityQueue<Record>> map = new HashMap<Integer, PriorityQueue<Record>>();
        for (Record record : results) {
            if (!map.containsKey(record.id)) {
                PriorityQueue<Record> minHeap = new PriorityQueue<Record>(COUNT, cmp);
                minHeap.offer(record);
                map.put(record.id, minHeap);
                continue;
            }
            PriorityQueue<Record> tempHeap = map.get(record.id);
            tempHeap.offer(record);
            if (tempHeap.size() > COUNT) {
                tempHeap.poll();
            }
            map.put(record.id, tempHeap);
        }
        Map<Integer, Double> hfResult = new HashMap<Integer, Double>();
        for (Integer id : map.keySet()) {
            double sum = 0.0;
            PriorityQueue<Record> tempHeap = map.get(id);
            while (!tempHeap.isEmpty()) {
                sum += tempHeap.poll().score;
            }
            hfResult.put(id, sum / 5);
        }
        return hfResult;
    }

    public static void main(String[] args) {
        HighFive highFive = new HighFive();
        Record[] results = {new Record(1,91),new Record(1,92),new Record(2,93),
                            new Record(2,99),new Record(2,98),new Record(2,97),
                            new Record(1,60),new Record(1,58),new Record(2,100),
                            new Record(1,61)};
        Map<Integer, Double> out = highFive.highFive(results);
    }
}
