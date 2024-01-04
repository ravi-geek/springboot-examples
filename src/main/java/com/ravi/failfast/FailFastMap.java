package com.ravi.failfast;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FailFastMap {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map = Collections.synchronizedMap(map1);
//        Map<String, String> map = new ConcurrentHashMap<>();
        map.put("one", "one");
        map.put("two", "two");
        Iterator<String> iterator = map.keySet().iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
            map.put("three", "three");
        }
        System.out.println(map);
    }
}
