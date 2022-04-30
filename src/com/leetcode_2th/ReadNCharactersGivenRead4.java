package com.leetcode_2th;
/**
 * The API: int read4(char *buf) reads 4 characters at a time from a file.

The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters left in the file.

By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.

Note:
The read function will only be called once for each test case.
题目大意：从一个文件中读取数据长度n，保存至buf当中。并且返回读取文件的长度。
每次限制读取4个字符，使用api：read4.
当读取一次小于4时，说明已经把文件所有内容读完了，那么返回文件长度。
如果读到n时，返回n

 * 
 * @author Zealot
 * @date 2016年5月5日 下午5:18:04 
 *
 */
public class ReadNCharactersGivenRead4 {
	/**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
    	int size = 0;
    	while(size<n){
    		char[] buffer = new char[4];
    		int tmpSize = read4(buffer);
    		System.arraycopy(buffer, 0, buf, size, Math.min(tmpSize, n - size));
    		size = size + tmpSize;
    		if(tmpSize<4){
    			return Math.min(size, n);
    		}
    	}
    	return n;
    }
    private int read4(char[] buf) {

    	return 1;
	}
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read2(char[] buf, int n) {
        for(int i = 0; i < n; i += 4){
            char[] tmp = new char[4];
            // 将数据读入临时数组
            int len = read4(tmp);
            // 将临时数组拷贝至buf数组，这里拷贝的长度是本次读到的个数和剩余所需个数中较小的
            System.arraycopy(tmp, 0, buf, i, Math.min(len, n - i));
            // 如果读不满4个，说明已经读完了，返回总所需长度和目前已经读到的长度的较小的
            if(len < 4) return Math.min(i + len, n);
        }
        // 如果循环内没有返回，说明读取的字符是4的倍数
        return n;
    }
}
