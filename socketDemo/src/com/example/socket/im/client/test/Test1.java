package com.example.socket.im.client.test;

import com.example.socket.im.tool.UniqueIdGen;

/**
 * @author TechBirds
 * @date 15-1-13
 * @time 下午4:41
 * @vsersion 1.0
 */
public class Test1 {

    public static void main(String[] args){
        System.out.println(UniqueIdGen.nextId(480));
        System.out.println(UniqueIdGen.nextId(480));
    }
}
