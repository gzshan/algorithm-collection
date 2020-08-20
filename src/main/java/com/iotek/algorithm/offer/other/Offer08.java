package com.iotek.algorithm.offer.other;

/**
 * 剑指offer，08、跳台阶
 *
 * @author gzshan
 * @time 2020/8/17 16:39
 */
public class Offer08 {

    public int JumpFloor(int target){
        if(target == 0)
            return 0;
        if(target == 1)
            return 1;
        if(target == 2)
            return 2;

        int first=1,second=2;
        int res=0;
        for(int i=3;i<=target;i++){
            res = first+second;
            first = second;
            second = res;
        }
        return res;
    }

    public static void main(String[] args){
        Offer08 offer08 = new Offer08();
        int target = 5;
        System.out.println(offer08.JumpFloor(target));
    }
}
