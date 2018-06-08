package com.danny.test.business.dao;

import com.danny.test.business.data.UserDO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author huyuyang@lxfintech.com
 * @Title: UserDAO
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-01-19 22:51:56
 */
public interface UserDAO extends PagingAndSortingRepository<UserDO,Long>{

}
