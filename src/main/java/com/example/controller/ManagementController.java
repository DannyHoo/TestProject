package com.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author huyuyang
 * @email yuyang.hu@opay-inc.com
 * @date 2019/11/2下午4:25
 */
@Controller
@RequestMapping("/")
public class ManagementController {
    private static final Logger logger = LoggerFactory.getLogger(ManagementController.class);

    @RequestMapping(value = "/page/{page}")
    public String page(@PathVariable("page") String page) {
        return "page/"+page;
    }


    @RequestMapping(value = "/management/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
