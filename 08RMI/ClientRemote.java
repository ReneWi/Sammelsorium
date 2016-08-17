package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface  ClientRemote extends Remote  {

	public void saySomething() throws RemoteException;
}
