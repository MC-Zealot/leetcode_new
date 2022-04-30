package leetcode_2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月3日 上午10:33:17 
 *
 */
public class _3Sum {
	/**
	 * time: O(n^2)
	 * space: O(n)
	 * @date 2016年6月3日 上午11:05:34
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length<=0){
			return res;
		}
		Arrays.sort(nums);
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		Set<String> tmpSet = new HashSet<String>();
		for(int i = 0; i < nums.length - 1; i++) {
			for(int j = i + 1; j < nums.length; j++) {
				int tmp = nums[i]+nums[j];
				if(map.containsKey(-tmp) && map.get(-tmp)>j){
					tmpSet.add(nums[i]+"\t"+nums[j]+"\t"+(-tmp));
				}
			}
		}
		for(String s: tmpSet){
			String[] ss = s.split("\t");
			List<Integer> list = new ArrayList<Integer>();
			for(String i:ss){
				list.add(Integer.parseInt(i));
			}
			res.add(list);
		}
		return res;
    }
	public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length<=0){
			return res;
		}
		Arrays.sort(nums);
		backTracking(nums, 0, 0, new ArrayList<Integer>(), res);
		return res;
	}
	private void backTracking(int[] nums, int cur, int sum, List<Integer> list, List<List<Integer>> res) {
		if(list.size()==3){
			if(sum == 0){
				res.add(new ArrayList<Integer>(list));
			}
			return;
		}
		for(int i = cur; i < nums.length; i++) {
			if(i > cur && nums[i-1] == nums[i]){//如果相邻有重复，则跳过.PS:因为已经排序，相等的元素肯定相邻
				continue;
			}
			list.add(nums[i]);
			backTracking(nums, i+1, sum+nums[i], list, res);
			list.remove(list.size()-1);
		}
	}
	public static void main(String[] args) {
		_3Sum s = new _3Sum();
		int[] a = {-1, 0, 1, 2, -1, -4};
		System.out.println(s.threeSum(a));
	}
}
