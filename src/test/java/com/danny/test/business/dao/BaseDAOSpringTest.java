package com.danny.test.business.dao;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

/**
 * @author huyuyang@lxfintech.com
 * @Title: BaseDAOSpringTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-01-19 22:56:50
 * Spring提供的JUnit框架扩展：
 * 1. AbstractSpringContextTests：spring中使用spring上下文测试的Junit扩展类，
 *    我们一般不会使用这个类来进行单元测试，它是spring内部设计使用到的类
 * 2. AbstractDependencyInjectionSpringContextTests：这是AbstractSpringContextTests的直接子类，
 *    支持依赖spring上下文的测试类，这个类不支持事务。
 * 3. AbstractTransactionalSpringContextTests：这是 AbstractDependencyInjectionSpringContextTests的直接子类，
 *    这个类一般应用在事务相关的测试中，一旦完成每个测试它就会正常地回滚事务，不会真正更新数据库，若要手动设置事务相关操作，
 *    你可以重载onSetUpInTransaction和 onTearDownInTransaction方法，以便手工开始并提交事务，或者调用setComplete()方法。
 *    这个类也可以在没有事务的情况下，使用这个类。
 * 4. AbstractTransactionalDataSourceSpringContextTests：这是 AbstractTransactionalSpringContextTests的直接子类，
 *    它使用了Spring的基于JDBC的 jdbcTemplate工具类，支持数据库级别的事务。
 */

@ContextConfiguration(locations = { "classpath:/spring/applicationContext-jpa.xml" })
public abstract class BaseDAOSpringTest extends AbstractTransactionalJUnit4SpringContextTests {
}
