package com.danny.test.code.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: HeapOOM
 * @Copyright: Copyright (c) 2016
 * @Description: 模拟 堆内存 内存溢出
 * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/dannyhoo/data/jvm/dumpfile.hprof
 * jvm最大内存 jvm最小内存 开启内存堆转储快照
 * @Company: lxjr.com
 * @Created on 2018-06-08 14:50:39
 */
public class HeapOOM {
    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> oomObjectList = new ArrayList<>();
        while (true) {
            oomObjectList.add(new OOMObject());
        }
    }
}
