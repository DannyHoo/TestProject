package com.code.algorithm.leecode.p0001;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author danny
 * @date 2020/6/3下午11:20
 */
public class Solution01 {
    public static void main(String[] args) {
        Date date=new Date();
        Long currentDateTime=date.getTime();

        Long currentTime=System.currentTimeMillis();

        System.out.println(currentDateTime);
        System.out.println(currentTime);

        int[] nums = new int[]{2, 7, 11, 15,9,88,109};
        int target = 118;
        int[] result = twoSum(nums, target);
        for (int i:result){
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        List<Integer> usedNums=new ArrayList<>();
        for (int i=0;i<nums.length;i++){
            for (int j=0;j<nums.length;j++){
                if (i==j){
                    continue;
                }
                if (nums[i]+nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[0];
    }
}
