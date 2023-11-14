package cn.ityege.quartz.helloworld;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class MyScheduler {
    public static void main(String[] args) {
        try {
            // 创建调度器
            Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

            // 创建任务
            JobDetail job = JobBuilder.newJob(MyJob.class)
                    .withIdentity("myJob", "group1")
                    .build();

            // 创建触发器
            Trigger trigger = MyTrigger.createTrigger();

            // 将任务和触发器添加到调度器中
            scheduler.scheduleJob(job, trigger);

            // 启动调度器
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}