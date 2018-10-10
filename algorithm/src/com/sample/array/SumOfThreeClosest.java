package com.sample.array;

import java.util.Arrays;

/*
给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

例如，给定数组 nums = [-1，2，1，-4], 和 target = 1.

与 target 最接近的三个数的和为 2. (-1 + 2 + 1 = 2).

leetCode地址:
https://leetcode-cn.com/problems/3sum/
 * */
public class SumOfThreeClosest {
	public static void main(String args[]) {
		int result = new SumOfThreeClosest().threeSumClosest(new int[] {0,2,1,-3}, 1);
		System.out.println(result);
	}
	
    public int threeSumClosest(int[] nums, int target) {
        if(nums == null && nums.length == 0) {
        	    return -1;
        }
        int closest = 0;
        boolean isStart = false;
        Arrays.sort(nums);
        int left,right;
        for(int i = 0;i<nums.length - 2;i++) {
            left = i+1;
            right = nums.length-1;
            while(left < right) {
              	int sum = nums[i] + nums[left] + nums[right];
            	    if((closest == 0 && !isStart) || (Math.abs(sum-target) - Math.abs(closest-target))<=0) {
            	    	    if((closest + sum)/2 == target) {
            	    	    	    closest = closest > sum?sum:closest;
            	    	    }
            	        closest = nums[i] + nums[left] + nums[right];
            	        isStart = true;
            	    }
            	    if(sum < target) {
            	    	    left++;
            	    }else if(sum > target) {
            	    	    right--;
            	    }else {
            	    	    return sum;
            	    }
            }
        }
        return closest;
    }
}
