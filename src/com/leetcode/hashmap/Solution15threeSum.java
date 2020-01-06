package com.leetcode.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
 * <p>
 * 注意：答案中不可以包含重复的三元组。
 * <p>
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * <p>
 * 满足要求的三元组集合为：
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution15threeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        int len = nums.length;
        if (len < 3) return resultList;
        Arrays.sort(nums);//排序
        for (int i = 0; i < len - 2; i++) {//遍历 0->len-2,i取不到最后两个元素
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {//对i位置上的元素进行去重判断，如果是重复的元素就不需要进行操作
                int left = i + 1;//左指针，从i+1开始，向右移动
                int right = len - 1;//右指针，从数组最后一个元素开始，向左移动
                while (left < right) {
                    if (nums[i] + nums[left] + nums[right] == 0) {//当i left，right位置的值相加等于0
                        resultList.add(Arrays.asList(nums[i], nums[left], nums[right]));//把当前值加入到结果list中
                        while (left < right && nums[left] == nums[left + 1]) left++;//对left位置上的元素进行去重操作
                        while (left < right && nums[right] == nums[right - 1]) right--;//对right位置上的元素进行去重操作
                        left++;//移动left指针
                        right--;//移动right指针
                    } else if (nums[i] + nums[left] + nums[right] < 0) {//当i left，right位置的值相加小于0，则需要向右移动left指针
                        while (left < right && nums[left] == nums[left + 1]) left++;//移动left之前先判断left位置是否有重复，如果有重复，直接移动
                        left++;//将left指针向右移动，nums[i] + nums[left] + nums[right]的和趋向于0
                    } else {
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        right--;
                    }
                }
            }
        }
        return resultList;
    }
}
