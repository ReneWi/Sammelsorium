package runnable;

public class Main {
public static void main(String[] args) {
	RunnableThread t = new RunnableThread("Your ad could be here!");
	Thread thread = new Thread(t);
	thread.start();
	try {
		thread.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("ich mach auch was ");
}
}
