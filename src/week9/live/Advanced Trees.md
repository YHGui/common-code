#Advanced Trees
##Traversals
What one might call “tree iteration” is usually called “tree traversal.”(遍历)

###preOrder(先序)
```java
preOrder(BSTNode x) {
    if (x == null) return;
    print(x.key)
    preOrder(x.left)
    preOrder(x.right)
}
//We walk the graph, from top going counter-clockwise. Shout every time we pass the LEFT of a node
//用例：print文件目录
```
###inOrder(中序)
```java
inOrder(BSTNode x) {
    if (x == null) return;
    inOrder(x.left)
    print(x.key)
    inOrder(x.right)
}
//Shout when you cross the bottom

```
###postOrder(后序)
```java
postOrder(BSTNode x) {
    if (x == null) return;
    postOrder(x.left)
    postOrder(x.right)
    print(x.key)
}
//Shout when you cross the right
//获取文件大小
```
###观察者模式(Visitor Pattern)
假设我们想实现通用的树遍历代码。在遍历的时候会实现不同的功能，此时为了重复编写代码，我们可以使用观察者模式。
```java
interface Action<Label> {
   void visit(Tree<Label> T);
}

class FindPig implements Action<String> {
   boolean found = false;
   void visit(Tree<String> T) {
      if ("pig".equals(T.label))
         { found = true; }
   }
}

void preorderTraverse(Tree<Label> T, Action<Label> whatToDo) {
   if (T == null) { return; }
   whatToDo.visit(T); /* before we hard coded a print */
   preorderTraverse(T.left, whatToDo);
   preorderTraverse(T.right, whatToDo);
}

preorderTraverse(someTree, new FindPig());
```
###层次遍历(level order traversal)
The Level Order Traversal is what you get if you read the nodes “like a book”, one level at a time.
