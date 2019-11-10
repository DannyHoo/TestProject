package com.code.designpattern.creational.factory.example1.factory;

import com.code.designpattern.creational.factory.example1.log.DataBaseLog;
import com.code.designpattern.creational.factory.example1.log.ILog;

/**
 * @author
 * @Title: DataBaseLogFactory
 *
 * @Description:
 *
 * @Created on 2017-06-23 09:49:19
 */
public class DataBaseLogFactory /*extends AbstractLogFactory*/ implements ILogFactory {
    public ILog getLog() {
        return new DataBaseLog();
    }

    /*public AbstractLog getLog(){
        return new DataBaseLog();
    }*/

}
