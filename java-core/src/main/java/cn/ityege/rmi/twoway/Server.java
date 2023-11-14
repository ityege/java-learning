package cn.ityege.rmi.twoway;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class Server {
    public static void main(String[] args) {
        try {
            // 创建远程对象
            RemoteImpl remoteObject = new RemoteImpl();

            // 注册远程对象
            LocateRegistry.createRegistry(1099);
            Naming.rebind("rmi://localhost/RemoteObject", remoteObject);

            System.out.println("服务端启动成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}