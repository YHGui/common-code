package swordOffer.Problem18;

import lintcode.week3.TreeNode;

public class No18 {
    public static void main(String[] args) {

        TreeNode node1=new TreeNode(8);
        TreeNode node2=new TreeNode(8);
        TreeNode node3=new TreeNode(7);
        TreeNode node4=new TreeNode(9);
        TreeNode node5=new TreeNode(2);
        TreeNode node6=new TreeNode(4);
        TreeNode node7=new TreeNode(7);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;


        TreeNode a=new TreeNode(8);
        TreeNode b=new TreeNode(9);
        TreeNode c=new TreeNode(2);
        a.left = b;
        a.right = c;

        System.out.println(contains(node1, a));
    }

    private static boolean contains(TreeNode t1, TreeNode t2) {
        return check(t1, t2) || contains(t1.left, t2) || contains(t1.right, t2);
    }

    private static boolean check(TreeNode h, TreeNode t2) {
        if (null == t2) {
            return true;
        }

        if (null == h || h.val != t2.val) {
            return false;
        }

        return check(h.left, t2.left) && check(h.right, t2.right);
    }
}
