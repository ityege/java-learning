package cn.ityege.guava.concurrent;

import com.google.common.util.concurrent.AbstractIdleService;
import com.google.common.util.concurrent.Service;
import com.google.common.util.concurrent.ServiceManager;

import java.util.ArrayList;
import java.util.List;

public class ServiceManagerTest {
    public static void main(String[] args) {
        // 创建一些示例服务
        Service service1 = new ExampleService("Service 1");
        Service service2 = new ExampleService("Service 2");
        Service service3 = new ExampleService("Service 3");

        List<Service> list = new ArrayList<Service>();
        list.add(service1);
        list.add(service2);
        list.add(service3);
        // 创建 ServiceManager，并将示例服务添加到其中
        ServiceManager serviceManager = new ServiceManager(list);

        // 启动服务
        serviceManager.startAsync().awaitHealthy();

        // 运行一些操作，示例中使用线程休眠代替
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 停止服务
        serviceManager.stopAsync().awaitStopped();
    }

    // 示例服务类
    static class ExampleService extends AbstractIdleService {
        private final String serviceName;

        ExampleService(String serviceName) {
            this.serviceName = serviceName;
        }

        @Override
        protected void startUp() throws Exception {
            System.out.println("Starting service: " + serviceName);
        }

        @Override
        protected void shutDown() throws Exception {
            System.out.println("Stopping service: " + serviceName);
        }
    }
}