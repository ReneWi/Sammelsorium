package synchronizedPack;

public class Main {
	public static void main(String[] args) {
		MathClass mc = new MathClass();
		RunnableThread rt1 = new RunnableThread(2, 2, mc);
		RunnableThread rt2 = new RunnableThread(1, 3, mc);
		Thread t1 = new Thread(rt1);
		Thread t2 = new Thread(rt2);
		t1.start();
		t2.start();
	}
}
