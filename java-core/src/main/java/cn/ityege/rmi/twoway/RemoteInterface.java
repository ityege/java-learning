package cn.ityege.rmi.twoway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    void clientMethod(String message) throws RemoteException;
    void registerCallback(ClientInterface client) throws RemoteException;
}