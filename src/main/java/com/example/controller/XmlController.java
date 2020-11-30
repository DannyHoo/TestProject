package com.example.controller;

import com.alibaba.fastjson.JSON;
import com.example.model.xmlbean.SynchronizeRequest;
import com.example.model.xmlbean.SynchronizeResponse;
import com.example.model.xmlbean.User;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

/**
 * @author danny
 * @date 2020/6/18上午10:11
 * Spring Boot中如何扩展XML请求和响应的支持 https://segmentfault.com/a/1190000016532820
 * https://blog.csdn.net/baiofchao/article/details/102524933
 */
@Slf4j
@RestController
public class XmlController {

    public static final XmlMapper xmlMapper = new XmlMapper();

    static {
        xmlMapper.enable(ToXmlGenerator.Feature.WRITE_XML_DECLARATION);
    }

    @GetMapping(value = "/xml/user/get",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User userGet() {
        User user=new User();
        user.setName("danny ");
        user.setAge(100);
        return user;
    }

    @PostMapping(value = "/xml/user/post1",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public User userPost1(@RequestBody String userStr) throws IOException {
        User user=xmlMapper.readValue(userStr, User.class);
        user.setName("danny ");
        user.setAge(100);
        return user;
    }

    @PostMapping(value = "/xml/user/post")
    @ResponseBody
    public User userPost(@RequestBody User userStr) throws IOException {
        //User user=xmlMapper.readValue(userStr, User.class);
        User user=new User();
        user.setName("danny ");
        user.setAge(100);
        return user;
    }

    @PostMapping(value = "/xml/synchronize",
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public SynchronizeResponse synchronize(@RequestBody SynchronizeRequest synchronizeRequest) {
        System.out.println(JSON.toJSONString(synchronizeRequest));
        SynchronizeResponse synchronizeResponse=new SynchronizeResponse()
                .setFlag("success")
                .setCode("200")
                .setMessage("success")
                .setItemId("OIOEIwe209e2323423");
        return synchronizeResponse;
    }

}
