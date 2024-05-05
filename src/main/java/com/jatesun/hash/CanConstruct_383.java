package com.jatesun.hash;

/**
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 * 提示：
 * 1 <= ransomNote.length, magazine.length <= 105
 * ransomNote 和 magazine 由小写英文字母组成
 */
public class CanConstruct_383 {
    public static void main(String[] args) {
        CanConstruct_383 canConstruct_383 = new CanConstruct_383();
        boolean result = canConstruct_383.canConstruct("aa", "aab");
        System.out.println(result);
    }

    /**
     * 题目比较简单，直接遍历两个字符串，将每个字母出现的次数+-1即可
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] result = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            result[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            result[magazine.charAt(i) - 'a']--;
        }
        for (int param : result) {
            if (param > 0) {
                return false;
            }
        }
        return true;
    }
}
