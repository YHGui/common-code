package swordOffer.Problem7;

import java.util.Stack;

public class MyQueue {

    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<Integer>();
        stack2 = new Stack<Integer>();
    }

    /**
     * 将stack1的数据全部转移到stack2中
     */
    private void stack1ToStack2(){
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
    }

    /**
     * 压入stack1
     * @param element
     */
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /**
     * 如果stack2非空，直接出栈，否则将stack1的数转移到stack2中，然后出栈
     * @return
     */
    public int pop() {
        // write your code here
        if (stack2.empty()) {
            stack1ToStack2();
        }
        return stack2.pop();
    }

    /**
     * 如果stack2非空，直接获取第一个值，否则将stack1的数转移到stack2中然后获取第一个值
     * @return
     */
    public int top() {
        // write your code here
        if (stack2.empty()) {
            stack1ToStack2();
        }
        return stack2.peek();
    }
}
