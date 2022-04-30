package com.leetCode._2th;


/**
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321
 *
 * @author Zealot
 * @date 2016年3月3日 下午8:41:31
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		boolean flag = false;
		if(x==0){
			return 0;
		}
		if(x<0){
			x=-x;
			flag = true;
		}
		StringBuffer sb = new StringBuffer();
		while(x>0){
			int digit = x % 10;
			sb.append(digit);
			x = x / 10;
		}
		int res = 0;
		try{

			res = Integer.parseInt(sb.toString());//整数越界
		}catch(Exception e){
			return res;
		}
		if(flag){
			res = -res;
		}
		return res;
	}
	/**
	 * 高端写法~~
	 * @date 2016年3月3日 下午9:08:43
	 * @param x
	 * @return
	 */
	public int reverse2(int x) {
		int result = 0;

		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if ((newResult - tail) / 10 != result) {//如果越界，则不会相等
				return 0;
			}
			result = newResult;
			x = x / 10;
		}

		return result;
	}
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(1534236469));
	}
}
