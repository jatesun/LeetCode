package com.jatesun.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 * 示例 1:
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 提示:
 * 1 <= s.length, t.length <= 5 * 104
 * s 和 t 仅包含小写字母
 * 进阶: 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 */
public class IsAnagram_242 {
    public static void main(String[] args) {
//        String s = "anagram";
//        String t = "nagaram";
        String s = "fe";
        String t = "ja";
        IsAnagram_242 isAnagram242 = new IsAnagram_242();
        System.out.println(isAnagram242.isAnagram(s, t));
    }

    /**
     * 思路：
     * 1、将两个字符串分割为字母数组，for循环将每个字母出现的次数记录在map
     * 2、对比两个map是否相同。
     */
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        innerCal(s, sMap);
        innerCal(t, tMap);
        return sMap.equals(tMap);
    }

    private void innerCal(String str, Map<Character, Integer> map) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            Integer count = map.get(ch);
            if (count == null) {
                map.put(ch, 1);
            } else {
                count++;
                map.put(ch, count);
            }
        }
    }

    /**
     * 维护一个数据来判断是否相同。
     */
    public boolean isAnagram1(String s, String t) {
        int[] record = new int[26];
        for (int i = 0; i < s.length(); i++) {
            record[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            record[t.charAt(i) - 'a']--;
        }
        for (int count : record) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}
