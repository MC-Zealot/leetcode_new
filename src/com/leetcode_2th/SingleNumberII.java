package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月27日 下午3:20:50 
 *
 */
public class SingleNumberII {
	public int singleNumber(int[] A) {  
	    int[] digits = new int[32];  
	    for(int i=0;i<32;i++)  
	    {  
	        for(int j=0;j<A.length;j++)  
	        {  
	            digits[i] += (A[j]>>i)&1;  
	        }  
	    }  
	    int res = 0;  
	    for(int i=0;i<32;i++)  
	    {  
	        res += (digits[i]%3)<<i;  
	    }  
	    return res;  
	}  

}
