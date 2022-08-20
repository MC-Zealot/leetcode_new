package com.leetcode_6th.core;

public class SortColors {
    /**
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            while (j >= 0 && nums[j] == 2){
                j--;
            }
            if(j <= 0 || i >=j){
                break;
            }
            if(i < nums.length && nums[i] == 2){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            i++;
        }
        i = 0;
        j = nums.length - 1;
        while (i < j && j >=0 && i < nums.length){
            while (j >= 0 && (nums[j] == 2 || nums[j] == 1)){
                j--;
            }
            if(j <= 0 || i >=j){
                return;
            }
            if(i < nums.length && nums[i] == 1){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
            }
            i++;
        }
    }

    /**
     * 计数的方式
     * 循环了2次
     * @param nums
     */
    public void sortColors2(int[] nums) {
        int a0 = 0;
        int a1 = 0;
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            if(a == 1){
                a1++;
            }else if (a == 0){
                a0++;
            }
        }
        for(int i = 0; i < a0; i++){
            nums[i] = 0;
        }
        for (int i = a0; i < a0 + a1; i++){
            nums[i] = 1;
        }
        for(int i = a0 + a1; i < nums.length; i++){
            nums[i] = 2;
        }
    }

    /**
     * 计数的方式
     * 循环了2次
     * @param nums
     */
    public void sortColors3(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return;
        }
        // all in [0, zero] = 0
        // all in (zero, i) = 1
        // all in [two, len - 1] = 2

        // 为了保证初始化的时候 [0, zero] 为空，设置 zero = -1，
        // 所以下面遍历到 0 的时候，先加，再交换
        int zero = -1;

        // 为了保证初始化的时候 [two, len - 1] 为空，设置 two = len
        // 所以下面遍历到 2 的时候，先交换，再减
        int two = len;
        int i = 0;
        // 当 i == two 的时候，还有一个元素还没有看，
        // 因此，循环可以继续的条件是 i <= two
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else {
                two--;
                swap(nums, i, two);
            }
        }
    }

    public void sortColors4(int[] nums) {
        int len = nums.length;
        if(len < 2){
            return;
        }
        // all in [0, p0) = 0
        // all in [p0, i) = 1
        // all in (p2, len - 1] = 2
        int p0 = 0;
        int i = 0;
        int p2 = len - 1;
        while(i <= p2){
            if(nums[i] == 0){
                swap(nums, i, p0);
                p0++;
                i++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums, i, p2);
                p2--;
            }
        }
    }

    /**
     * 两个指针分别用来交换 0 和 1。
     * 如果找到1，则与p1互换，p1++
     * 如果找到0，则与p0互换， p0++
     *      当p0 < p1的时候，p0++之后的p0肯定是1（如果不管的话，会把这个1替换到后边去），
     *      所以需要把i与p1进行互换（此时i为1，p1为2）
     * @param nums
     */
    public void sortColors5(int[] nums) {
        int n = nums.length;
        int p0 = 0, p1 = 0;
        for (int i = 0; i < n; ++i) {
            if (nums[i] == 1) {
                int temp = nums[i];
                nums[i] = nums[p1];
                nums[p1] = temp;
                ++p1;
            } else if (nums[i] == 0) {
                int temp = nums[i];
                nums[i] = nums[p0];
                nums[p0] = temp;
                if (p0 < p1) {
                    temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                }
                ++p0;
                ++p1;
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 解题时，先定义两个指针red和blue，初始时red指向下标0，blue指向数组最后一位。然后再建立一个index从下标0开始循环数组的每一个数字。如果当前数字是0，那么交换当前下标与red指针指向的数字，red指针加一。此时能够保证red指针之前的数字都是0。
     *
     * 若当前数字是2，我们交换当前下标与blue指针指向的数字，然后blue下标减一，此时能够保证blue下标后面的数字都是2。这里需要注意一点，交换后，当前下标index值可能会变为0，1，2三种情况，因此我们还需要再次判断一下当前index，即需要index减一。
     *
     * 若当前数字是1，两个指针下标不变，index加一继续向后循环即可。
     * https://leetcode.jp/leetcode-75-sort-colors-%E8%A7%A3%E9%A2%98%E6%80%9D%E8%B7%AF%E5%88%86%E6%9E%90/
     * @param nums
     */
    public void sortColors6(int[] nums) {
        int red=0,blue=nums.length-1;
        for(int i=0;i<=blue;i++){
            if(nums[i]==0){
                nums[i]=nums[red];
                nums[red]=0;
                red++;
            }else if(nums[i]==2){
                nums[i]=nums[blue];
                nums[blue]=2;
                blue--;
                i--;
            }
        }
    }
    public static void main(String[] args) {

    }
}
