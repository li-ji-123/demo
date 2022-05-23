package com.example.demo;

import cn.hutool.core.date.LocalDateTimeUtil;
import cn.hutool.core.net.NetUtil;
import cn.hutool.core.util.IdUtil;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;

@Slf4j
public class test {


    // 2020-01-01 00:00:00 对应的秒
    private final static long beginTs = 1577808000L;

    // 顺序号最大值
    private final static long maxSequence = 4194300L;

    // 最大时钟回拨(秒)
    private final static long maxTimeback = 1L;

    private long lastTs = 0L;

    private long processId;
    private int processIdBits = 8;

    private long sequence = 1L;
    private int sequenceBits = 8;

    public test() {

        String ipAddr = NetUtil.getLocalhostStr();
        log.info("当前机器的ipAddr:" + ipAddr);

        Long workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        workerId = workerId % 1024;

        log.info("当前机器的workId:" + workerId);

        this.processId = workerId;
    }

    public test(long processId) {
        if (processId > ((1 << processIdBits) - 1)) {
            throw new RuntimeException("进程ID超出范围，设置位数" + processIdBits + "，最大" + ((1 << processIdBits) - 1));
        }
        this.processId = processId;
    }

    // 获取当前时间(秒为单位)
    protected long timeGen() {
        return System.currentTimeMillis() / 1000;
    }

    // 生成一个Id
    public synchronized long nextId() {

        // 获取当前时间(秒为单位)
        long ts = timeGen();

        // 刚刚生成的时间戳比上次的时间戳还小，出错
        long tempDiff = lastTs - ts;
        if (tempDiff >= maxTimeback) {
            log.info("时钟回拨超过4194秒，存在Id重复风险");
            tempDiff = lastTs + maxTimeback;
        }

        sequence = sequence + 1;
        if(sequence >= maxSequence)
        {
            sequence = 1;
        }

        // 更新lastTs时间戳
        lastTs = ts;
        long timeDiff = ts - beginTs;

        return (timeDiff << (processIdBits + sequenceBits)) | (processId << sequenceBits) | sequence;
    }

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub

        test ig = new test();
//
//        for (int i = 0; i < 5; i++) {
//            System.out.println(i+"------"+ig.nextId());
//            Thread.sleep(1000);
//        }
//        NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        String ipAddr = NetUtil.getLocalhostStr();
        log.info("当前机器的ipAddr:" + ipAddr);

        Long workerId = NetUtil.ipv4ToLong(NetUtil.getLocalhostStr());
        workerId = workerId % 1024;

        log.info("当前机器的workId:" + workerId);
//        System.out.println(IdUtil.getSnowflake(workerId).nextIdStr());
//        System.out.println(IdUtil.getSnowflake(workerId).nextIdStr());
//        System.out.println(IdUtil.getSnowflake(workerId).nextIdStr());
//        System.out.println(IdUtil.getSnowflake().nextIdStr());
//        System.out.println(IdUtil.getSnowflake().nextIdStr());
//        System.out.println(IdUtil.getSnowflake().nextIdStr());

        LocalDateTime time = LocalDateTime.now();
        System.out.println(time);
        String t = LocalDateTimeUtil.format(time,"yyyy-MM-dd HH:mm:ss");
        System.out.println(t);
    }
}
