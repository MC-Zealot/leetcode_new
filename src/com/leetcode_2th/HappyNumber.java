package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月7日 下午5:11:10 
 *
 */
public class HappyNumber {
	public boolean isHappy(int n) {
        int x = n;
        int y = n;
        while(x>1){
            x = cal(x) ;
            if(x==1) return true ;
            y = cal(cal(y));
            if(y==1) return true ;

            if(x==y) return false;//如果y不为1，并且，x和y还相等，则说明再转换下去，取值也不变了。还不是1，所以就不是happy number了
        }
        return true ;
    }
    public int cal(int n){
        int x = n;
        int s = 0;
        while(x>0){
            s = s+(x%10)*(x%10);
            x = x/10;
        }
        return s ;
    }
}
