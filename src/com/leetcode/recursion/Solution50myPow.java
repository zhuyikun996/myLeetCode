package com.leetcode.recursion;

import java.text.DecimalFormat;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/powx-n
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Solution50myPow {
    //递归
    public double myPow(double x, int n) {
        if (n < 0) {
            x = 1 / x;
            n = -n;
        }
        return fastPow(x, n);
    }

    private double fastPow(double t, int n) {
        if (n == 0) return 1;//这个判断一定要在递归函数里哇，不能放到主函数里
        double half = fastPow(t, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * t;
        }
    }

    //非递归
    public double myPowNotRecursion(double x, int n) {
        if (n < 0) {//当n<0的时候
            x = 1 / x;//x = 1/x;
            n = -n;//n = -n
        }
        double ans = 1;//结果的初始值
        double current_product = x;//2倍乘的基数
        for (int i = n;i>0;i/=2){//i从n到1，每次i变为i的二分之一
            if (i%2==1){//当i为奇数
                ans = ans * current_product;//类似于递归中的x*half*half的操作
            }
            current_product = current_product * current_product;//类似于递归中half*half的操作
        }
        return ans;
    }
}
