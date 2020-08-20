package com.iotek.algorithm.offer.stackOrQueue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 扩展：用两个队列实现栈
 *
 * @author gzshan
 * @time 2020/8/17 15:30
 */
public class MyStack {

    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int topValue;

    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        topValue = -1;
    }

    public void push(int x) {  //加到不为空的队列中
        if(!q1.isEmpty()) {
            q1.add(x);
        } else {
            q2.add(x);
        }
        topValue = x;
    }

    public int pop() {
        int temp = 0;
        while(!q1.isEmpty()){  //q1不为空
            temp = q1.poll();
            if(q1.isEmpty())
                return temp;
            q2.add(temp);
            topValue = temp;
        }

        while(!q2.isEmpty()){  //q2不为空
            temp = q2.poll();
            if(!q2.isEmpty()){
                q1.add(temp);
                topValue = temp;
            }
        }
        return temp;
    }

    public int top(){
        return topValue;
    }

    public boolean empty(){
        return q1.isEmpty() && q2.isEmpty();
    }

    public static void main(String[] args){
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
        myStack.pop();
        System.out.println(myStack.top());
    }
}
