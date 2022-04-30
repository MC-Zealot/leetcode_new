//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。 
//
// 如果反转后整数超过 32 位的有符号整数的范围 [−231, 231 − 1] ，就返回 0。 
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
// 示例 1： 
//
// 
//输入：x = 123
//输出：321
// 
//
// 示例 2： 
//
// 
//输入：x = -123
//输出：-321
// 
//
// 示例 3： 
//
// 
//输入：x = 120
//输出：21
// 
//
// 示例 4： 
//
// 
//输入：x = 0
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// -231 <= x <= 231 - 1 
// 
// Related Topics 数学 
// 👍 2983 👎 0


package com.oj_5th.leetcode.editor.cn;
/*
*   [7] reverse-integer
*   2021-08-08 18:56:06
*/
public class P7ReverseInteger{
    public static void main(String[] args) {
        Solution solution = new P7ReverseInteger().new Solution();
        // TO TEST
    }
    //[7] reverse-integer
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int reverse(int x) {
        if(x==0){
            return x;
        }
        int flag = 1;
        if(x<0){
            flag = -1;
            x = -x;
        }
        String xStr = String.valueOf(x);
        StringBuffer sb = new StringBuffer();
        for(int i = xStr.length() - 1; i >=0 ; i--){
            sb.append(String.valueOf(xStr.charAt(i)));
        }
        int ret = 0;
        try{
            ret = Integer.parseInt(sb.toString());
        }catch(Exception e){
            return 0;
        }
        int flag2 = 1;
        if(ret < 0){
            flag2 = -1;
        }
        if(flag2 < 0){
            return 0;
        }
        return ret * flag;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}