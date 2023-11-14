package cn.ityege.guava.concurrent;

import com.google.common.util.concurrent.AbstractExecutionThreadService;

public class AbstractExecutionThreadServiceTest {
    public static void main(String[] args) throws InterruptedException {
        MyExecutionThreadService myExecutionThreadService = new MyExecutionThreadService();
        myExecutionThreadService.startAsync();  // 启动服务
        // 运行一些操作，示例中使用线程休眠代替
        Thread.sleep(5000);
        myExecutionThreadService.stopAsync();   // 停止服务

    }

    static class MyExecutionThreadService extends AbstractExecutionThreadService {

        @Override
        protected void run() throws Exception {
            while (isRunning()) {
                // 在此处执行服务的主要逻辑
                System.out.println("Service is running...");
                Thread.sleep(1000);
            }

        }

        @Override
        protected void startUp() throws Exception {
            // 在服务启动之前执行的逻辑
            System.out.println("Service is starting...");
        }

        @Override
        protected void shutDown() throws Exception {
            // 在服务停止之前执行的逻辑
            System.out.println("Service is stopping...");
        }

        @Override
        protected void triggerShutdown() {
            // 当服务需要被关闭时，调用这个方法来触发关闭操作
            System.out.println("Triggering shutdown of the service...");
        }
    }
}
