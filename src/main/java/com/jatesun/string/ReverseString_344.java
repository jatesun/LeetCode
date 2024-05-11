package com.jatesun.string;

import java.util.Arrays;

/**
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 示例 1：
 * 输入：s = ["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 * 示例 2：
 * 输入：s = ["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * 提示：
 * 1 <= s.length <= 105
 * s[i] 都是 ASCII 码表中的可打印字符
 */
public class ReverseString_344 {
    public static void main(String[] args) {
        ReverseString_344 reverseString_344 = new ReverseString_344();
        char[] s = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString_344.reverseString(s);
        System.out.println(Arrays.toString(s).toString());
    }

    /**
     * 本题的解题思路很简单，翻转其实就是首尾替换，可以使用首尾指针，向中间趋近，直到两个指针相遇
     */
    public void reverseString(char[] s) {
        char tmp = 'a';//临时字符
        int left = 0;
        int right = s.length - 1;
        while (left < right) {//结束的标志为两个指针相遇，相同说明是奇数长度，无需替换，left<right说明是偶数，也无需替换
            tmp = s[left];
            s[left] = s[right];
            s[right] = tmp;
            left++;
            right--;
        }
    }
}





















