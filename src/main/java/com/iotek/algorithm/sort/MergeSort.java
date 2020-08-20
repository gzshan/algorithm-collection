package com.iotek.algorithm.sort;

import java.util.Arrays;

/**
 * 归并排序算法
 *
 * @author gzshan
 * @time 2020/8/20 16:28
 */
public class MergeSort {

    public void mergeSort(int[] nums){
        if(nums==null || nums.length==0)
            return;
        mergeSort(nums,0,nums.length-1);
    }


    public void mergeSort(int[] nums, int low, int high){
        if(low>=high)
            return ;
        int mid = low+(high-low)/2;
        mergeSort(nums,low,mid);
        mergeSort(nums,mid+1,high);
        merge(nums,low,mid,high);
    }

    //归并算法
    public void merge(int[] nums, int low,int mid,int high){
        int[] temp = new int[high-low+1];
        int i = low,j = mid+1;
        int k = 0;

        while(i<=mid && j<=high){
            if(nums[i]<=nums[j]){
                temp[k++] = nums[i++];
            }else{
                temp[k++] = nums[j++];
            }
        }

        while(i<=mid)
            temp[k++] = nums[i++];
        while(j<=high)
            temp[k++] = nums[j++];

        for(int t=0; t<temp.length;t++){
            nums[low+t] = temp[t];
        }
    }

    public static void main(String[] args){
        int[] nums = new int[]{10,9,7,8,6,5};
        MergeSort test = new MergeSort();
        test.mergeSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
