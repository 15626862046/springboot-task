package com.jun.service;
/**
 * 异步任务+邮件任务业务逻辑
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class AsyncService {

    @Autowired
    JavaMailSenderImpl mailSender;

    @Async //方法异步执行。spring自动给方法开线程执行
    public void hello(){
        try{
            Thread.sleep(3000);
            System.out.println("异步");
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * 邮件任务加异步任务
     */
    @Async
    public void mail() throws MessagingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);//如果想要带附件 加上true
        //正文
        helper.setSubject("队长");
        helper.setText("<p style='color:red'>别开枪，是我</p>",true);
        //附件
        helper.addAttachment("1.jpg",new File("C:\\Users\\hee\\Desktop\\1.jpg"));

        helper.setTo("513469659@qq.com");
        helper.setFrom("731177205@qq.com");

        mailSender.send(mimeMessage);
    }
}
