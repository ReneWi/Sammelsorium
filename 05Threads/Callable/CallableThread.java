package callable;

import java.util.concurrent.Callable;

public class CallableThread implements Callable<Long> {
	int x, y;
	public CallableThread(int x , int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public Long call() throws Exception {
		long result;
		result = (long) Math.pow(x, y);
		return result;
	}

}
