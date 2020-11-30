package com.example.util;

import cn.hutool.http.HttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

/**
 * @date 2020/11/10下午2:20
 * <dependency>
 * <groupId>cn.hutool</groupId>
 * <artifactId>hutool-all</artifactId>
 * <version>4.3.1</version>
 * <scope>compile</scope>
 * </dependency>
 */
@Slf4j
public class DingUtil {
    /**
     * 给钉钉群发送消息方法
     *
     * @param content 消息内容
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     * @throws InvalidKeyException
     */
    public static String sendMsg(String content) throws NoSuchAlgorithmException, UnsupportedEncodingException, InvalidKeyException {
        try {
            //群机器人复制到的秘钥secret
            String secret = "SEC7c8bf9426574186dc3b6cf6095efb8d99e2d13dfadb7772964c31c967ae7d8d2";
            //获取系统时间戳
            long timestamp = Instant.now().toEpochMilli();
            //拼接
            String stringToSign = timestamp + "\n" + secret;
            //使用HmacSHA256算法计算签名
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes("UTF-8"), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes("UTF-8"));
            //进行Base64 encode 得到最后的sign，可以拼接进url里
            String sign = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
            //钉钉机器人地址（配置机器人的webhook）
            String webhook = "https://oapi.dingtalk.com/robot/send?access_token=c16f71916caf9346965925a1242cb671013d946f86567ad8e91e04d96de4d9a9";
            String dingUrl = webhook + "&timestamp=" + timestamp + "&sign=" + sign;

            String result = HttpUtil.post(dingUrl, content);
            return result;
        } catch (Exception e) {
            log.error("钉钉推送消息出现异常");
            return null;
        }

    }


    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        System.out.println("开始");
        /*String result=DingUtil.sendMsg("欢迎大家，这是用来做测试的，如果被打扰到，请您关闭群通知，再次说声抱歉。");
        System.out.println(result);*/
    }
}
