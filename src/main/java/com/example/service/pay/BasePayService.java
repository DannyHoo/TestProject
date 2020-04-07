package com.example.service.pay;

/**
 * @date 2020/3/26下午1:57
 */
public class BasePayService {

    public void payPrepare() throws Exception {
        //风控校验
        this.check();
        try {
            //持久化
            //远程接口请求
        } catch (Exception e) {

        } finally {

        }

    }

    private void check() throws Exception {
        if (true) {

        }
        if (false) {
            throw new Exception("校验不通过");
        }
    }
}
