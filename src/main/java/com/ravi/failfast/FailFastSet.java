package com.ravi.failfast;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class FailFastSet {
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
        Set<String> set = new CopyOnWriteArraySet<>();
        set.add("one");
        set.add("two");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
            set.add("three");
        }
        System.out.println(set);
    }
}