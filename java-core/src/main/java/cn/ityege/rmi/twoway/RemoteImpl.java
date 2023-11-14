package cn.ityege.rmi.twoway;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class RemoteImpl extends UnicastRemoteObject implements RemoteInterface {
    private List<ClientInterface> clientList;

    protected RemoteImpl() throws RemoteException {
        super();
        clientList = new ArrayList<>();
    }

    @Override
    public void clientMethod(String message) throws RemoteException {
        //服务器端收到客户端的消息
        System.out.println("服务器接受到消息: " + message);

        // 遍历每一个客户端，给每一个客户端发消息
        for (ClientInterface client : clientList) {
            client.serverCallbackMethod("Hello from server!");
        }
    }

    @Override
    public void registerCallback(ClientInterface client) throws RemoteException {
        System.out.println("客户端注册: " + client);
        clientList.add(client);
    }
}