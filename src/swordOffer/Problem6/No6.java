package swordOffer.Problem6;

import java.util.Arrays;

public class No6 {

    /**
     * 根据前序遍历和中序遍历构建二叉树
     * 首先根据前序遍历找到二叉树的root节点，然后在中序遍历中找到root节点，将其分为两部分
     * 递归的构建左子树和右子树
     * 递归出口：
     * @param preorder
     * @param inorder
     * @return
     * @throws Exception
     */
    private static BTreeNode constructTree(int[] preorder, int[] inorder) throws Exception{

        if (null == preorder || null == inorder || preorder.length == 0 || inorder.length == 0) {
            return null;
        }

        if (preorder.length != inorder.length) {
            throw new Exception("The length of preorder is not equal to the length of inorder");
        }

        BTreeNode root = new BTreeNode(preorder[0]);

        int index = getIndex(inorder, preorder[0]);

        if (1 == preorder.length ) {
            return root;
        }

        if (index > 0) {
            int[] pre = Arrays.copyOfRange(preorder, 1, index + 1);
            int[] in = Arrays.copyOfRange(inorder, 0, index);
            root.leftChild = constructTree(pre, in);
        }

        if (index < preorder.length - 1) {
            int[] pre = Arrays.copyOfRange(preorder, 1 + index, preorder.length);
            int[] in = Arrays.copyOfRange(inorder, index + 1, inorder.length);
            root.rightChild = constructTree(pre, in);
        }

        return root;
    }


    private static int getIndex(int[] inorder, int value) {
        int len = inorder.length;

        for (int i = 0; i < len; i++) {
            if (value == inorder[i]) {
                return i;
            }
        }

        return -1;
    }
}
