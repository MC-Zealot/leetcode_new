package com.classicAlgorithm.knapsack;

public class KnapsackTest {
	
	public static void main(String[] args) {
		
		Knapsack[] bags = new Knapsack[] {
				new Knapsack(2,6),
				new Knapsack(2,3),
				new Knapsack(6,5),
				new Knapsack(5,4),
				new Knapsack(4,6)
		};
		int totalWeight = 10;
		KnapsackProblem kp = new KnapsackProblem(bags, totalWeight);
		
		kp.solve();
		System.out.println(" -------- 该背包问题实例的解: --------- ");
		System.out.println("最优值：" + kp.getBestValue());	
		System.out.println("最优解【选取的背包】: ");
		System.out.println(kp.getBestSolution());
		System.out.println("最优值矩阵：");
		int[][] bestValues = kp.getBestValues();
		for (int i=0; i < bestValues.length; i++) {
			for (int j=0; j < bestValues[i].length; j++) {
				System.out.printf("%-5d", bestValues[i][j]);
			}
			System.out.println();
		}
	}
}