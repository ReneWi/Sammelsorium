package synchronizedPack;

import java.util.concurrent.locks.Lock;

public class RunnableThread implements Runnable{
	private int x;
	private int y;
	private MathClass mc;
	private Lock lock;
	public RunnableThread(int x , int y, MathClass mc,Lock lock){
		this.x = x; 
		this.y = y;
		this.mc = mc;
		this.lock = lock;
	}
	@Override
	public void run() {
		lock.lock();
			System.out.println(mc.workBitch(x, y));
		lock.unlock();
	}

}
