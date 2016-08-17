package datagramm;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class ServerThreads implements Runnable {

	@Override
	public void run() {
		try {
			DatagramSocket socket = new DatagramSocket(3431);
			socket.setSoTimeout(3000);
			while(true){
				DatagramPacket packet = new DatagramPacket(new byte[6], 6);
				socket.receive(packet);
				new ClientThread(packet, socket).start();
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
 class ClientThread extends Thread{
	
	private DatagramPacket packet;
	private DatagramSocket socket;
	public ClientThread(DatagramPacket packet, DatagramSocket socket){
	this.packet = packet;
	this.socket = socket;
	}
	 public void run(){
		InetAddress address = packet.getAddress();
		int port = packet.getPort();
		int len = packet.getLength();
		byte[] data = packet.getData();
		System.out.printf("Anfrage ist von %s vom Port %d mit der länge %d:%n%s%n",
						address, port, len, new String(data,0,len));
				String da = new String(packet.getData());
				try(Scanner sc = new Scanner(da).useDelimiter(":")){
					String keyword = sc.next();
					if (keyword.equals("ANSWER")){
						byte[] answer = new String("42!").getBytes();
						packet = new DatagramPacket(answer, answer.length, address, port);
						socket.send(packet);
					}else{
						byte[] answer = new String("what ?").getBytes();
						packet = new DatagramPacket(answer,answer.length,address,port);
						socket.send(packet);
					}
				}catch(IOException e){
					e.printStackTrace();
				}
	}
}
