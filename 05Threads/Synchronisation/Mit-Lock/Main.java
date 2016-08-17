package synchronizedPack;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
	public static void main(String[] args) {
		Lock lock = new ReentrantLock();
		MathClass mc = new MathClass();
		RunnableThread rt1 = new RunnableThread(2, 2, mc, lock);
		RunnableThread rt2 = new RunnableThread(1, 3, mc, lock);
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2);
		t1.start();
		t2.start();
	}
}
