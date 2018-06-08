package com.danny.test.business.service.integration;

import com.danny.test.business.data.UserDO;
import com.danny.test.business.service.UserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImplTest
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-02-15 13:50:04
 */
public class UserServiceImplTest extends BaseServiceTest {
    @Autowired
    private UserService userService;

    @Test
    public void testFindUser(){
        UserService userService=this.userService;
        UserDO userDO=userService.findUser(1L);
        System.out.println(userDO);
    }

}
