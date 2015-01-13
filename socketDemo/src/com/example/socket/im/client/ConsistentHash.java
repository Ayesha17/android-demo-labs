/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 */
package com.example.socket.im.client;

import java.util.Collection;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author Kurten
 * @date 13-12-9
 * @time 下午2:59
 * @vsersion 1.0
 */
public class ConsistentHash {
    private final int numberOfReplicas;
    private final SortedMap<Integer, String> circle = new TreeMap<Integer, String>();

    public ConsistentHash(int numberOfReplicas) {
        this.numberOfReplicas = numberOfReplicas;
    }

    public void addAll(Collection<String> nodes) {
        for (String node : nodes) {
            add(node);
        }
    }

    public void add(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.put(MurmurHash.hash32(node + i), node);
        }
    }

    public void remove(String node) {
        for (int i = 0; i < numberOfReplicas; i++) {
            circle.remove(MurmurHash.hash32(node + i));
        }
    }

    public String get(String key) {
        if (circle.isEmpty()) {
            return null;
        }
        int hash = MurmurHash.hash32(key);
        if (!circle.containsKey(hash)) {
            SortedMap<Integer, String> tailMap = circle.tailMap(hash);
            hash = tailMap.isEmpty() ? circle.firstKey() : tailMap.firstKey();
        }
        return circle.get(hash);
    }

    public int size() {
        return circle.size();
    }
}