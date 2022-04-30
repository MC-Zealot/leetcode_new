package com.leetcode_2th;
/**
 * Count the number of prime numbers less than a non-negative number, n.
 * 
 * @author Zealot
 * @date 2016年6月15日 上午11:30:44 
 *
 */
public class CountPrimes {
	public int countPrimes(int n) {
		if(n<=2){
			return 0;
		}
		int res = 0;
		boolean[] isPrime = new boolean[n + 1];
		for(int i = 2; i < n; i++){
			if(isPrime[i]==false){
				res++;
				for(int j = i; j <=n; j=j+i){
					isPrime[j] = true;
				}
			}
			
		}
		return res;
    }
	public static void main(String[] args) {
		CountPrimes c = new CountPrimes();
		System.out.println(c.countPrimes(20));
	}
}
