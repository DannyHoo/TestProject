package com.danny.test.business.dao.integration;

import com.danny.test.business.dao.BaseDAOSpringTest;
import com.danny.test.business.dao.UserDAO;
import com.danny.test.business.data.UserDO;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import java.util.Date;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAOTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-01-19 22:54:55
 */
public class UserDAOTest extends BaseDAOSpringTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    @Rollback(false)
    public void saveUserTest() {
        UserDO userDO=userDAO.save(getUserDO());
        Assert.assertNotNull(userDO);
    }

    @Test
    public void findUserTest() {
        UserDO userDOSaved=userDAO.save(getUserDO());
        UserDO userDOFound=userDAO.findOne(userDOSaved.getId());
        Assert.assertNotNull(userDOFound);
    }

    public UserDO getUserDO() {
        return new UserDO()
                .setUserName("Danny")
                .setPassword("123456")
                .setRealName("胡玉洋")
                .setAge(25)
                .setBirthday(new Date());
    }
}
