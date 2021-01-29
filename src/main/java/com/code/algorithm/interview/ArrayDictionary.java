package com.code.algorithm.interview;

import java.util.HashMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ArrayDictionary<K, V> {
    private Map<K, V>[] dictionary;

    public ArrayDictionary(int initialCapacity) {
        this.dictionary = new HashMap[initialCapacity];
    }

    public void put(int arrayNumber, K k, V v) {
        if (dictionary[arrayNumber] == null) {
            dictionary[arrayNumber] = new HashMap<>();
        }
        dictionary[arrayNumber].put(k, v);
    }

    public void get(int arrayNumber, K k, V v) {
        dictionary[arrayNumber].put(k, v);
    }


    /**
     * 保存函数
     *
     * @return
     */
    public String store() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < dictionary.length; i++) {
            Iterator iter = dictionary[i].entrySet().iterator();
            int number = 0;
            while (iter.hasNext()) {
                Map.Entry<String, String> entry = (Map.Entry<String, String>) iter.next();
                str.append(transSpecial(entry.getKey()));
                str.append("=");
                str.append(transSpecial(entry.getValue()));
                number++;
                if (dictionary[i].size() != number) {
                    str.append(";");
                }
            }
            if (i != dictionary.length - 1) {
                str.append("\n");
            }
        }

        return str.toString();
    }

    public String transSpecial(String a) {
        char chars[] = a.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        //循环寻找特殊字符
        for (int i = 0; i < chars.length; i++) {
            //判断特殊字符
            if (chars[i] == '=' || chars[i] == ';' || chars[i] == '\n'|| chars[i] == '\\') {
                //前面加上|
                stringBuilder.append('\\');
            }
            stringBuilder.append(chars[i]);
        }
        return stringBuilder.toString();
    }

    /**
     * 加载函数
     *
     * @return
     */
    public ArrayDictionary load(String str) {

        ArrayDictionary arrayDictionary = new ArrayDictionary<String, String>(10);
        char chars[] = str.toCharArray();

        //记录 数组下标
        int flag = 0;
        //记录当前内容key
        StringBuilder key = new StringBuilder();
        //记录当前value
        StringBuilder value = new StringBuilder();
        //当前内容
        StringBuilder present = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            //判断是否是关键字符
            if ( chars[i] == '\\') {
                //判断修饰符如果修饰\\就跳一下
                if (chars[i + 1] == '\\') {
                    present.append(chars[i+1]);
                    i++;
                }
                continue;
            }
            if (i == 0) {
                present.append(chars[i]);
                continue;
            }
            //如果是不等于号标志
            if (chars[i - 1] != '\\') {
                if (chars[i] == '=') {
                    //之前的放到key里
                    key.append(present);
                    present.setLength(0);//清空
                    continue;
                }
                if (chars[i] == '\n' || chars[i] == ';') {
                    //之前的放到v里
                    value.append(present);
                    //put当前数组下标的值
                    arrayDictionary.put(flag, key.toString(), value.toString());
                    present.setLength(0);//清空
                    key.setLength(0);
                    value.setLength(0);
                    if (chars[i] == '\n') {
                        flag++;
                    }
                    continue;
                }
            }
            present.append(chars[i]);
            //如果是最后一个就加进去
            if (i + 1 == chars.length) {
                //之前的放到v里
                value.append(present);
                //put当前数组下标的值
                arrayDictionary.put(flag, key.toString(), value.toString());
                present.setLength(0);//清空
                key.setLength(0);
                value.setLength(0);
            }
        }
        return arrayDictionary;
    }
}
