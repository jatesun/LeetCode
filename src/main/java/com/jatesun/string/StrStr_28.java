package com.jatesun.string;

/**
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * <p>
 * 提示：
 * 1 <= haystack.length, needle.length <= 104
 * haystack 和 needle 仅由小写英文字符组成
 */
public class StrStr_28 {
    public static void main(String[] args) {
        StrStr_28 strStr_28 = new StrStr_28();
//        System.out.println(strStr_28.strStr("sadbutsad","sad"));
        System.out.println(strStr_28.strStr("mississippi", "issip"));

    }

    /**
     * 牺牲空间，换取最直白的暴力法
     * 时间复杂度 O(n * m)
     * 空间 O(n + m)
     */
    public int strStr(String haystack, String needle) {
        // 获取 haystack 和 needle 的长度
        int n = haystack.length(), m = needle.length();
        // 将字符串转换为字符数组，方便索引操作
        char[] s = haystack.toCharArray(), p = needle.toCharArray();

        // 遍历 haystack 字符串
        for (int i = 0; i < n - m + 1; i++) {
            // 初始化匹配的指针
            int a = i, b = 0;
            // 循环检查 needle 是否在当前位置开始匹配
            while (b < m && s[a] == p[b]) {
                // 如果当前字符匹配，则移动指针
                a++;
                b++;
            }
            // 如果 b 等于 m，说明 needle 已经完全匹配，返回当前位置 i
            if (b == m) return i;
        }
        // 如果遍历完毕仍未找到匹配的子串，则返回 -1
        return -1;
    }

}


















