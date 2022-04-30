package com.leetcode_4th.array;
/**
 * 
 * @author zealot
 * Created on: Mar 2, 2020 1:12:30 AM
 */
public class MergeSortedArray {
	public void merge(int[] nums1, int m, int[] nums2, int n) {
        //把nums1的元素挪到后边
        int len1 = nums1.length;
        int len2 = nums2.length;
        for(int i = m - 1, j = len1 - 1; i >=0 && j>=0; i--, j--){
            nums1[j] = nums1[i];
        }
        //两个数组开始同时遍历，if(nums1[i]<=nums2[j])，把nums1的元素放到idx上。
        //一个大的循环，m+n，下表idx。
        //两个小数组的下标，一个是i = nums1.length-m，遍历到nums1.length，一个是j=0，遍历到n
        int i = len1 - m, j = 0;
        for(int idx = 0; idx < m + n; idx++){
            if(i < len1 && j < n){
                if(nums1[i]<=nums2[j]){
                    nums1[idx] = nums1[i];
                    i++;
                }else{
                    nums1[idx] = nums2[j];
                    j++;
                }
            }else if(i < len1){
                nums1[idx] = nums1[i];
                i++;
            }else if(j < n){
                nums1[idx] = nums2[j];
                j++;
            }
        }
    }
}
