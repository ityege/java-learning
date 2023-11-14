package cn.ityege.quartz.helloworld;


import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;


public class MyTrigger {
    public static Trigger createTrigger() {
        return TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
                        .withIntervalInSeconds(5) // 每隔5秒执行一次
                        .repeatForever()) // 无限重复
                .build();
    }
}