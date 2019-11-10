package com.code.book.effectivejava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Danny
 * @Title: Main
 * @Description:
 * @Created on 2018-10-17 12:52:50
 */
public class MainTest {

    public static void main(String[] args) {
        Boolean.valueOf(true);
        List list= Collections.synchronizedList(new ArrayList<>());
    }
}
