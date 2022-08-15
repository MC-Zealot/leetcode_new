package com.competition.No306Weekly;

import java.util.Stack;

/**
 * 6150. 根据模式串构造最小数字 显示英文描述
 * 通过的用户数1607
 * 尝试过的用户数1812
 * 用户总通过次数1629
 * 用户总提交次数2247
 * 题目难度Medium
 * 给你下标从 0 开始、长度为 n 的字符串 pattern ，它包含两种字符，'I' 表示 上升 ，'D' 表示 下降 。
 *
 * 你需要构造一个下标从 0 开始长度为 n + 1 的字符串，且它要满足以下条件：
 *
 * num 包含数字 '1' 到 '9' ，其中每个数字 至多 使用一次。
 * 如果 pattern[i] == 'I' ，那么 num[i] < num[i + 1] 。
 * 如果 pattern[i] == 'D' ，那么 num[i] > num[i + 1] 。
 * 请你返回满足上述条件字典序 最小 的字符串 num。
 *
 * 示例 1：
 * 输入：pattern = "IIIDIDDD"
 * 输出："123549876"
 * 解释：
 * 下标 0 ，1 ，2 和 4 处，我们需要使 num[i] < num[i+1] 。
 * 下标 3 ，5 ，6 和 7 处，我们需要使 num[i] > num[i+1] 。
 * 一些可能的 num 的值为 "245639871" ，"135749862" 和 "123849765" 。
 * "123549876" 是满足条件最小的数字。
 * 注意，"123414321" 不是可行解因为数字 '1' 使用次数超过 1 次。
 * 示例 2：
 *
 * 输入：pattern = "DDD"
 * 输出："4321"
 * 解释：
 * 一些可能的 num 的值为 "9876" ，"7321" 和 "8742" 。
 * "4321" 是满足条件最小的数字。
 *
 * 提示：
 *
 * 1 <= pattern.length <= 8
 * pattern 只包含字符 'I' 和 'D' 。
 */
public class SmallestNumber {
    public int findMin(boolean[] flags){
        for(int i = 0; i < flags.length; i++){
            if(flags[i] == false){
                return i;
            }
        }
        return -1;
    }

    /**
     * 有bug
     * @param pattern
     * @return
     */
    public String smallestNumber2(String pattern) {
        int n = pattern.length();
        int index = 0;
        String ret = "";
        while(index <= n){
            /**
             *  if(I && 后一位也是I或者是null){
             *      选择最小的
             *  } else{
             *      计算后边D的个数numD，选择从i 到 i + numD，个数，再逆序追加
             *  }
             */
            String cStr = String.valueOf(pattern.charAt(index));
            if(!cStr.equals("D") &&(cStr.equals("I") || (index == n || String.valueOf(pattern.charAt(index + 1)).equals("I")))){
                int num = index + 1;//找最小
                ret += num;
                index++;
            }else{
                int i = index;
                int numD = 0;
                while(i <= n){
                    String s = String.valueOf(pattern.charAt(i++));
                    if(s.equals("D")){
                        numD++;
                    }else{
                        break;
                    }
                }
                int start = index + numD + 1;
                int end = index + 1;
                for( ; start >= end; start--){
                    int num = start;
                    ret+=num;
                    index++;
                }
                index--;
            }
        }
        return ret;
    }

    /**
     *
     * @param pattern
     * @return
     */
    public String smallestNumber(String pattern) {
        String ret= "";
        int index = 1;
        pattern+="I";
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < pattern.length(); i++){
            String p = String.valueOf(pattern.charAt(i));
            if(p.equals("D")){
                stack.add(index);
                index++;
            }else{
                ret+=String.valueOf(index);
                index++;
                while(stack.size()>0){
                    int n = stack.pop();
                    ret+=n;
                }
            }
        }
        return  ret;
    }
    public static void main(String[] args) {
        SmallestNumber sn = new SmallestNumber();
        String pattern = "IIIDIDDD";
        String ret = sn.smallestNumber(pattern);
        System.out.println(ret);
    }
}
