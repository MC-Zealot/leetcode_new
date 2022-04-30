package com.leetCode._1th;

import java.util.Arrays;

public class Test3 {
	/**
	入参是一个整数数组，请用入参数组里的所有整数拼成一个最大整数并返回
	例如：输入：[12,21,13]
	     输出：211312 
	*/

	public String getMaxByArray(int[] a){
		StringBuffer reVal =new StringBuffer();
        Arrays.sort(a);
        for(int i = a.length - 1; i >= 0; i--){
             reVal.append((a[i]));
         }
        return reVal.toString();
	}
	
	public static void main(String[] args) {
		int[]	a = {223,22};
		Test3 t = new Test3();
		System.out.println(t.getMaxByArray(a));
	}
}
