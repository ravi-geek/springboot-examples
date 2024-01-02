package com.ravi.singleton;

public class SingletonDemo {
    public static void main(String[] args) throws CloneNotSupportedException {

        // Thread 1 will call getInstance
        /*Thread t1 = new Thread(new Runnable() {
            public void run() {
                DemoSingleton a = DemoSingleton.getInstance();
                System.out.println(a.hashCode());
            }
        });

        // Thread 2 will also call getInstance
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                DemoSingleton b = DemoSingleton.getInstance();
                System.out.println(b.hashCode());
            }
        });

        // Start both the Threads
        t1.start();
        t2.start();*/

        DemoSingleton singleton1 = DemoSingleton.getInstance();
        System.out.println(singleton1.hashCode());
        DemoSingleton singleton2 = (DemoSingleton) singleton1.clone();
        System.out.println(singleton2.hashCode());

    }
}
