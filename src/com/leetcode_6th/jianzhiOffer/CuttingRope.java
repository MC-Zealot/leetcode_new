package com.leetcode_6th.jianzhiOffer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 ×3 ×4 = 36
 * 提示：
 *
 * 2 <= n <= 58
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CuttingRope {
    int max;
    int n;
    public int cuttingRope(int n) {
        max = -1;
        this.n = n;
        dfs(0, 1);
        return max;
    }
    public void dfs(int tmpSum, int tmpProduct){
        if(tmpSum > n){
            return;
        }
        if(tmpSum == n){
            max = Math.max(max, tmpProduct);
        }
        for(int i = 1; i < n; i++){
            if(tmpSum + i > n){
                break;
            }
            dfs(tmpSum + i, tmpProduct * i);
        }
    }

    public int cuttingRope2(int n) {
        if (n==1 || n==2)
            return 1;
        if (n==3)
            return 2;
        int sum=1;
        while (n>4){
            sum*=3;
            n-=3;
        }

        return sum*n;
    }

    /**
     * 1. 确定dp数组下标含义 分拆数字i，可以得到的最大乘积为dp[i];
     * 2. 递推公式 dp[i] = max(dp[i], (i - j) * j, dp[i - j] * j);
     * 3. 初始化 dp[2] = 1;
     * 4. 遍历顺序 从前向后遍历就可以;
     * 5. 推导结果;
     * https://leetcode.cn/problems/jian-sheng-zi-lcof/solution/by-nehzil-w61p/
     */
    int integerBreak(int n) {
        /* 定义dp数组 */
        int[] dp = new int[n + 1];
        /* dp数组初始化 */
        dp[2] = 1;
        /* 从前向后遍历 */
        for (int i = 3; i <= n ; i++) {
            /* j遍历到小于i的值 */
            for (int j = 1; j < i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max((i - j) * j, dp[i - j] * j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        CuttingRope c = new CuttingRope();
        int ret = c.cuttingRope(10);
        System.out.println(ret);
    }
}
