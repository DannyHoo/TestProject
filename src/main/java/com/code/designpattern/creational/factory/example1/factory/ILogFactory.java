package com.code.designpattern.creational.factory.example1.factory;


import com.code.designpattern.creational.factory.example1.log.ILog;

/**
 * @author
 * @Title: ILogFactory
 *
 * @Description:
 *
 * @Created on 2017-06-23 10:04:12
 */
public interface ILogFactory {
    //AbstractLog getLog();
    ILog getLog();
}
