package com.leetcode_2th;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 * 
 * @author Zealot
 * @date 2016年7月7日 下午3:05:51 
 *
 */
public class SimplifyPath {
	public String simplifyPath(String path) {
		if(path==null){
			return null;
		}
		path = path.replace("/////", "/").replace("////", "/").replace("///", "/").replace("//", "/");
		if(path.startsWith("/")){
			path=path.substring(1);
		}
		String[] ss = path.split("/");
		Stack<String> stack = new Stack<String>();
		for(int i = 0; i < ss.length; i++) {
			String tmp = ss[i];
			if(tmp.equals(".")){
				continue;
			}else if(tmp.equals("..")){
				if(!stack.isEmpty()){
					stack.pop();
				}
			}else{
				stack.push(tmp);
			}
		}
		Stack<String> stack2 = new Stack<String>();
		while(!stack.isEmpty()){
			stack2.push(stack.pop());
		}
		StringBuffer res = new StringBuffer();
		while(!stack2.isEmpty()){
			res.append("/").append(stack2.pop());
		}
		if(res.equals("")||res.length()==0){
			return "/";
		}
		return res.toString();
    }
	public static void main(String[] args) {
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath("/home/.."));
	}
}
