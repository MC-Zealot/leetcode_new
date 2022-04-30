package com.leetcode_3th.hashtable;

/**
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。

例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
73, 74, 75, 71, 69, 72, 76, 73
0,  1,  1,  -4, -2, 3,  4,  -3：涨跌幅
0,  1,  2,  -2, -4,-1,  3,  0：加和

提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。

 * 
 * @author Zealot
 * @date Jul 31, 2019 8:16:33 PM 
 *
 */
public class DailyTemperatures {
	/**
	 * 超时
	 * @date Jul 31, 2019 8:44:18 PM
	 * @param T
	 * @return
	 */
	public int[] dailyTemperatures(int[] T) {
		int[] res = new int[T.length];
		for (int i = 0; i < res.length; i++) {
			int val = 0;
			while (i + val < T.length && T[i + val] <= T[i]) {
				val++;
			}
			if ((i + val < T.length) && T[i + val] > T[i]) {
				res[i] = val;
			}
		}
		return res;
	}
	/**
	 * 根据题意，从最后一天推到第一天，这样会简单很多。因为最后一天显然不会再有升高的可能，结果直接为0。
	 * 再看倒数第二天的温度，如果比倒数第一天低，那么答案显然为1，如果比倒数第一天高，又因为倒数第一天
	 * 对应的结果为0，即表示之后不会再升高，所以倒数第二天的结果也应该为0。
	 * 自此我们容易观察出规律，要求出第i天对应的结果，只需要知道第i+1天对应的结果就可以：
	 * - 若T[i] < T[i+1]，那么res[i]=1；
	 * - 若T[i] > T[i+1]
	 *   - res[i+1]=0，那么res[i]=0;
	 *   - res[i+1]!=0，那就比较T[i]和T[i+1+res[i+1]]（即将第i天的温度与比第i+1天大的那天的温度进行比较）
	 */
	public int[] dailyTemperatures2(int[] T) {
	    int[] res = new int[T.length];
	    res[T.length - 1] = 0;
	    for (int i = T.length - 2; i >= 0; i--) {
	        for (int j = i + 1; j < T.length; j += res[j]) {
	            if (T[i] < T[j]) {
	                res[i] = j - i;
	                break;
	            } else if (res[j] == 0) {
	                res[i] = 0;
	                break;
	            }
	        }
	    }
	    return res;
	}
}
