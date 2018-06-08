package com.danny.test.business.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyuyang@lxfintech.com
 * @Title: DemoController
 * @Copyright: Copyright (c) 2016
 * @Description:
 * @Company: lxjr.com
 * @Created on 2017-01-17 23:21:22
 */
@Controller
public class UserController {

    @RequestMapping("/index")
    public String index() {
        return "index";
    }
}
