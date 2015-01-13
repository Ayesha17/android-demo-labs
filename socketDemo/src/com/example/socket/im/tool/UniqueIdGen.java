/*   
 * Copyright (c) 2012-2013 Qeemo Ltd. All Rights Reserved.      
 */
package com.example.socket.im.tool;

import java.math.BigInteger;

/**
 * @author Kurten
 * @date 2014/9/30
 * @time 12:23
 * @vsersion 1.0
 */
public class UniqueIdGen {
    private static final long twepoch = 1288834974657l;
    private static final int workerIdBits = 5;
    private static final int dataCenterIdBits = 5;
    private static final int maxWrokerId = -1 ^ (-1 << workerIdBits);
    private static final int maxDataCenterId = -1 ^ (-1 << dataCenterIdBits);
    private static final int sequenceBits = 12;
    private static final int workerIdShift = sequenceBits;
    private static final int dataCenterIdShift = sequenceBits + workerIdBits;
    private static final int timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
    private static final int sequenceMask = -1 ^ (-1 << sequenceBits);
    private static long lastTimestamp = -1;
//    //设置默认值,从环境变量取
    private static int c_workerId = 1;
    private static int c_dataCenterId = 1;
    private static int c_sequence = 0;

    public static void init(int workerId, int dataCenterId, int sequence) {
        c_workerId = workerId;
        c_dataCenterId = dataCenterId;
        c_sequence = sequence;
    }

    public static long nextId(int workerId, int dataCenterId, int sequence) {
        if (workerId > maxWrokerId) {
            workerId = workerId % maxWrokerId;
            dataCenterId++;
        }
        if (workerId < 0) {
            workerId = 1;
            dataCenterId++;
        }
        if (dataCenterId > maxDataCenterId) {
            dataCenterId = dataCenterId % maxDataCenterId;
            sequence++;
        }
        if (dataCenterId < 0) {
            dataCenterId = 1;
            sequence++;
        }

        long timestamp = timeGen();
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                timestamp = tilNextMillis(lastTimestamp);
            }
        } else {
            sequence = 0;
        }
        if (timestamp < lastTimestamp) {
            timestamp = lastTimestamp + 10;  //向后推10毫秒
        }

        lastTimestamp = timestamp;
        long shiftNum = (dataCenterId << dataCenterIdShift) |
                (workerId << workerIdShift) | sequence;

        BigInteger nfirst = new BigInteger(String.valueOf(timestamp - twepoch), 10);
        nfirst = nfirst.shiftLeft(timestampLeftShift);
        BigInteger nnextId = nfirst.or(new BigInteger(String.valueOf(shiftNum), 10));
        return nnextId.longValue();
    }

    public static String nextId(int workerId) {
        return String.valueOf(nextId(workerId, c_dataCenterId, c_sequence));
    }

    public static long nextId() {
        return nextId(c_workerId, c_dataCenterId, c_sequence);
    }

    private static long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private static long timeGen() {
        return System.currentTimeMillis();
    }

    public static void main(String ...args) {
        System.out.println(UniqueIdGen.nextId(1, 1, 0));
    }
}
