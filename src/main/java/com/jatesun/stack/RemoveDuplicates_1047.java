package com.jatesun.stack;

import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * 示例：
 * 输入："abbaca"
 * 输出："ca"
 * 解释：
 * 例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * 提示：
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 */
public class RemoveDuplicates_1047 {
    public static void main(String[] args) {
        RemoveDuplicates_1047 removeDuplicates_1047 = new RemoveDuplicates_1047();
        String s = "abbaca";
        System.out.println(removeDuplicates_1047.removeDuplicates(s));
    }

    /**
     * 方法很简单，维护一个栈，从头开始入栈，跟栈顶的元素相比，相同：当前元素不入栈，且删除栈顶元素，不同：入栈。
     */
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (!stack.isEmpty()) {
                if (stack.peek().equals(c)) {
                    stack.pop();
                    continue;
                }
            }
            stack.add(c);
        }
        String stStr = stack.stream().map(s1 -> s1.toString()).collect(Collectors.joining(""));
        return stack.isEmpty() ? "" : stStr;
    }
}
