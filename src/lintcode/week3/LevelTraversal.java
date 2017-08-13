package lintcode.week3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Katsura on 2017/3/18.
 */
public class LevelTraversal {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        //层与层之间的关系
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        //offer就是加入节点

        //
        while (!queue.isEmpty()) {
            ArrayList<Integer> level = new ArrayList<>();
            //取出size的值
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode head = queue.poll();
                level.add(head.val);
                //poll就是取出队头节点
                if (head.left != null) {
                    queue.offer(head.left);
                }
                if (head.right != null) {
                    queue.offer(head.right);
                }
            }
            results.add(level);
        }

        return results;
    }
}
