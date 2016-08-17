package streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerThreads implements Runnable {

	@Override
	public void run() {
		try(ServerSocket server = new ServerSocket(3141)){
			server.setSoTimeout(4000);
			while(true){
					Socket socket = server.accept();
					new ClientThread(socket).start();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private class ClientThread extends Thread{
		Socket socket;
		public ClientThread(Socket socket){
			this.socket = socket;
		}
		public void run(){
			try(InputStream in = socket.getInputStream();
					OutputStream out = socket.getOutputStream()){
				int x = in.read();
				int y = in.read();
				int result = x+y;
				out.write(result);
				out.flush();
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}

}
