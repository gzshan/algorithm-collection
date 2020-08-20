package com.iotek.algorithm.offer.stackOrQueue;

import java.util.Stack;

/**
 * 剑指offer：05、用两个栈实现队列
 *
 * @author gzshan
 * @time 2020/8/17 15:13
 */
public class Offer05 {

    private Stack<Integer> stack1 = new Stack<>();
    private Stack<Integer> stack2 = new Stack<>();

    public void push(int node){
        stack1.push(node);
    }

    public int pop(){
        if(stack2.isEmpty()){  //栈2空，倒进去
            while(!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args){
        Offer05 offer05 = new Offer05();

        offer05.push(1);
        offer05.push(2);
        offer05.push(3);
        System.out.println(offer05.pop());
    }
}
