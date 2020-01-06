package com.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s = "anagram", t = "nagaram"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: s = "rat", t = "car"
 * 输出: false
 * 说明:
 * 你可以假设字符串只包含小写字母。
 * <p>
 * 进阶:
 * 如果输入字符串包含 unicode 字符怎么办？你能否调整你的解法来应对这种情况？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-anagram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution242isAnagram {
    public boolean isAnagram(String s, String t) {
        //1.排序之后对比

        //2.使用map存储每个字母出现的个数
        Map<Character, Integer> map1 = new HashMap();
        Map<Character, Integer> map2 = new HashMap();

        for (Character character : s.toCharArray()) {
            if (map1.containsKey(character)) {
                int count = Integer.parseInt(map1.get(character).toString()) + 1;
                map1.put(character, count);
            } else {
                map1.put(character,1);
            }
        }
        for (Character character : t.toCharArray()) {
            if (map2.containsKey(character)) {
                int count = Integer.parseInt(map2.get(character).toString()) + 1;
                map2.put(character, count);
            } else {
                map2.put(character,1);
            }
        }
        if (map1.equals(map2)) {
            return true;
        } else {
            return false;
        }
    }
}
