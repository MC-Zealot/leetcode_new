package com.leetCode._2th;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as
 * one sorted array.
 * 
 * Note: You may assume that nums1 has enough space (size that is greater or
 * equal to m + n) to hold additional elements from nums2. The number of
 * elements initialized in nums1 and nums2 are m and n respectively.
 * 
 * @author Zealot
 * @date 2016年1月26日 下午8:59:32
 */
public class MergeSortedArray {
	 public void merge(int[] nums1, int m, int[] nums2, int n) {
	        int[] a = new int[m+n];
	        if(m==0){
	            nums1 =  nums2;
	            return ;
	        }
	        if(n==0){
//	            a = nums1;
	            return ;
	        }
	        
	        int j=0,k=0;
	        for(int i = 0; i < m+n; i++){
	        	if(j==m){
            		a[i] = nums2[k++];
            		continue;
            	}
	        	if(k==n){
	        		a[i]= nums1[j++];
	        		continue;
	        	}
	            if(nums1[j]>nums2[k]){
	                a[i] = nums2[k];
	                	k++;
	            }else if(nums1[j]<nums2[k]){
	            	
	                a[i] = nums1[j];
	                	j++;
	            }else{
	                a[i]= nums1[j];
	            	if(i+1<n+m){
	            		a[++i] = nums2[k];
	            	}
	                if(k<n-1) {
	                	k++;
	                }
	                if(j<m-1) {
	                	j++;
	                }
	            }
	        }
	        nums1 = a;
	        for(int i = 0; i < a.length; i++) {
	        	System.out.print(a[i]+ " ");
	        }
	    }
	 public void merge2(int A[], int m, int B[], int n) {
	        int i = m - 1, j = n - 1, k = m + n - 1;
	        while(i >= 0 && j >= 0) {
	            A[k--] = A[i] > B[j] ? A[i--] : B[j--];
	        }
	        while(j >= 0) {
	            A[k--] = B[j--];
	        }
	    }

	 public static void main(String[] args) {
		 MergeSortedArray msa = new MergeSortedArray();
		 int[] a = {0};
		 int[] b = {1};
		 msa.merge2(a,0, b, b.length);
	}
}
