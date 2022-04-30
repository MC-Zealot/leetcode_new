package com.classicAlgorithm;
/**
 * 全排列，无重复数字
 * 
 * @author Zealot
 * @date 2016年5月5日 上午9:48:29 
 *
 */
public class Permutation {
	static int[] a = new int[10];
	private void permu(int cur) {
		if(a.length - 1 == cur){
			for(int i = 0; i < a.length; i ++) {
				System.out.print(a[i]+"\t");
			}
			System.out.println();
			return;
		}
		for(int i = cur; i < a.length ; i++) {
			swap(i, cur);
			permu(cur+1);
			swap(i, cur);
		}
	}
	private void swap(int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}
	
	/**
* 固定a，求后面bc的排列：abc，acb，求好后，a和b交换，得到bac
* 固定b，求后面ac的排列：bac，bca，求好后，c放到第一位置，得到cba
* 固定c，求后面ba的排列：cba，cab。
	 * @date 2016年6月28日 上午11:38:53
	 * @param str
	 * @param first
	 * @param end
	 */
	public static void permutation(String[] str, int first, int end) {
		// 输出str[first..end]的所有排列方式
		if (first == end) { // 输出一个排列方式
			for (int j = 0; j <= end; j++) {
				System.out.print(str[j]);
			}
			System.out.println();
		}

		for (int i = first; i <= end; i++) {
			swap(str, i, first);//交换位置，把后边的放到当前位置，
			permutation(str, first + 1, end); // 固定好当前一位，继续排列后面的
			swap(str, i, first);//恢复交换之前的位置
		}
	}

	private static void swap(String[] str, int i, int first) {
		String tmp;
		tmp = str[first];
		str[first] = str[i];
		str[i] = tmp;
	}

	public static void main(String[] args) {
		int[] arr = {1,2,3};
		a = arr;
		Permutation  p = new Permutation();
		p.permu(0);
		 String[] str = {"a","b","c"};
         permutation(str, 0, 2);//输出str[0..2]的所有排列方式
	}
}
