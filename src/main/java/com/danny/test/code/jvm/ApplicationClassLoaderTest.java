package com.danny.test.code.jvm;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.util.List;

/**
 * @author huyuyang@lxfintech.com
 * @Title: ApplicationClassLoaderTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2018-07-19 20:38:09
 */
public class ApplicationClassLoaderTest {
    public static void main(String[] args) throws Exception{

        List<GarbageCollectorMXBean> beans = ManagementFactory.getGarbageCollectorMXBeans();
        for (GarbageCollectorMXBean bean : beans) {
            System.out.println(bean.getName());
        }

        /*ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        Object object=systemClassLoader.loadClass("com.danny.test.code.jvm.ApplicationClassLoaderTest").newInstance();
        System.out.println(object instanceof com.danny.test.code.jvm.ApplicationClassLoaderTest);*/
    }
}
