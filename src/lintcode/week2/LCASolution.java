package lintcode.week2;

/**
 * Created by Katsura on 2017/3/6.
 */
public class LCASolution {
    public class TreeNode {
        public int val;
        public TreeNode left, right;

        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == A || root == B || root == null) {
            return root;
        }
        TreeNode leftAncestor = lowestCommonAncestor(root.left, A, B);
        TreeNode rightAncestor = lowestCommonAncestor(root.right, A, B);

        if (leftAncestor != null && rightAncestor != null) {
            return root;
        }

        if (leftAncestor != null) {
            return leftAncestor;
        }

        if (rightAncestor != null) {
            return rightAncestor;
        }

        return null;
    }
}
