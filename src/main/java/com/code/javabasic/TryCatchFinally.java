package com.code.javabasic;

/**
 * @author Danny
 * @Title: TryCatchFinally
 * @Description:
 * @Created on 2018-09-18 21:27:23
 */
public class TryCatchFinally {

    final int i;
    final static int j;

    static{
        j=0;
        System.out.println("j="+j);
    }
    public TryCatchFinally(int i) {
        this.i = i;
        System.out.println("i="+i);
    }

    public static void main(String[] args) {
        try{
            TryCatchFinally tryCatchFinally=new TryCatchFinally(1);
            throw new Exception("异常");
        }catch (Exception e){
            System.out.println("exception");
        }finally {
            System.out.println("finally");
        }
    }
}
