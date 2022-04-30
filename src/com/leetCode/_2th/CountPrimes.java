package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:

Count the number of prime numbers less than a non-negative number, n.
 * 
 * @author Zealot
 * @date 2016年4月3日 下午4:28:56 
 *
 */
public class CountPrimes {
	public int countPrimes(int n) {
		int res = 0;
		for(int i = 0; i < n; i++){
			if(isPrime(i)){
				res++;
			}
		}
		return res;
    }
	private static boolean isPrime(int num) {
		if(num<2){
			return false;
		}
		for(int i = 2; i * i <= num; i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	public int countPrimes2(int n) {
		List<Boolean> a = new ArrayList<Boolean>();
		for(int i = 0; i < n; i++){
			a.add(false);
		}
		for(int i = 2; i < n; i ++) {
			if(isPrime(i)){
				markNotPrime(i, a);
			}
		}
		int size = 0;
		for(int i = 0; i < a.size() -1; i++) {
			if(a.get(i)==false){
				size++;
			}
		}
		return size-1;
	}
	private void markNotPrime(int num, List<Boolean> a) {
		for(int i = 2; num * i <= a.size();  i++){
			a.set(i * num - 1, true);
		}
	}

	public int countPrimes3(int n) {
		boolean notPrime[] = new boolean[n + 2];
		notPrime[0] = notPrime[1] = true;
		for (int i = 2; i * i < n; i++) {
			if (!notPrime[i]) {
				int c = i * i;
				while (c < n) {
					notPrime[c] = true;
					c += i;
				}
			}
		}
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (!notPrime[i])
				ans++;
		}
		return ans;
	}
	public static void main(String[] args) {
		CountPrimes cp = new CountPrimes();
		System.out.println(cp.countPrimes2(12));
	}
}
