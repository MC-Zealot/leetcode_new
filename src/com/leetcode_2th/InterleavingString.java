package com.leetcode_2th;
/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.
 * 
 * @author Zealot
 * @date 2016年7月12日 上午11:14:31 
 *
 */
public class InterleavingString {
	/**
直观上，我看到该题，就会去想，s1取一部分，s2取一部分，然后再s1取一部分，反复知道匹配完成s3，算法去模拟这样的操作。

而当s1和s3匹配了一部分的时候，剩下s1‘和剩下的s3‘与s2又是一个子问题。这样很容易写成一个递归，但是需要注意两点：

1. 递归方法中，我们总是拿s1首先去匹配s3，如果不匹配，直接返回false。这样做的原因是保持匹配是“交替”进行的；

2. 当出现既可以匹配s1，又可以匹配s2的时候，一样可以通过递归来解决，看下面的代码。
	 * @date 2016年7月12日 下午3:41:24
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	private boolean isInterleaveInternal(String s1, String s2, String s3){
        if(s1.equals("")) {
            return s2.equals("") && s3.equals("");
        }
        if(s1.equals(s3) && s2.endsWith("")) {
        	return true;
        }
        int i1 = 0;
        int i2 = 0;
        int i3 = 0;
        if(s1.charAt(0) != s3.charAt(0)) return false;
        while(i1 < s1.length() && i2 < s2.length() && i3 < s3.length() && s1.charAt(i1) == s3.charAt(i3)) {
            i1++;
            i3++;
            //如果这里s2也可以匹配s3，那么我们立马递归进行匹配
            if(s2.charAt(i2) == s3.charAt(i3) && isInterleaveInternal(s2.substring(i2), s1.substring(i1), s3.substring(i3)))
                return true;
        }
        //接下来开始匹配s2
        return isInterleaveInternal(s2, s1.substring(i1), s3.substring(i3));
        
    }
	/**
	 * 我们从头到尾遍历这三个String，比如取名s1,s2,s3，然后取p1,p2,p3三个指针来对应每个String里当前遍历到的字符位置

这么想，如果s1的p1位，和s2的p2位，和s3的p3位都相等，那么在s3挑选的字符的时候，我们可以挑s1的那一位，也可以挑s2的那一位，

所以在递归的时候我们用或（｜｜）把两种情况连接起来，传入s1的下一位，或者s2的下一位

如果只有s1的p1位和s3的p3位相等，那只能传入s1的下一位

如果只有s2的p2位和s3的p3位相等，那只能传入s2的下一位

如果没有发现相等，return false 退回到上一层

	 * @date 2016年7月12日 下午8:53:35
	 * @param s1
	 * @param s2
	 * @param s3
	 * @return
	 */
	public boolean isInterleaveInternal2(String s1, String s2, String s3) {
		if (s1.length() + s2.length() != s3.length()){
			return false;
		}
		return rec(s1, 0, s2, 0, s3, 0);
	}  
	      
	public boolean rec(String s1, int p1, String s2, int p2, String s3, int p3) {
		if (p3 == s3.length()) return true;  
		if (p1 == s1.length())
			return s2.substring(p2).equals(s3.substring(p3));  
		if (p2 == s2.length())
			return s1.substring(p1).equals(s3.substring(p3));
		if (s1.charAt(p1) == s3.charAt(p3) && s2.charAt(p2) == s3.charAt(p3))
			return rec(s1, p1 + 1, s2, p2, s3, p3 + 1) || rec(s1, p1, s2, p2 + 1, s3, p3 + 1);
		else if (s1.charAt(p1) == s3.charAt(p3))
			return rec(s1, p1 + 1, s2, p2, s3, p3 + 1);
		else if (s2.charAt(p2) == s3.charAt(p3))
			return rec(s1, p1, s2, p2 + 1, s3, p3 + 1);
		else
			return false;
	}  
	public static void main(String[] args) {
		InterleavingString i = new InterleavingString();
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(i.isInterleaveInternal(s1, s2, s3));
	}
}
