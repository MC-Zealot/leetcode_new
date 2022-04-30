package com.leetcode_4th.string;
/**
 * 
 * @author zealot
 * Created on: Mar 1, 2020 3:56:53 PM
 */
public class StringCompression {
	@Deprecated
	public int compress(char[] chars) {
		// 定义压缩数组下标，new_idx=0
		// 字符起始点tmp_start，和i，当chars[i]!=chars[tmp_start]，先计算len=i-tmp_start，
		// 开始追加压缩数组，从new_idx开始
		// 需要考虑边界条件，如果最后只有不重复的一个，那么不会到if条件中
		if (chars == null || chars.length == 0) {
			return 0;
		}
		int new_idx = 0;
		int tmp_start = 0;
		int ret = 0;
		String len_str = "";
		for (int i = 0; i < chars.length; i++) {
			if (chars[i] != chars[tmp_start] || i == chars.length - 1) {
				int len = i - tmp_start;
				if( i == chars.length - 1) {
					len++;
				}
				chars[new_idx++] = chars[tmp_start];
				ret++;
				if (len > 1) {
					// 追加数字
					len_str = String.valueOf(len);
					for (int j = 0; j < len_str.length(); j++) {
						chars[new_idx++] = len_str.charAt(j);
					}
					ret+=len_str.length();
				} else {
					len_str = "";
				}
				if(i != chars.length - 1) {
					tmp_start = i;
				}
			}
		}

		return ret;
	}
	public int compress2(char[] chars) {
        int n = chars.length;
        int cur = 0; // 当前处理字符的索引，最后是压缩串的长度
        for(int i = 0; i < n; ) {
            int j = i;
            while(j < n - 1 && chars[j] == chars[j+1]) {// 找相同字符的连续个数
                j++;
            }
            chars[cur++] = chars[i];// 记录当前字符
            if(i != j) {
                String times = (j - i + 1) + "";// 当前字符的连续重复次数
                int tLen = times.length();
                for(int k = 0; k < tLen; k++) {//将字符的重复次数写入原串中，用以压缩字符串
                    chars[cur++] = times.charAt(k);
                }
            }
            i = j + 1;
        }
        return cur;

	
    }
	public static void main(String[] args) {
		StringCompression sc = new StringCompression();
//		char[] chars = { 'a' ,'a','a','b','b'};
		char[] chars = { 'a' ,'b'};
		System.out.println(sc.compress(chars));
	}
}
