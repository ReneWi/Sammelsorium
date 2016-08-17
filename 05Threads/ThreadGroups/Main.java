package treadGroups;

public class Main {
	public static void main(String[] args) {
		ThreadGroup group = new ThreadGroup("Threadson Five");
		RunnableThread rt1 = new RunnableThread("Hee hee ");
		RunnableThread rt2 = new RunnableThread("Shamona!");
		Thread t1 = new Thread(group, rt1);
		Thread t2 = new Thread(group, rt2);
		t1.start();
		System.out.println("t1 : " + t1.getThreadGroup());
		t2.start();
		System.out.println("This Thread: " + Thread.currentThread().getThreadGroup());
		System.out.println("t1 : " + t1.getThreadGroup());
		while(group.activeCount()>0){
			System.out.println("blub");
		}
	}
}
