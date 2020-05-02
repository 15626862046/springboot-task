package com.jun.controller;
/**
 * 异步任务+邮件任务控制器
 */

import com.jun.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
public class AsyncController {
    @Autowired
    AsyncService asyncService;
    @RequestMapping("hello")
    public String hello(){
        asyncService.hello();
        return "hello";
    }

    @RequestMapping("mail")
    public String mail() throws MessagingException {
        asyncService.mail();
        return "发送成功";
    }

}
