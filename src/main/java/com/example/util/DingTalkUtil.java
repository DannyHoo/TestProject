package com.example.util;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiRobotSendRequest;
import com.dingtalk.api.response.OapiRobotSendResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.MDC;
import org.springframework.util.StringUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @date 2020/11/10下午2:36
 * 钉钉开发文档：https://ding-doc.dingtalk.com/doc#/serverapi2/qf2nxq
 *
 * <dependency>
 * <groupId>com.taobao.sdk</groupId>
 * <artifactId>taobao-sdk</artifactId>
 * <version>1.0</version>
 * </dependency>
 */
@Slf4j
public class DingTalkUtil {

    private String dingKey = "SEC7c8bf9426574186dc3b6cf6095efb8d99e2d13dfadb7772964c31c967ae7d8d2";
    private String dingUrl = "https://oapi.dingtalk.com/robot/send?access_token=c16f71916caf9346965925a1242cb671013d946f86567ad8e91e04d96de4d9a9";

    public void sendDingMsgAsyncUseRequest() {
        if (StringUtils.isEmpty(dingKey) || StringUtils.isEmpty(dingUrl)) {
            return;
        }
        try {
            Mac mac = null;
            Long timestamp = System.currentTimeMillis();
            String stringToSign = timestamp + "\n" + dingKey;
            mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(dingKey.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] signData = mac.doFinal(stringToSign.getBytes(StandardCharsets.UTF_8));
            String encode = URLEncoder.encode(new String(Base64.encodeBase64(signData)), "UTF-8");
            DingTalkClient client = new DefaultDingTalkClient(dingUrl + "&timestamp=" + timestamp + "&sign=" + encode);

            OapiRobotSendRequest request = new OapiRobotSendRequest();
            /*request.setMsgtype("markdown");
            OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
            markdown.setTitle("订单系统告警");
            StringBuilder markdownTextBuilder=new StringBuilder();

            markdownTextBuilder.append("");
            markdownTextBuilder.append("|  定时任务   | 执行次数  |");
            markdownTextBuilder.append("|  ----  | ----  |");
            markdownTextBuilder.append("| Handler1  | 14 |");
            markdownTextBuilder.append("| Handler2 | <span style=\"color:red;\">未执行</span> |");

            //markdown.setText("欢迎大家，这是用来做测试的，如果被打扰到，请您关闭群通知，再次说声抱歉。");
            markdown.setText(markdownTextBuilder.toString());
            request.setMarkdown(markdown);
            OapiRobotSendRequest.At at=new OapiRobotSendRequest.At();
            at.setAtMobiles(Arrays.asList("13001073367"));
            request.setAt(at);*/

            request.setMsgtype("markdown");
            OapiRobotSendRequest.Markdown markdown = new OapiRobotSendRequest.Markdown();
            markdown.setTitle("定时任务执行情况");
            /*String text="#### " +
                    LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                    "~" +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                    "定时任务执行情况\n\n" +
                    "collectionPaymentSyncJob ：" + "1" + "\n\n" +
                    "collectionOverdueSyncJob ：" + "198" + "\n\n" +
                    "collectionDataSyncJob ：" + "0" + "\n\n";
            markdown.setText(text);*/
            String text = "#### " +
                    LocalDateTime.now().minusDays(1).format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                    "~" +
                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")) +
                    "定时任务执行情况\n\n";

            List<String> scheduleNotifyHandlers=Arrays.asList("Handler1","Handler2");
            for (String scheduleNotifyHandler : scheduleNotifyHandlers) {
                String result = String.valueOf(new Random().nextInt(1000));
                text += scheduleNotifyHandler +" ：" + result + "\n\n ";
            }

            markdown.setText(text);
            request.setMarkdown(markdown);

            OapiRobotSendResponse response = client.execute(request);
            log.info("response:\n{}", JSON.toJSONString(response));
        } catch (Exception e) {
            e.printStackTrace();
            log.error("send ding msg error", e);
        }
    }

    public static void main(String[] args) {
        DingTalkUtil dingTalkUtil = new DingTalkUtil();
        dingTalkUtil.sendDingMsgAsyncUseRequest();
    }
}
