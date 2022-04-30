package com.leetcode_2th;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月26日 下午3:14:10
 *
 */
public class GasStation {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		int[] diff = new int[gas.length];
		for (int i = 0; i < gas.length; ++i) {
			diff[i] = gas[i] - cost[i];
		}

		int leftGas = 0, sum = 0, startnode = 0;
		for (int i = 0; i < gas.length; ++i) {
			leftGas += diff[i];
			sum += diff[i];
			if (sum < 0) { // 只要小于0就不可能是解
				startnode = i + 1;
				sum = 0;
			}
		}
		if (leftGas < 0){
			return -1;
		}else{
			return startnode;
		}
	}
}
