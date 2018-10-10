package com.sample.array;
/*
给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现了三次。找出那个只出现了一次的元素。
说明：
你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？
示例 1:

输入: [2,2,3,2]
输出: 3
示例 2:

输入: [0,1,0,1,0,1,99]
输出: 99

leetCode地址：
https://leetcode-cn.com/problems/single-number-ii/
 * */
public class SingleNumberii {
	
	public static void main(String arg[]) {
		System.out.println(new SingleNumberii().singleNumber1(new int[] {2,2,2,3}));
		System.out.println(new SingleNumberii().singleNumber2(new int[] {2,2,2,3,4,3,3}));
	}
	
    public int singleNumber1(int[] nums) {
    	    int result = 0;
        	int len = nums.length;
        for(int i = 0;i < 32;i++) {
        	    int bits = 0;
        	    for(int j = 0;j<len;j++) {
        	    	    bits += (nums[j]>>i) & 1;
        	    }
        	    if((bits % 3) != 0) {
        	    	    result |= (1<<i);
        	    }
        }
        return result;
    }
    
    public int singleNumber2(int[] nums) {
    		int ones = 0;
    		int twos = 0;
    		int threes = 0;
    		for(int i = 0;i<nums.length;i++) {
    			twos |= ones & nums[i];
    			ones ^= nums[i];
    			threes = twos & ones;
    			twos &= ~threes;
    			ones &= ~threes;
    		}
     	return ones;
    }
}
