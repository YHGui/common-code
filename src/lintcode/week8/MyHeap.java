package lintcode.week8;

/**
 * Created by Katsura on 2017/3/19.
 */
public class MyHeap {
    //Heap O(logn)插入一个元素
    // O(logn) poll() 拿上顶端元素
    // O(1) min/max peek()(不能同时获取最大最小值，minHeap最小，maxHeap最大)
    //（二叉树）结构特性：知道节点数量之后，那么它的结构就知道了，从左到右构成
    //minHeap 父节点比子节点值小 maxHeap反之
    //插入一个节点 先放在最下层可以放置的位置的最左端，每次都和自己的父节点调整，因此最多是调整树的高度，即复杂度为lognO()
    //poll() 先将根节点和最后一个节点交换，然后再修复O(logn)
    //删除任意节点，将最后一个节点覆盖待删除节点，然后修复
    //若删除要高效需要hashMap的支持 key为节点的值，value为index

    //整数数组就可以实现堆

    //二叉堆：父节点的键值总是大于或等于(小于或等于)任何一个子节点的键值 2.每个节点的左子树和右子树都是一个二叉堆

}
