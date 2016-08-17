package streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable {
	@Override
	public void run() {
		try(ServerSocket server = new ServerSocket(3141)){
			server.setSoTimeout(2000);
			while(true){
				try(Socket client = server.accept();
						InputStream in = client.getInputStream();
						OutputStream out = client.getOutputStream()){
					int x = in.read();
					int y = in.read();
					int result = x+ y;
					out.write(result);
					out.flush();
					
				}
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
