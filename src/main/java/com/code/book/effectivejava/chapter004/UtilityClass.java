package com.code.book.effectivejava.chapter004;

/**
 * 禁止实例化，只使用静态方法、变量
 */
public class UtilityClass {
    public UtilityClass() {
        throw new AssertionError();
    }
}
