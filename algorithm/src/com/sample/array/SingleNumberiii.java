package com.sample.array;
/*
给定一个整数数组 nums，其中恰好有两个元素只出现一次，其余所有元素均出现两次。 找出只出现一次的那两个元素。

示例 :

输入: [1,2,1,3,2,5]
输出: [3,5]
注意：

结果输出的顺序并不重要，对于上面的例子， [5, 3] 也是正确答案。
你的算法应该具有线性时间复杂度。你能否仅使用常数空间复杂度来实现？

leetCode地址：
https://leetcode-cn.com/problems/single-number-iii/
 * */
public class SingleNumberiii {
	
	public static void main(String args[]) {
		System.out.println(new SingleNumberiii().singleNumber(new int[] {1,1,2,3}));
	}
	
    public int[] singleNumber(int[] nums) {
    	    if(nums == null || nums.length == 0) {
    	    	    return null;
    	    }
    	    int[] result = new int[2];
    	    int n = nums[0];
    	    for(int i = 1; i < nums.length; i++) {
    	    	    n ^= nums[i];
    	    }
    	    n = ntz(n);
    	    for(int i = 0; i < nums.length; i++) {
    	    	    if(((1 << n) & nums[i]) == 0) {
    	    	    	    result[0] ^= nums[i];
    	    	    }else {
    	            result[1] ^= nums[i];
    	    	    }
    	    }
        return result;
    }
    
    int ntz(int x) {
    	    int n;
    	    if(x == 0) {
    	    	    return 32;
    	    }
    	    n = 1;
    	    if((x & 0x0000FFFF) == 0) {
    	    	    n = n + 16;
    	    	    n = x >> 16;
    	    }
    	    
    	    if((x & 0x000000FF) == 0) {
    	    	    n = n + 8;
    	    	    x = x >> 8;
    	    }
    	    
    	    if((x & 0x0000000F) == 0) {
    	    	    n = n + 4;
    	    	    x = x >> 4;
    	    }
    	    
    	    if((x & 0x00000003) == 0) {
    	    	    n = n + 2;
    	    	    x = x >> 2;
    	    }
    	    
    	    return n - (x & 1);
    }
}
