package com.leetcode;

public class Solution69mySqrt {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;
        int l = 0, r = x, ans=1;
        while (l <= r) {
            int mid = (l+r)/2;
            if (mid == x/mid){
                return mid;
            }else if(mid > x/mid){
                r = mid - 1;
            }else {
                l = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }
}
