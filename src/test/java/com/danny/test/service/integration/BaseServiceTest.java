package com.danny.test.service.integration;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseServiceTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-15 13:50:27
 */
@ContextConfiguration(locations = { "classpath:/spring/applicationContext-jpa.xml","classpath:/spring/applicationContext-service.xml" ,"classpath:/spring/account-redis-sentinel-bean.xml"})
public class BaseServiceTest extends AbstractJUnit4SpringContextTests {
}
