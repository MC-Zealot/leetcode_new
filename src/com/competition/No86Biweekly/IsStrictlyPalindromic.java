package com.competition.No86Biweekly;

public class IsStrictlyPalindromic {
    public boolean isStrictlyPalindromic(int n) {
        for(int i = 2; i <= n - 2; i++){
            String str = fun(i, n);
            boolean ret = isPalindrome(str);
            if(ret == false){
                return false;
            }
        }
        return true;
    }
    public String fun(int n,int num) {
        // n 表示目标进制, num 要转换的值
        String str= "";
        int yushu ;      // 保存余数
        int shang = num;      // 保存商
        while (shang>0) {
            yushu = shang %n;
            shang = shang/n;

            // 10-15 -> a-f
            if(yushu>9) {
                str =(char)('a'+(yushu-10)) + str;
            }else {
                str = yushu+str;
            }
        }

        return str;
    }
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i))
                    != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            i++; j--; }
        return true;
    }

    public static void main(String[] args) {
        IsStrictlyPalindromic isp = new IsStrictlyPalindromic();
        int num = 9;
//        System.out.println(isp.fun(3, 9));
        System.out.println(isp.isStrictlyPalindromic(9));
    }

}
