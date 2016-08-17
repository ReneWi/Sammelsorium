package runnable;

public class Main {
public static void main(String[] args) {
	RunnableThread t = new RunnableThread("Your ad could be here!");
	Thread thread = new Thread(t);
	thread.start();
	System.out.println("Im not waiting for that mofo!");
	try {
		thread.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	System.out.println("I am!");
}
}
