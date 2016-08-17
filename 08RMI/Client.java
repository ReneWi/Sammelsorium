package rmi;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Client extends UnicastRemoteObject implements ClientRemote {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Registry registry;
	private ServerRemote remote; 
	protected Client() throws RemoteException, MalformedURLException, AlreadyBoundException, NotBoundException {
		this.registry = LocateRegistry.getRegistry(1099);
		Naming.bind("paul", this);
		this.remote = (ServerRemote) registry.lookup("server");
		int x = remote.add(1, 2);
		System.out.println(x);
		x = remote.subtract(2, 1);
		System.out.println(x);
		x = remote.multi(2, 1);
		System.out.println(x);
		double y = remote.devide(1, 0);
		System.out.println(y);
		y = remote.devide(1,2);
		System.out.println(y);
	}

	@Override
	public void saySomething() throws RemoteException {
		System.out.println("something");
	}

}
