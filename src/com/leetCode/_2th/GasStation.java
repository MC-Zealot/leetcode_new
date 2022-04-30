package com.leetCode._2th;
/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

 Note:
 The solution is guaranteed to be unique.
 *
 * @author Zealot
 * @date 2016年3月2日 下午8:42:44
 *
 */
public class GasStation {
	/**
	 * O(n^2)
	 * @date 2016年3月2日 下午9:20:21
	 * @param gas
	 * @param cost
	 * @return
	 */
	public int canCompleteCircuit(int[] gas, int[] cost) {

		int size = gas.length;
		if(size ==0){
			return -1;
		}
		int cur = -1;
		boolean[] a = new boolean[size];

		for(int start = 0; start < size; start++) {
			cur++;
			for(int i = start; a[i] == false; i++) {
				a[i] = true;
				cur = cur + gas[i] - cost[i];
				if(cur<0){
					a= new boolean[size];
					cur = -1;
					break;
				}

				if(i == size-1){
					i = -1;
				}
			}
			if(cur>=0){
				return start;
			}
		}
		return -1;

	}

	public int canCompleteCircuit2(int[] gas, int[] cost) {
		int[] diff = new int[gas.length];
		for (int i = 0; i < gas.length; ++i) {
			diff[i] = gas[i] - cost[i];
		}

		int leftGas = 0, sum = 0, startnode = 0;
		for (int i = 0; i < gas.length; ++i) {
			leftGas += diff[i];
			sum += diff[i];
			if (sum < 0) // 只要小于0就不可能是解
			{
				startnode = i + 1;
				sum = 0;
			}
		}
		if (leftGas < 0)
			return -1;
		else
			return startnode;
	}
	public static void main(String[] args) {
		GasStation g = new GasStation();
		int[] gas = {4};
		int[] cost = {6};
		System.out.println(g.canCompleteCircuit(gas, cost));
	}
}
