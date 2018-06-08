package com.danny.test.business.service;

import com.danny.test.business.data.UserDO;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserService
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-01-19 23:23:44
 */
public interface UserService {
    public UserDO findUser(Long id);
}
