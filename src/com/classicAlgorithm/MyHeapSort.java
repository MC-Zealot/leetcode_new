package com.classicAlgorithm;

public class MyHeapSort {
	// 堆排序：时间复杂度O(nlogn)，
	// 输入是一个数组，输出也是一个数组
	// 思路：假设是一个大顶堆。完全二叉树，每一个父节点是大于等于子节点的。根节点为最大值。
	// 插入节点，判断与根节点大小，如果大于根节点，
	// 1、从数组len/2开始，到0的位置循环，每一个节点为根节点调整数组为大顶堆
	// 调整数组为大顶堆：当前节点i，找到左右字数比较大的那一个，然后开始于父节点比较，如果这个子节点比父节点还大
	// 则进行交换。
	// 终止条件：孩子节点小于数组长度

	// i:根节点
	// n:调整的数组长度
	public static void headpAdjust(int[] arr, int i, int n) {
		//
		int child;// 子节点下标
		int father;// 父节点元素
		for (father = arr[i]; leftChild(i) < n; i = child) {
			child = leftChild(i);
			// 先判断哪一个子节点比较大
			if (child < n - 1 && arr[child] < arr[child + 1]) {
				child++; //
			}
			// 父节点和子节点开始比较，如果父节点小，则与子节点交换
			if (father < arr[child]) {
				arr[i] = arr[child];
			} else {
				break;
			}
		}
		arr[i] = father;// 完成交换
	}

	public static int leftChild(int i) {
		return 2 * i + 1;
	}

	public static void swap(int[] arr, int i, int j) {
		int tmp = arr[i];
		arr[i] = arr[j];
		arr[j] = tmp;
	}

	public static void heapSort(int[] arr) {
		// 根据数组调整成一个大顶堆，这样最大的数就已经有了
		for (int i = arr.length / 2; i >= 0; i--) {
			headpAdjust(arr, i, arr.length);
		}

		// 在大顶堆的基础上开始排序，从最后一个节点开始，与 根结点（最大值）交换，
		for (int i = arr.length - 1; i >= 0; i--) {
			swap(arr, 0, i);
			headpAdjust(arr, 0, i);
		}
	}
	public static void main(String[] args) {
		int[] arr = { 50, 10, 90, 30, 70, 90, 90, 40, 80, 60, 20 };
		System.out.println("排序之前：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		String s = "123";
		// 堆排序
		heapSort(arr);

		System.out.println();
		System.out.println("排序之后：");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
