package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author danny
 * @date 2020/4/17下午5:28
 */
@Controller
@RequestMapping("/facebook")
public class FacebookController {

    @RequestMapping(value = "/{page}")
    public String login(@PathVariable("page") String page) {
        return "page/facebook/"+page;
    }
}
