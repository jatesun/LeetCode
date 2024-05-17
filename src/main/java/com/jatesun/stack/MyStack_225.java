package com.jatesun.stack;

import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * <p>
 * 实现 MyStack 类：
 * <p>
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * 注意：
 * 你只能使用队列的标准操作 —— 也就是 push to back、peek/pop from front、size 和 is empty 这些操作。
 * 你所使用的语言也许不支持队列。 你可以使用 list （列表）或者 deque（双端队列）来模拟一个队列 , 只要是标准的队列操作即可。
 * 示例：
 * 输入：
 * ["MyStack", "push", "push", "top", "pop", "empty"]
 * [[], [1], [2], [], [], []]
 * 输出：
 * [null, null, null, 2, 2, false]
 * 解释：
 * MyStack myStack = new MyStack();
 * myStack.push(1);
 * myStack.push(2);
 * myStack.top(); // 返回 2
 * myStack.pop(); // 返回 2
 * myStack.empty(); // 返回 False
 * 提示：
 * 1 <= x <= 9
 * 最多调用100 次 push、pop、top 和 empty
 * 每次调用 pop 和 top 都保证栈不为空
 * 进阶：你能否仅用一个队列来实现栈。
 */
public class MyStack_225 {
    private Queue<Integer> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        MyStack_225 myStack = new MyStack_225();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty()); // 返回 False
    }

    public MyStack_225() {

    }

    public void push(int x) {
        queue.add(x);
    }

    /**
     * 只用一个队列实现。将队列pop，再存一下就可以
     */
    public int pop() {
        int result = -1;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int tmp = queue.poll();
            if (i == size - 1) {
                result = tmp;
            } else {
                queue.add(tmp);
            }
        }
        return result;
    }

    public int top() {
        int result = -1;
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            int tmp = queue.poll();
            queue.add(tmp);
            if (i == size - 1) {
                result = tmp;
            }
        }
        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
