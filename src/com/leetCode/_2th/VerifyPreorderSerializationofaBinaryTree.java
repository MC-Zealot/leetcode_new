package com.leetCode._2th;

import java.util.Stack;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as #.

     _9_
    /   \
   3     2
  / \   / \
 4   1  #  6
/ \ / \   / \
# # # #   # #
For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#", where # represents a null node.

Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.

Find an algorithm without reconstructing the tree.

Each comma separated value in the string must be either an integer or a character '#' representing null pointer.

You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".

Example 1:
"9,3,4,#,#,1,#,#,2,#,6,#,#"
Return true

Example 2:
"1,#"
Return false

Example 3:
"9,#,#,1"
Return false
这个方法简单的说就是不断的砍掉叶子节点。最后看看能不能全部砍掉。
 * 
 * @author Zealot
 * @date 2016年4月14日 下午5:00:30 
 *
 */
public class VerifyPreorderSerializationofaBinaryTree {
	public boolean isValidSerialization(String preorder) {
		String[] ss = preorder.split(",");
		Stack<String> s = new Stack<String>();
		for(int i = 0; i < ss.length; i++) {
			s.push(ss[i]);
			while(s.size()>=3&&s.get(s.size()-1).equals("#")&&s.get(s.size()-2).equals("#")&&(!s.get(s.size()-3).equals("#"))){
				s.pop();
				s.pop();
				s.pop();
				s.push("#");
			}
		}
        return s.size()==1&&s.get(0).equals("#");
    }
}
