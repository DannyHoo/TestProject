package com.code.javabasic;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @author Danny
 * @Title: JavaDataType
 * @Description:
 * @Created on 2018-11-08 15:21:39
 */
public class JavaDataType {
    public static void main(String[] args) {
        /*String str="";
        byte[] bytes=str.getBytes();
        for (byte b:bytes){
            System.out.println(b);
        }*/
        System.out.println(JSON.toJSONString(new DataEntry()).getBytes().length);
        System.out.println(JSON.toJSONString(new DataEntry()));

    }

    @Data
    static class DataEntry{
        private static final long serialVersionUID = 7540892320952742445L;
        private Long id=12345L;
        private Long appId=12345L;
        private Long channelConfigId=12345L;
        private String status="SUCCWSS";
//        private String companyInfo="{\"company_operator_idcard_front\":\"f1de1203b77142a687e0624e1f15bd1f.png\",\"company_operator_idcard_back\":\"921a1b5271044e0d99b96a32d0484ea7.jpg\",\"company_customer_service_phone\":\"客服电话\",\"company_website_icp\":\"ICP 备案号\",\"company_website\":\"需接入支付的网站地址/公司网站\",\"company_official_letter\":\"申请公函\",\"company_legal_person_idcard_front\":\"e987e0a0507644a595a1f529b8f7a5f4.png\",\"company_legal_person_idcard_back\":\"a6c977d186f14ff8adea1ece7aaa49a5.jpg\"}";
//        private String bankInfo="{\"account_subbranch\":\"银行卡所在支行\",\"account_licence\":\"10ba3932acfb4860928e38078606c668.png\",\"account_name\":\"银行账户名称\",\"account_no\":\"银行对公账号\"}";
//        private String appInfo="{\"app_index_pic\":\"844bc067d81e431a87d6565d1c8eb340.gif\",\"app_description\":\"APP介绍\",\"app_product_detail\":\"e0b782e4890344d2a043b3ffaa6d8c11.jpg\",\"app_product_category\":\"1be4b424cfda45ce8341963bc3d7d04b.jpg\",\"app_product_tail\":\"e869487681a747188772f2c8fe5a1e2c.gif\",\"app_product_cashier\":\"aa56e4f5a8fc4bdcb1955d7aa33374d9.jpg\",\"app_name\":\"APP名称\",\"app_icon\":\"bfdc8ff9eb99421a892f4a9c0787667b.jpg\"}";
//        private String emailInfo="{\"email_login_url\":\"邮箱登录网址\",\"email_account\":\"邮箱帐号\",\"email_password\":\"邮箱密码\"}";
//        private String parameters="{\"email_login_url\":\"邮箱登录网址\",\"email_account\":\"邮箱帐号\",\"email_password\":\"邮箱密码\"}";
//        private String code="dfdfdfdfd";
//        private String name="不就科技有限送你的饭有限公司";
        private List<String> scene;
        private String description="不就科技有限送你的饭有限公司";
        private String category="dfdfdfdfd";
        private BigDecimal rate=BigDecimal.ONE;

        private Date applyTime=new Date();
        private Date auditTime=new Date();
        private String auditDescription="不就科技有限送你的饭有限公司";
        private String auditRecord="不就科技有限送你的饭有限公司";
        private Long operatorId=23234L;
        private String cardType="dfdfdfdfd";
    }
}
