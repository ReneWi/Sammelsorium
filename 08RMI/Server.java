package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

import beispiel1.NullSecurityManager;

public class Server extends UnicastRemoteObject implements ServerRemote {

	protected Server() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws RemoteException, MalformedURLException, AlreadyBoundException {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new rmi.NullSecurityManager());
		}
		LocateRegistry.createRegistry(1099);
		Remote remote = new Server();
		Naming.bind("server", remote);
		System.out.println("Server started");
	}
	@Override
	public int add(int x, int y) throws RemoteException {
		
		return x+y;
	}

	@Override
	public int multi(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x*y;
	}

	@Override
	public int subtract(int x, int y) throws RemoteException {
		// TODO Auto-generated method stub
		return x-y;
	}

	@Override
	public double devide(double x, double y) throws RemoteException {
		if(y != 0){
			return x/y;
		}
		return Double.POSITIVE_INFINITY;
	}

}
