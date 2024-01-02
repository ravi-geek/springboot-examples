package com.ravi.singleton;

public class DemoSingleton implements Cloneable{
    private DemoSingleton() {
        System.out.println("Singleton created");
    }

    private static class Nested {
        static DemoSingleton instance = new DemoSingleton();
    }

    public static DemoSingleton getInstance(){
        return Nested.instance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}

