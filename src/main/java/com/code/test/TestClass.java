package com.code.test;

import com.alibaba.fastjson.JSON;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Danny
 * @Title: TestClass
 * @Description:
 * @Created on 2017-01-17 00:17:17
 */
public class TestClass {

    public static void main(String[] args) {

        A a1=new A("a1",1);
        A a2=new A();
        org.springframework.beans.BeanUtils.copyProperties(a1, a2);

        List<Object> objects = new ArrayList<>();
        for (Object o : objects) {
            System.out.println();
        }
    }

   static class A{
        private String name;
        private int age;

       public A() {
       }

       public A(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public A setName(String name) {
            this.name = name;
            return this;
        }

        public int getAge() {
            return age;
        }

        public A setAge(int age) {
            this.age = age;
            return this;
        }
    }
    @Test
    public void soutTest() throws Exception {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cd /Users/dannyhoo/data/files/");
        runtime.exec("mkdir aaaaaa/");
        Process process = runtime.exec("ifconfig");
        int result = process.waitFor();
        ProcessWatcher processWatcher = new TestClass().new ProcessWatcher(process);
        processWatcher.start();
        int exitcode = process.waitFor();
        ArrayList<String> commandStream = processWatcher.getStream();
        processWatcher.setOver(true);
        System.out.println(JSON.toJSONString(commandStream));
        /*Class<?> clazz=new TestClass().getClass();
        System.out.println(clazz.toString());*/
    }

    class ProcessWatcher extends Thread {
        Process process;
        boolean over;
        ArrayList<String> stream;

        public ProcessWatcher(Process process) {
            this.process = process;
            over = false;
            stream = new ArrayList<String>();
        }

        public void run() {
            try {
                if (process == null) return;
                Scanner br = new Scanner(process.getInputStream());
                while (true) {
                    if (process == null || over) break;
                    while (br.hasNextLine()) {
                        String tempStream = br.nextLine();
                        if (tempStream.trim() == null || tempStream.trim().equals("")) continue;
                        stream.add(tempStream);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void setOver(boolean over) {
            this.over = over;
        }

        public ArrayList<String> getStream() {
            return stream;
        }
    }
}
