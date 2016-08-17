package streams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Client implements Runnable{
	int x, y;
	public Client(int x, int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public void run() {
		try(Socket con = new Socket("localhost", 3141);
			InputStream in = con.getInputStream();
			OutputStream out = con.getOutputStream()){
			out.write(x);
			out.write(y);
			out.flush();
			
			int result = in.read();
			System.out.println(result);
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
