package com.iotek.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序算法
 *
 * @author gzshan
 * @time 2020/8/20 16:03
 */
public class QucikSort {

    public void quickSort(int[] nums){
        if(nums == null || nums.length==0)
            return ;

        quickSort(nums,0,nums.length-1);
    }

    public void quickSort(int[] nums, int low, int high){
        if(low >= high)
            return ;
        int index = partition(nums,low,high);
        quickSort(nums, low , index-1);
        quickSort(nums, index+1, high);
    }

    //划分算法
    public int partition(int[] nums, int low, int high){
        int temp = nums[low];
        int i = low,j = high;

        while (i<j){
            while(i<j && nums[j]>=temp)
                j--;
            if(i<j){
                nums[i] = nums[j];
                i++;
            }

            while(i<j && nums[i]<temp)
                i++;
            if(i<j){
                nums[j] = nums[i];
                j--;
            }
        }
        nums[i]=temp;
        return i;
    }

    public static void main(String[] args){
        int[] nums = new int[]{10,9,7,8,6,5};
        QucikSort test = new QucikSort();
        test.quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
