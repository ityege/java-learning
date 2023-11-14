package cn.ityege.guava.concurrent;

import com.google.common.util.concurrent.AbstractScheduledService;
import com.google.common.util.concurrent.ServiceManager;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AbstractScheduledServiceTest {
    public static void main(String[] args) throws InterruptedException {

        MyScheduledService myScheduledService = new MyScheduledService();
        // 启动服务
        myScheduledService.startAsync();
        // 运行一些操作，示例中使用线程休眠代替
        Thread.sleep(10000);
        // 停止服务
        myScheduledService.stopAsync();

    }

    static class MyScheduledService extends AbstractScheduledService {
        @Override
        protected void runOneIteration() throws Exception {
            // 定期执行的具体逻辑
            System.out.println("Executing scheduled task...");
        }

        @Override
        protected Scheduler scheduler() {
            // 返回一个Scheduler对象，用于配置定时任务的执行频率和延迟
            return Scheduler.newFixedRateSchedule(0, 1, TimeUnit.SECONDS);
        }
    }
}
