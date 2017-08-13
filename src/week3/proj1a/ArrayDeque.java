package week3.proj1a;

import week4.proj1b.katsura.Deque;

/**
 * Created by Katsura on 2017/2/27.
 */
public class ArrayDeque<T> implements Deque<T>{
    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    //tLength表示数组长度(原定为8，扩容后更新)
    private int tLength;

    public ArrayDeque() {
        tLength = 8;
        items = (T[]) new Object[tLength];
        size = 0;
        nextFirst = 0;
        nextLast = nextFirst + 1;
    }

    public ArrayDeque(int nextFirst) {
        tLength = 8;
        items = (T[]) new Object[tLength];
        size = 0;
        this.nextFirst = nextFirst;
        nextLast = nextFirst + 1;
    }

    public void addFirst(T t) {
        /**
         * 当nextFirst指针和nextLast指针相差1时，那么也就是还剩一个空未填满，开始扩容
         * 当元素数量大时，空间浪费可以忽略
         */
        //之前的想法经过debug出错，应该是两个指针相等时
        if (size == tLength) {
            resize();
        }

        int length = items.length;
        if (nextFirst == -1) {
            nextFirst = (nextFirst + length) % length;
        }
        items[nextFirst] = t;
        nextFirst -= 1;
        size += 1;
    }

    //扩容时将从nextFirst开始到nextLast的元素复制到下标从1开始nextLast
    /*然后将nextFirst设为0，nextLast设为index+1*/
    //此处有误，nextLast设为index，而非index+1
    private void resize() {
        int length = items.length;
        tLength = (int)(length * 1.5);
        T[] temp = (T[]) new Object[tLength];
//        for (int i = nextFirst + 1; items[i % length] != null ; i++) {
//            temp[index] = items[i % length];
//            index++;
//        }
        for (int index = 1; index <= length ; index++) {
            temp[index] = items[(nextFirst + 1 + index - 1) % length];
        }

        items = temp;
        nextFirst = 0;
        //nextLast = index + 1;//此处index++后并没有被用上，该下标元素并未赋值
        nextLast = length + 1;//此处应为index而非index+1
    }

    public void addLast(T t) {
        /**
         * 当nextFirst指针和nextLast指针相差1时，那么也就是还剩一个空未填满，开始扩容
         * 当元素数量大时，空间浪费可以忽略
         */
        //之前的想法经过debug出错，应该是两个指针相等时---20170228
        /*---------20170301-----------*/
        /*之前的想法又出现大错误，最后决定多添加一个field值tLength来表示当前array中数组的长度，初始为8扩容之后不断改变
        * 然后比较当前size和tLength值，相等时开始扩容*/
        if (size == tLength) {
            resize();
        }

        int length = items.length;
        if (nextLast == length) {
            nextLast = nextLast % length;
        }
        items[nextLast] = t;
        nextLast += 1;
        size += 1;
    }

    public T get(int index) {
        //按序得到index的值
        int num = nextFirst + 1 + index;
        if (num >= items.length) {
            num = num % items.length;
        }
        return items[num];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return  size == 0;
    }

    /*-------20170301------*/
    /*这里打印出错是因为当items中有null元素时就跳过
    同样若没有null元素，则会无限制print，这是错误的做法
    */
    /*
    public void printDeque() {
        int length = items.length;
        String result = "";
        for (int i = nextFirst + 1; items[i % length] != null ; i++) {
            result += items[i % length].toString() + "\n";
        }
        System.out.println(result);
    }*/

    @Override
    public void printDeque() {
        System.out.println(dequeToString());
    }

    private String dequeToString() {
        if (isEmpty()) {
            return "[ ]";
        } else {
            String result = "[ ";
            for (int i = 0; i < items.length; i++) {
                if (items[(nextFirst + 1 + i) % items.length] == null) {
                    continue;
                } else {
                    result += items[(nextFirst + 1 + i) % items.length] + " ";
                }
            }

            return result + "]";
        }
    }

    public T removeFirst() {
        int length = items.length;
        size -= 1;
        T result = null;
        if (nextFirst + 1 == length) {
            result = items[(nextFirst + 1) % length];
            items[(nextFirst + 1) % length] = null;
            nextFirst = (nextFirst + 1) % length;
        }

        result = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst += 1;

        return result;
    }

    public T removeLast() {
        int length = items.length;
        size -= 1;
        T result = null;
        if (nextLast == 0) {
            result = items[nextLast - 1 + length];
            items[nextLast - 1 + length] = null;
            nextLast = nextLast - 1 + length;
        }

        result = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast -= 1;

        return result;
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> adi = new ArrayDeque<>();
        adi.addFirst(1);
        adi.addFirst(5);
        adi.addLast(10);
        adi.addLast(3);
        adi.addFirst(6);
        adi.addLast(10);
        adi.addLast(3);
        adi.addFirst(6);
        adi.addLast(10);
        adi.addLast(3);
        adi.addFirst(6);

        adi.printDeque();

        adi.removeFirst();
        adi.printDeque();

        adi.removeLast();
        adi.printDeque();
    }
}
