package com.leetCode._1th;
/**
 * 
 * @author Zealot
我们以一个4个元素的数组为例，nums=[a1, a2, a3, a4]。 
想在O(n)时间复杂度完成最终的数组输出，res=[a2*a3*a4, a1*a3*a4, a1*a2*a4, a2*a3*a4]。

比较好的解决方法是构造两个数组相乘：

[1, a1, a1*a2, a1*a2*a3]
[a2*a3*a4, a3*a4, a4, 1]
 * @date 2015年7月19日 下午1:53:08
 */
public class ProductofArrayExceptSelf_238 {
	public int[] productExceptSelf(int[] nums) {
		int product = 1;
		for(int i = 0; i < nums.length; i++) {
			product = product*nums[i];
		}
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]!=0){
				nums[i]=product/nums[i];
			}else{
				nums[i]=0;
			}
		}
		return nums;
	}
	public int[] productExceptSelf2(int[] nums) {
		int product = 1;
		int[] result = new int[nums.length];
		result[0]=1;
		for(int i = 1; i < nums.length; i++) {
			 product= product*nums[i-1];
			 result[i] = product;
		}
		product =1;
		for(int i = nums.length-1; i >0; i--) {
			 product= product*nums[i];
//			 System.out.print(product+ ", ");
			 result[i-1] = product*result[i-1];
		}
		for(int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
			
		}
		return result;
	}
	public static void main(String[] args) {
		int[]	a ={1,0};
		ProductofArrayExceptSelf_238 p = new ProductofArrayExceptSelf_238();
		p.productExceptSelf2(a);
	}
}
