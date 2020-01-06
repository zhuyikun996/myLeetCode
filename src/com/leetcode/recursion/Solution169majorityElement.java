package com.leetcode.recursion;

import java.util.HashMap;
import java.util.Map;

public class Solution169majorityElement {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> mapNumAndCount = new HashMap<>();
        Map<Integer, Integer> mapNumAndMax = new HashMap<>();
        int count_max = 0;
        for (int i : nums) {
            int count = 0;
            if (mapNumAndCount.containsKey(i)){
                count = mapNumAndCount.get(i);
            }
            count++;//不管本来有没有，count都++
            mapNumAndCount.put(i,count);
            if (count > count_max){
                count_max = count;
                mapNumAndMax.put(count_max,i);
            }
        }
        return mapNumAndMax.get(count_max);
    }
}
