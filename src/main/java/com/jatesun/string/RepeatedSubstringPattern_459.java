package com.jatesun.string;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 示例 1:
 * 输入: s = "abab"
 * 输出: true
 * 解释: 可由子串 "ab" 重复两次构成。
 * 示例 2:
 * 输入: s = "aba"
 * 输出: false
 * 示例 3:
 * 输入: s = "abcabcabcabc"
 * 输出: true
 * 解释: 可由子串 "abc" 重复四次构成。 (或子串 "abcabc" 重复两次构成。)
 * 提示：
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 */
public class RepeatedSubstringPattern_459 {
    public static void main(String[] args) {
        RepeatedSubstringPattern_459 repeatedSubstringPattern_459 = new RepeatedSubstringPattern_459();
    }


    public boolean repeatedSubstringPattern(String s) {
        for (int i = 0; i < s.length() / 2; i++) {
            String tmp = s.substring(0, i + 1);
            int j = 0;
            while (j < s.length()) {
                if ((j + i + 1) > s.length()) return false;
                String inner = s.substring(j, j + i + 1);
                if (tmp.equals(inner)) {
                    if ((j + i + 1) == s.length()) {
                        return true;
                    } else {
                        j = j + i + 1;
                    }
                } else {
                    break;
                }
            }
        }
        return false;
    }
}
