package datagramm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Client implements Runnable {

	private String command;
	private int port;
	public Client (String command, int port ){
		this.command = command;
		this.port = port;
	}
	@Override
	public void run() {
		InetAddress ia = null;	
		try {
			ia = InetAddress.getByName("localhost");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try(DatagramSocket dSocket = new DatagramSocket(port)){
			byte[] buffer = command.getBytes();
			DatagramPacket packet = new DatagramPacket(buffer, buffer.length, ia, 3431);
			dSocket.send(packet);
			byte[] answer = new byte[1024];
			packet = new DatagramPacket(answer, answer.length);
			dSocket.receive(packet);
			System.out.println(new String(packet.getData(),0,packet.getLength()));
		} catch ( IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
