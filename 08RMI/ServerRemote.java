package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ServerRemote extends Remote {

	public int add(int x, int y) throws RemoteException; 
	public int multi(int x , int y)throws RemoteException;
	public int subtract(int x , int y )throws RemoteException;
	public double devide (double x , double y) throws RemoteException;
}
