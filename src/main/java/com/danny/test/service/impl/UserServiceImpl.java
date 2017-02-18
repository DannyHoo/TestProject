package com.danny.test.service.impl;

import com.danny.test.dao.UserDAO;
import com.danny.test.model.data.UserDO;
import com.danny.test.service.UserService;
import com.ucf.framework.lock.LockHolder;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.locks.Lock;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserServiceImpl
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-01-19 23:23:28
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDAO userDAO;

    private static String bizCode = "1000";
    private static String lockKey = "1234567890";
    private static long timeoutMsecs = 3000;
    private static long expireMsecs = 5000;

    public UserDO findUser(Long id) {
        Lock lock= LockHolder.createLock(bizCode, lockKey,timeoutMsecs, expireMsecs);
        UserDO userDOFound=userDAO.findOne(id);
        return userDOFound;
    }
}
