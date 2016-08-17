package datagramm;

public class Main {

	public static void main(String[] args) {
		// ----------- server mit nur einem client gleichzeitig ----------
		Server server = new Server();
		Thread st = new Thread(server);
		st.start();
		Client client = new Client("ANSWER",5555);
		Thread ct = new Thread(client);
		ct.start();
		try {
			st.join();
			ct.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//----------------server mit mehreren clients-----------------
		ServerThreads sert = new ServerThreads();
		Thread s = new Thread(sert);
		s.start();
		Client cA = new Client("sach!",5555);
		Thread tA = new Thread(cA);
		Client cB = new Client("ANSWER",5556);
		Thread tB = new Thread(cB);
		tA.start();
		tB.start();
	}

}
