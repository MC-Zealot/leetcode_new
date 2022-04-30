package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.

Note:
If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
All airports are represented by three capital letters (IATA code).
You may assume all tickets form at least one valid itinerary.
Example 1:
tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
Return ["JFK", "MUC", "LHR", "SFO", "SJC"].
Example 2:
tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
Return ["JFK","ATL","JFK","SFO","ATL","SFO"].
Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"]. But it is larger in lexical order.
 * 
 * @author Zealot
 * @date 2016年4月14日 下午9:04:27 
 *
 */
public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
		Map<String, LinkedList<String>> map = new HashMap<String, LinkedList<String>>();
		for(int i = 0; i < tickets.length; i++) {
			String[] ss = tickets[i];
			LinkedList<String> list = null;
			if(!map.containsKey(ss[0])){
				list = new LinkedList<String>();
			}else{
				list = map.get(ss[0]);
			}
			list.add(ss[1]);
			map.put(ss[0], list);
		}
		for(String key: map.keySet()){
			Collections.sort(map.get(key));
		}
		List<String> list = new ArrayList<String>();
		list.add("JFK");
		while(map.size()>0){
			String key = list.get(list.size()-1);
			List<String> l = map.get(key);
			if(l==null){
				break;
			}
			list.add(l.get(0));
			if(l.size()>=1){
				l = l.subList(1, l.size());
				map.put(key, new LinkedList<String>(l));
			}
			if(l.size()==0){
				map.remove(key);
			}
		}
		
		return list;
    }
	public List<String> findItinerary2(String[][] tickets) {
        List<String> ans = new ArrayList<String>();
        if(tickets == null || tickets.length == 0) return ans;
        Map<String, PriorityQueue<String>> ticketsMap = new HashMap<>();
        for(int i = 0; i < tickets.length; i++) {
            if(!ticketsMap.containsKey(tickets[i][0])) ticketsMap.put(tickets[i][0], new PriorityQueue<String>());
            ticketsMap.get(tickets[i][0]).add(tickets[i][1]);
        }

        String curr = "JFK";
        Stack<String> drawBack = new Stack<String>();
        for(int i = 0; i < tickets.length; i++) {
            while(!ticketsMap.containsKey(curr) || ticketsMap.get(curr).isEmpty()) {
                drawBack.push(curr);
                curr = ans.remove(ans.size()-1);
            }
            ans.add(curr);
            curr = ticketsMap.get(curr).poll();
        }
        ans.add(curr);
        while(!drawBack.isEmpty()) ans.add(drawBack.pop());
        return ans;
    }
	public static void main(String[] args) {
		ReconstructItinerary r = new ReconstructItinerary();
//		String[][] s = {{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}};
		String[][] s = {{"JFK","KUL"}, {"JFK","NRT"}, {"NRT","JFK"}};
//		String[][] s = {{"JFK","SFO"},{"JFK","ATL"},{"SFO","ATL"},{"ATL","JFK"},{"ATL","SFO"}};
		
		List<String> list = r.findItinerary(s);
		for(String str : list){
			System.out.print(str+"\t");
		}
	}
}
