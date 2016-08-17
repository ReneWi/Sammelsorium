package runnable;

public class RunnableThread implements Runnable{
	private String s;
	public RunnableThread(String s){
		this.s = s;
	}
	@Override
	public void run() {
		for(int i = 0; i<s.length();i++){
			System.out.println(s.charAt(i));
		}
	}

}
