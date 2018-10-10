package com.sample.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。

注意：答案中不可以包含重复的三元组。

例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，

满足要求的三元组集合为：
[
  [-1, 0, 1],
  [-1, -1, 2]
]
leetCode地址:
https://leetcode-cn.com/problems/3sum/
 * 
 * */
public class SumOfThree {
	
	public static void main(String args[]) {
		List<List<Integer>> list = new SumOfThree().threeSum(new int[] {0,0,0,0,0});
		System.out.println(list);
	}
	
	public List<List<Integer>> threeSum(int[] nums){
		List<List<Integer>> list = new ArrayList();
		if(nums == null || nums.length == 0) {
			return list;
		}
		Arrays.sort(nums);
		for(int i = 0;i<nums.length-2;i++) {
			if(i > 0 && nums[i] == nums[i-1]) {
				continue;
			}
			for(int left = i+1, right = nums.length-1; left< right;) {
				if(left > i + 1 && nums[left] == nums[left-1]) {
					left++;
					continue;
				}
				if(right < nums.length - 1 && nums[right] == nums[right + 1]) {
					right--;
					continue;
				}
				
				if((nums[i] + nums[left] + nums[right])<0) {
					left++;
				}else if((nums[i] + nums[left] + nums[right])>0) {
					right--;
				}else {
					List<Integer> items = new ArrayList();
					items.add(nums[i]);
					items.add(nums[left]);
					items.add(nums[right]);
					list.add(items);
					right--;
					left++;
				}
			}
		}
		return list;
	}
}
