package com.leetcode_3th.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * 给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0
 * ？找出所有满足条件且不重复的三元组。
 * 
 * 注意：答案中不可以包含重复的三元组。
 * 
 * 例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 * 
 * 满足要求的三元组集合为： [ [-1, 0, 1], [-1, -1, 2] ]
 * 
 * 
 * @author Zealot
 * @date Jul 14, 2019 9:54:27 PM
 *
 */
public class ThreeSum {
	/**
	 * 
输入：
[0,0,0]
输出：
[]
预期：
[[0,0,0]]
	 * @date Jul 15, 2019 5:23:14 PM
	 * @param nums
	 * @param target
	 * @param start
	 * @return
	 */
	public int[] twoSum(int[] nums, int target, int start) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] res = new int[2];
		for (int i = 0; i < nums.length; i++) {
			if (i == start) {
				continue;
			}
			if (map.containsKey(target - nums[i])) {
				res[0] = target - nums[i];
				res[1] = nums[i];
				return res;
			}
			map.put(nums[i], i);
		}
		return res;
	}

	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length <= 2) {
			return res;
		}
		int target_2 = 0;
		Arrays.sort(nums);
		Set<String> tmpSet = new HashSet<String>();
		for (int i = 0; i < nums.length; i++) {
			target_2 = -nums[i];
			int[] res_2_sum = twoSum(nums, target_2, i);
			if (res_2_sum[0] != 0 || res_2_sum[1] != 0) {
				int[] tmp = new int[3];
				tmp[0] = nums[i];
				tmp[1] = res_2_sum[0];
				tmp[2] = res_2_sum[1];
				Arrays.sort(tmp);
				String str = tmp[0] + "\t" + tmp[1] + "\t" + tmp[2];
				tmpSet.add(str);
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
	
	/**
	 *  超时
	 * @date Jul 15, 2019 5:17:21 PM
	 * @param nums
	 * @return
	 */
	public List<List<Integer>> threeSum4(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length <= 2) {
			return res;
		}
		int target = 0;
		Arrays.sort(nums);
		Set<String> tmpSet = new HashSet<String>();
		
		for (int i = 0; i < nums.length; i++) {
			target = -nums[i];
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int j = i+1; j < nums.length; j++) {
				if (i == j) {
					continue;
				}
				if (map.containsKey(target - nums[j])) {
					String str = nums[i] + "\t" + (target - nums[j]) + "\t" + nums[j];
					tmpSet.add(str);
				}
				map.put(nums[j], j);
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

	
	
	/**
	 * 2 pointer
     *总体思路是固定一个数，寻找另外了两个数
     *先排序，固定一个数，再分别从前后扫描找另外两个数，从两端想中间靠拢
     */
    List<List<Integer>> ret = new ArrayList<List<Integer>>();  
      
    public List<List<Integer>> threeSum3(int[] num) {
        //先判断
        if (num == null || num.length < 3) return ret;  
        //排序，方便之后的扫描
        Arrays.sort(num);  
/*      //本以为先判断一下会更好，但加入判断后用时好像更多了
        if(num[0]>0) return ret;
        if(num[num.length-1]<0) return ret;*/
        int len = num.length;  
        for (int i = 0; i < len-2; i++) {
            //为了排除重复的情况
            if (i > 0 && num[i] == num[i-1]) continue;  
            find(num, i+1, len-1, num[i]); //寻找两个数与num[i]的和为0  
        }  
          
        return ret;  
    }  
      
    /**
     * 二分查找的前提是数组有序，这需要O(n^2)的时间复杂度
     * @date Jul 17, 2019 10:27:09 AM
     * @param num
     * @param begin
     * @param end
     * @param target
     */
    public void find(int[] num, int begin, int end, int target) {  
        int l = begin, r = end;  
        while (l < r) {  
            if (num[l] + num[r] + target == 0) {  
                List<Integer> ans = new ArrayList<Integer>();  
                ans.add(target);  
                ans.add(num[l]);  
                ans.add(num[r]);  
                ret.add(ans); //放入结果集中  
                while (l < r && num[l] == num[l+1]) l++;//相同的直接跳过（排除重复）  
                while (l < r && num[r] == num[r-1]) r--;  
                l++;  
                r--;  
            } else if (num[l] + num[r] + target < 0) {//向中间逼近
                l++;  
            } else {
                r--;  
            }  
        }  
    }
    /**
     * AC
     * @date Aug 12, 2019 1:08:37 PM
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length <= 2) {
			return res;
		}
		int target = 0;
		Arrays.sort(nums);
		Set<String> tmpSet = new HashSet<String>();
		
		for (int i = 0; i < nums.length; i++) {
			 if(i > 0 && nums[i] == nums[i-1]) {
				 continue;
			 }
			target = -nums[i];
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			for (int j = i + 1; j < nums.length; j++) {
				if (i == j) {
					continue;
				}
				if (map.containsKey(target - nums[j])) {
					int[] tmp = new int[3];
					tmp[0] = nums[i];
					tmp[1] = target - nums[j];
					tmp[2] = nums[j];
					Arrays.sort(tmp);
					String str = tmp[0] + "\t" + tmp[1] + "\t" + tmp[2];
					tmpSet.add(str);
				}
				map.put(nums[j], j);
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
	public static void main(String[] args) {
		ThreeSum s = new ThreeSum();
//		int[] a = { -1, 0, 1, 2, -1, -4 };
//		int[] a = { 0,0,0 };
		int[] a= {-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6};
		System.out.println(s.threeSum2(a));
	}
}
