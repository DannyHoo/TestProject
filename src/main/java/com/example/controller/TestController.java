package com.example.controller;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

/**
 * @date 2020/2/10上午10:46
 */
@RestController
@Slf4j
public class TestController {

    @RequestMapping(value = "/test/copy")
    public String login() {
        return "copy/copy";
    }

    @RequestMapping("/test/get/tkl")
    public JSONObject get(HttpServletRequest request, HttpServletResponse response) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("tkl", "oF8JKE7oEP");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET");
        //response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        /*response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with");*/
        return jsonObject;
    }

    @RequestMapping("/open/get/test/{id}")
    public JSONObject getTest(@PathVariable("id") Long id, @RequestParam("type") String type) {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", id);
        jsonObject.put("type", type);
        return jsonObject;
    }

    @RequestMapping("/open/post/test")
    public JSONObject postTest(@RequestBody JSONObject request) {
        return request;
    }

    @RequestMapping("/open/post")
    public JSONObject post(@RequestBody JSONObject request) {
        return request;
    }

    @PostMapping ("/xml/to/json/1")
    public JSONObject xmlToJson1(@RequestBody JSONObject body,HttpServletRequest request) {
        log.info("body {}",body);
        return body;
    }

    /**
     * request添加header
     * http://www.voidcn.com/article/p-cbtpreim-oo.html
     */
    static class MutableHttpServletRequest extends HttpServletRequestWrapper {
        // holds custom header and value mapping
        private final Map<String, String> customHeaders;

        public MutableHttpServletRequest(HttpServletRequest request) {
            super(request);
            this.customHeaders = new HashMap<String, String>();
        }

        public void putHeader(String name, String value) {
            this.customHeaders.put(name, value);
        }

        @Override
        public String getHeader(String name) {
            // check the custom headers first
            String headerValue = customHeaders.get(name);

            if (headerValue != null) {
                return headerValue;
            }
            // else return from into the original wrapped object
            return ((HttpServletRequest) getRequest()).getHeader(name);
        }

        @Override
        public Enumeration<String> getHeaderNames() {
            // create a set of the custom header names
            Set<String> set = new HashSet<String>(customHeaders.keySet());

            // now add the headers from the wrapped request object
            @SuppressWarnings("unchecked")
            Enumeration<String> e = ((HttpServletRequest) getRequest()).getHeaderNames();
            while (e.hasMoreElements()) {
                // add the names of the request headers into the list
                String n = e.nextElement();
                set.add(n);
            }

            // create an enumeration from the set and return
            return Collections.enumeration(set);
        }
    }




}
