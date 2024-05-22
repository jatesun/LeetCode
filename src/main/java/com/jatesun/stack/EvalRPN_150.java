package com.jatesun.stack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 注意：
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * 示例 2：
 * 输入：tokens = ["4","13","5","/","+"]
 * 输出：6
 * 解释：该算式转化为常见的中缀算术表达式为：(4 + (13 / 5)) = 6
 * 示例 3：
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：该算式转化为常见的中缀算术表达式为：
 * ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 * 提示：
 * 1 <= tokens.length <= 104
 * tokens[i] 是一个算符（"+"、"-"、"*" 或 "/"），或是在范围 [-200, 200] 内的一个整数
 * 逆波兰表达式：
 * 逆波兰表达式是一种后缀表达式，所谓后缀就是指算符写在后面。
 * <p>
 * 平常使用的算式则是一种中缀表达式，如 ( 1 + 2 ) * ( 3 + 4 ) 。
 * 该算式的逆波兰表达式写法为 ( ( 1 2 + ) ( 3 4 + ) * ) 。
 * 逆波兰表达式主要有以下两个优点：
 * <p>
 * 去掉括号后表达式无歧义，上式即便写成 1 2 + 3 4 + * 也可以依据次序计算出正确结果。
 * 适合用栈操作运算：遇到数字则入栈；遇到算符则取出栈顶两个数字进行计算，并将结果压入栈中
 */
public class EvalRPN_150 {

    public static void main(String[] args) {
        String[] tokens = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        EvalRPN_150 evalRPN_150 = new EvalRPN_150();
        System.out.println(evalRPN_150.evalRPN(tokens));
    }

    /**
     * 我们可以分析一下计算的规律，可以得出来数字总是以栈的方式存、取。而操作符则是以队列的形式存取。
     * 因此我们就可以有这样的思路，用栈存数字，用队列存操作符，然后开始循环
     * 需要注意的是 -与/操作，操作数的顺序问题，应该是后出栈操作前出栈。
     * 时间复杂度On。
     *
     * @param tokens
     * @return
     */
    public int evalRPN(String[] tokens) {
        Stack<Integer> numberStack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                Integer i1 = numberStack.pop();
                Integer i2 = numberStack.pop();
                numberStack.push(i1 + i2);
            } else if (s.equals("-")) {
                Integer i1 = numberStack.pop();
                Integer i2 = numberStack.pop();
                numberStack.push(i2 - i1);
            } else if (s.equals("*")) {
                Integer i1 = numberStack.pop();
                Integer i2 = numberStack.pop();
                numberStack.push(i1 * i2);

            } else if (s.equals("/")) {
                Integer i1 = numberStack.pop();
                Integer i2 = numberStack.pop();
                numberStack.push(i2 / i1);
            } else {
                numberStack.push(Integer.valueOf(s));
            }
        }
        return numberStack.peek();
    }


}






































