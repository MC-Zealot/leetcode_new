package com.leetcode_2th;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月26日 下午2:55:54 
 *
 */
public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
	    Set<String> seen = new HashSet<String>(), repeated = new HashSet<String>();
	    for (int i = 0; i + 9 < s.length(); i++) {
	        String ten = s.substring(i, i + 10);
	        if (!seen.add(ten))
	            repeated.add(ten);
	    }
	    return new ArrayList<String>(repeated);
	}
}
