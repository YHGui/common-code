package lintcode.week9;

import java.util.*;

/**
 * Created by Katsura on 2017/4/8.
 */
public class ExternalSort {
    //    1G内存对4G内存数据排序：sort 1G数据，然后merge
//    k路归并算法
    private Comparator<ListNode> ListNodeComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            // 从小到大 left - right 如果小于0 则不做变动
            return left.val - right.val;
        }
    };
//    使用minHeap，时间复杂度为nlogk N为K个链表一共有多少数
    public ListNode mergeKLists(List<ListNode> lists) {
    // write your code here
    if (lists == null | lists.size() == 0) {
        return null;
    }
    //最小堆
    Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), ListNodeComparator);
    for (int i = 0; i < lists.size(); i++) {
        if (lists.get(i) != null) {
            heap.add(lists.get(i));
        }
    }
    ListNode dummy = new ListNode(0);
    ListNode tail = dummy;
    while (!heap.isEmpty()) {
//            取出最小值
        ListNode head = heap.poll();
        // 不断的list的tail加新的数，poll的同时也不忘不断的offer head.next
        tail.next = head;
        tail = head;
        if (head.next != null) {
            heap.offer(head.next);
        }
    }
    return dummy.next;
}

    //version2 divide & conquer 时间复杂度为nlogk
    public ListNode mergeKLists2(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        return mergeHelper(lists, 0, lists.size() - 1);
    }
    private ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end) {
            return lists.get(start);
        }
        int mid = start + (end - start) / 2;
        ListNode left = mergeHelper(lists, start, mid);
        ListNode right = mergeHelper(lists, mid + 1, end);
        return mergeTwoLists(left, right);
    }
    private ListNode mergeTwoLists(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                tail.next = left;
                tail = left;
                left = left.next;
            } else {
                tail.next = right;
                tail = right;
                right = right.next;
            }
        }
        if (left != null) {
            tail.next = left;
        }
        if (right != null) {
            tail.next = right;
        }
        return dummy.next;
    }
    //version3 两两merge 时间复杂度为nlogk
    public ListNode mergeKLists3(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }
        while (lists.size() > 1) {
            List<ListNode> newLists = new ArrayList<ListNode>();
            for (int i = 0; i + 1 < lists.size(); i += 2) {
                ListNode result = mergeTwoLists(lists.get(i), lists.get(i + 1));
                newLists.add(result);
            }
            if (lists.size() % 2 == 1) {
                newLists.add(lists.get(lists.size() - 1));
            }
            lists = newLists;
        }
        return lists.get(0);
    }

}
