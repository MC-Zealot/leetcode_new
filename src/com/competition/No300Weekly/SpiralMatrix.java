package com.competition.No300Weekly;

import com.leetCode.CommonStructure.ListNode;

/**
 * 2326. 螺旋矩阵 IV 显示英文描述
 * 通过的用户数4148
 * 尝试过的用户数4387
 * 用户总通过次数4206
 * 用户总提交次数6337
 * 题目难度Medium
 * 给你两个整数：m 和 n ，表示矩阵的维数。
 *
 * 另给你一个整数链表的头节点 head 。
 *
 * 请你生成一个大小为 m x n 的螺旋矩阵，矩阵包含链表中的所有整数。链表中的整数从矩阵 左上角 开始、顺时针 按 螺旋 顺序填充。如果还存在剩余的空格，则用 -1 填充。
 *
 * 返回生成的矩阵。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：m = 3, n = 5, head = [3,0,2,6,8,1,7,9,4,2,5,5,0]
 * 输出：[[3,0,2,6,8],[5,0,-1,-1,1],[5,2,4,9,7]]
 * 解释：上图展示了链表中的整数在矩阵中是如何排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 * 示例 2：
 *
 *
 * 输入：m = 1, n = 4, head = [0,1,2]
 * 输出：[[0,1,2,-1]]
 * 解释：上图展示了链表中的整数在矩阵中是如何从左到右排布的。
 * 注意，矩阵中剩下的空格用 -1 填充。
 *
 *
 * 提示：
 *
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 链表中节点数目在范围 [1, m * n] 内
 * 0 <= Node.val <= 1000
 */
public class SpiralMatrix {
    int[][] matrix;
    int m,n;
    boolean[][] flags;
    int num = 0;
    int size;
    ListNode node;
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        matrix = new int[m][n];
        this.m = m;
        this.n = n;
        this.size = m * n;
        flags = new boolean[m][n];
        this.node = head;
        int loop = 0;
        while(num < size){
            System.out.println(num);
            for(int j = 0; j < n; j++){
                traverseMatrix(loop, j + loop);
            }
            for(int i = 0; i < m; i++){
                traverseMatrix(loop + i + 1, n - loop - 1);
            }
            for(int j = n - 1; j >=0; j--){
                traverseMatrix(m - 1 - loop, j - loop - 1);
            }
            for (int i = m - 1; i >= 0; i--) {
                traverseMatrix(i - loop - 1, loop);
            }
            loop++;
        }
        return matrix;
    }
    public void traverseMatrix(int i, int j){
        if(num == size){
            return;
        }
        if(i < 0 || i >= m || j < 0 || j >= n || flags[i][j] == true){
            return;
        }
        if(node != null){
            matrix[i][j] = node.val;
            node = node.next;
        }else{
            matrix[i][j] = -1;
        }
        flags[i][j] = true;
        num++;
    }

    public static void main(String[] args) {
        SpiralMatrix sm = new SpiralMatrix();
        int m = 4;
        int n = 2;
        ListNode list = new ListNode(0);
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        list.next = list1;
        list1.next = list2;
        sm.spiralMatrix(m,n,list);
    }
}
