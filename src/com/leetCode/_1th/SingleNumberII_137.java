package com.leetCode._1th;

/**
 * Given an array of integers, every element appears three times except for one.
 * Find that single one.
 * 
 * Note: Your algorithm should have a linear runtime complexity. Could you
 * implement it without using extra memory?
 * 
 * @author Zealot
 * @date 2015年7月25日 下午6:16:12
 */
public class SingleNumberII_137 {
	public int singleNumber(int[] nums) {
		int ones = 0, twos = 0;
	    for(int i = 0; i < nums.length; i++){
	        ones = (ones ^ nums[i]) & ~twos;
	        twos = (twos ^ nums[i]) & ~ones;
	    }
	    return ones;
	}
	//遍历数组中每一个元素
	//计算每一个元素中，2进制中每一位加到一个总的数组里边，都加到一起之后，再与3取余，因为除了一个之外，都是出现了3次，只有那一个之出现了不到3次
	//最后数组转成数字
	public int singleNumber2(int[] A) {
        if(A == null || A.length == 0) return 0;
        int[] a = new int[32];
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < 32; j++) {
                if((A[i] & (1 << j)) != 0)
                    a[j] = (a[j] + 1) % 3;
            }
        }
        int result = 0;
        for(int i = 0; i < 32; i++) {
            if(a[i] > 0)
                result |= (a[i] << i);
        }
        return result;
    }
	public static void main(String[] args) {
		SingleNumberII_137 s = new SingleNumberII_137();
		int[] nums = {1,2,3,3,3,2,5,2,1,1};
		System.out.println(s.singleNumber2(nums));
//		System.out.println(77>>1);
//		System.out.println(4>>1);
//		System.out.println(Integer.toBinaryString(4).length());
//		System.out.println("123456".length());
	}
}
