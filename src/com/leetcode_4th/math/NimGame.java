package com.leetcode_4th.math;
/**
 * 
 * @author zealot
 * Created on: Mar 1, 2020 9:35:09 PM
 */
public class NimGame {
	public boolean canWinNim(int n) {
        if(n<=0){
            return false;
        }
        //条件：1、拿1~3块石头
        //2、收尾的人是胜者
        //3、自己先拿
        if(n%4==0){
            return false;
        }
        return true;
    }
}
