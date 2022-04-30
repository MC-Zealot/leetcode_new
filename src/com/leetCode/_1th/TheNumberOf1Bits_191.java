package com.leetCode._1th;

/**
 * 
Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).

For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.

Credits:
Special thanks to @ts for adding this problem and creating all test cases.
 * @author Zealot
 *
 */
public class TheNumberOf1Bits_191 {
	// you need to treat n as an unsigned value
    public int hammingWeight(int n) {
    	int hammingWeight = 0;
		String aStr = Integer.toBinaryString(n);
		char[] cc = aStr.toCharArray();
		for(int i = 0; i < cc.length; i++) {
			if(cc[i]!='0'){
				hammingWeight++;
			}
		}
    	return hammingWeight;
    }
    @Deprecated
    public int hammingWeight2(int n) {
        int sum = 0;
        while(n!=0){
            if((n&1)==1){
                sum++;
            }
            System.out.println(n);
            n=n>>1;
        }
        return sum;
    }
    public int hammingWeight3(int n) {
        int sum = 0;
        while(n!=0){
            if((n&1)==1){
                sum++;
            }
            n >>>= 1;
        }
        return sum;
    }
    public static void main(String[] args) {
    	TheNumberOf1Bits_191 t = new TheNumberOf1Bits_191();
//    	System.out.println(t.hammingWeight3(-1));
    	System.out.println(-1>>>1);
//    	System.out.println(Integer.toBinaryString(16) );
	}
}
