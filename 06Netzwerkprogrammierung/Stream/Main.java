package streams;

public class Main {

	public static void main(String[] args) {
		//---------- Server mit nur einem Client gleichzeitig----------------
		Server server = new Server();
		Thread serverThread = new Thread(server);
		Client client = new Client(2,2);
		Thread clientThread =new Thread(client);
		serverThread.start();
		clientThread.start();
		try {
			clientThread.join();
			serverThread.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// -------------- server mit mehreren clients -----------------------
		ServerThreads serverThreads = new ServerThreads();
		Thread sThread = new Thread(serverThreads);
		sThread.start();
		Client clientA = new Client(2,2);
		Client clientB = new Client(1,3);
		Thread cA = new Thread(clientA);
		Thread cB = new Thread(clientB);
		
		cA.start();
		cB.start();
		
	}

}
