package cn.ityege.rmi.twoway;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl extends UnicastRemoteObject implements ClientInterface {
    protected ClientImpl() throws RemoteException {
        super();
    }

    @Override
    public void serverCallbackMethod(String message) throws RemoteException {
        System.out.println("客户端接收到来自客户端的消息: " + message);
    }
}