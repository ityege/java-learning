package cn.ityege.rmi.twoway;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientInterface extends Remote {
    void serverCallbackMethod(String message) throws RemoteException;
}