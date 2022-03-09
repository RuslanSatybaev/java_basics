package com.satybaev.homework.task1.additional_task;

public class RecursiveFibonacci {
    //f(n)=f(n-1) + f(n-2), причем f(0)=0, а f(1)=1

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            System.out.print(fibonacci(i)+" ");
        }
    }
    static int fibonacci(int n){
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        else{
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
