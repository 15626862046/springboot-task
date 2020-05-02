package com.jun;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class TaskApplicationTests {

    @Autowired
    JavaMailSenderImpl mailSender;
    @Test
    void contextLoads() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("自己人");//设置邮件标题
        message.setText("别开枪");
        message.setTo("513469659@qq.com");
        message.setFrom("731177205@qq.com");
        mailSender.send(message);
    }

}
