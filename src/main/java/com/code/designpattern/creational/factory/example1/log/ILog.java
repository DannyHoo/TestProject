package com.code.designpattern.creational.factory.example1.log;

/**
 * @author
 * @Title: ILog
 *
 * @Description:
 *
 * @Created on 2017-06-23 10:12:55
 */
public interface ILog {
    void logProcess(String content);
    void logWarn(String content);
    void logError(String content);
}
