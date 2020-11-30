package com.example.service.pay;

import com.alibaba.fastjson.JSON;

/**
 * @date 2020/3/26下午1:57
 */
public class BasePayService {

    public <P, R> R payPrepare(P param, Class<? extends R> clazz) throws Exception {
        //风控校验
        this.check();

        String payPrepareJsonResult = "";
        try {
            //持久化支付记录

            //远程接口请求、解析结果
        } catch (Exception e) {
            //回滚本地事务
            
        } finally {
            //更新支付记录

            //返回结果
            R result = JSON.toJavaObject(JSON.parseObject(payPrepareJsonResult), clazz);
            return result;
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
