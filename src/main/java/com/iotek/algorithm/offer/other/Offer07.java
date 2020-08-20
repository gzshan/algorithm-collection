package com.iotek.algorithm.offer.other;

/**
 * 剑指offer：07、斐波那契数列
 *
 * @author gzshan
 * @time 2020/8/17 16:08
 */
public class Offer07 {

    //斐波那契数列：0，1,1,2,3,5,8,13···
    public int Fibonacci(int n){
        if(n==0)
            return 0;
        if(n==1)
            return 1;

        int first = 0, second = 1;
        int res = 0;
        for(int i=2;i<=n;i++){
            res = first + second;
            first = second;
            second = res;
        }
        return res;
    }

    public static void main(String[] args){
        Offer07 offer07 = new Offer07();
        int res = offer07.Fibonacci(6);
        System.out.println(res);
    }

}
