package com.code.thread.tool;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicLong;

/**
 * SimpleDateFormat类线程不安全测试类
 *
 * 解决方法
 * 1、把SimpleDateFormat当做局部变量
 * 2、把SimpleDateFormat放入ThreadLocal中使用
 * 3、加锁
 *
 * https://www.cnblogs.com/yw-ah/p/8512799.html
 *
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/10/30上午11:44
 */
public class SimpleDateFormatUnSafeTest {

    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
    static String dates[] = {"2019-10-11 01:44:59", "2019-10-12 02:44:59", "2019-10-15 03:44:59"};
    static AtomicLong atomicLong = new AtomicLong(0);

    public static void main(String[] args) {
        Runnable r[] = new Runnable[dates.length];

        for (int i = 0; i < r.length; i++) {
            int finalI = i;
            r[i] = new Runnable() {
                public void run() {
                    try {
                        for (int j = 0; j < 1000; j++) {
                            synchronized (SimpleDateFormatUnSafeTest.class){
                            System.out.println(atomicLong.incrementAndGet() + "-" + Thread.currentThread().getName() + "-" + getDate(dates[finalI]));
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            };
            new Thread(r[i]).start();
        }
    }

    public static Date getDate(String date) throws ParseException {
        return simpleDateFormat.parse(date);
    }
}
