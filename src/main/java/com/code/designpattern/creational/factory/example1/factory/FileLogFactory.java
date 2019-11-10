package com.code.designpattern.creational.factory.example1.factory;

import com.code.designpattern.creational.factory.example1.log.FileLog;
import com.code.designpattern.creational.factory.example1.log.ILog;

/**
 * @author
 * @Title: FileLogFactory
 *
 * @Description:
 *
 * @Created on 2017-06-23 09:48:57
 */
public class FileLogFactory /*extends AbstractLogFactory*/ implements ILogFactory {
    public ILog getLog() {
        return new FileLog();
    }
    /*public AbstractLog getLog() {
        return new FileLog();
    }*/
}
