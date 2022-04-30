package com.classicAlgorithm;
/**
 * 
 * 一个台阶总共有n 级，如果一次可以跳1 级，也可以跳2 级，求总共有多少总跳法，并分析算法的时间复杂度 
 *注： 
这道题最近经常出现，包括MicroStrategy 等比较重视算法的公司都曾先后选用过个这道题作为面试题或者笔试题。 
 
首先我们考虑最简单的情况： 
    如果只有1 级台阶，那显然只有一种跳法， 
    如果有2 级台阶，那就有两种跳的方法了：一种是分两次跳，每次跳1 级；另外一种就是一次跳2 级。 
     
现在我们再来讨论一般情况： 
    我们把n 级台阶时的跳法看成是n 的函数，记为f(n)。 
    当n>2 时，第一次跳的时候就有两种不同的选择： 
            一是第一次只跳1 级，此时跳法数目等于后面剩下的n-1 级台阶的跳法数目，即为f(n-1)； 
            另外一种选择是第一次跳2 级，此时跳法数目等于后面剩下的n-2 级台阶的跳法数目，即为f(n-2)。 
因此n 级台阶时的不同跳法的总数f(n) = f(n-1) + f(n-2)。 
 
我们把上面的分析用一个公式总结如下： 
 * @author Zealot
 * @date 2016年3月17日 上午11:29:19 
 *
 */
public class JumpGame {
	  private int jumpStep(int n) {  
	        if(n<0){
	        	return 0;  
	        }
	        if(n==1||n==2){
	        	return n;  
	        }
	        return jumpStep(n-1) + jumpStep(n-2);  
	  }  
	  private int jumpStep2(int n) {  
	        if(n<0){
	        	return 0;  
	        }
	        if(n==1||n==2){
	        	return n;  
	        }
	        
	        int[] a = new int[n];
	        a[0]=1;
	        a[1] = 2;
	        for(int i = 2; i < n; i++) {
	        	a[i] = a[i-1] + a[i-2];
	        }
	        return a[n-1];  
	  } 
	  public static void main(String[] args) {
		  JumpGame jg = new JumpGame();
		  System.out.println(jg.jumpStep2(10));
	}
}
