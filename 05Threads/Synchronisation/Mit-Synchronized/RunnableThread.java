package synchronizedPack;

public class RunnableThread implements Runnable{
	private int x;
	private int y;
	private MathClass mc;
	public RunnableThread(int x , int y, MathClass mc){
		this.x = x; 
		this.y = y;
		this.mc = mc;
	}
	@Override
	public void run() {
		synchronized(mc){
			System.out.println(mc.workBitch(x, y));
		}
	
	}

}
