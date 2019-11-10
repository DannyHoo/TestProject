package com.code.designpattern.creational.factory.example1.log;

/**
 * @author
 * @Title: FileLog
 *
 * @Description:
 *
 * @Created on 2017-06-23 09:49:41
 */
public class FileLog /*extends AbstractLog*/ implements ILog{

    public void logProcess(String content) {
        System.out.println(this.getClass().getSimpleName()+" write file process log:"+content);
    }

    public void logWarn(String content) {
        System.out.println(this.getClass().getSimpleName()+" write file warn log:"+content);
    }

    public void logError(String content) {
        System.out.println(this.getClass().getSimpleName()+" write file error log:"+content);
    }
}
