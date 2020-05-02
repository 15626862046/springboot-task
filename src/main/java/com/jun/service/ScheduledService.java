package com.jun.service;
/**
 * 定时任务
 */

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    //定时任务注解+cron表达式
    //秒 分 时 日 月 星期
    @Scheduled(cron = "0/30 * * * * ?")
    public void hello(){
        System.out.println("hello,执行");
    }
}
