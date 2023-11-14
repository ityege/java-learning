package cn.ityege.rmi.twoway;

import java.rmi.Naming;
import java.rmi.RemoteException;

public class Client {
    public static void main(String[] args) {
        try {
            // 查找远程对象
            RemoteInterface remoteObject = (RemoteInterface) Naming.lookup("rmi://localhost/RemoteObject");

            // 创建客户端回调对象
            ClientInterface clientCallback = new ClientImpl();

            // 注册客户端回调对象到远程对象
            //客户端拿到远程的接口先将自己注册上
            remoteObject.registerCallback(clientCallback);

            // 调用远程方法
            remoteObject.clientMethod("Hello from client! 给远程的服务器发送消息");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}