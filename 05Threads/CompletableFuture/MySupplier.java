package completableFuture;

import java.util.function.Supplier;

public class MySupplier implements Supplier<Long> {
	int x,y;
	public MySupplier(int x, int y){
		this.x = x;
		this.y = y;
	}
	private Long doTheMaths(){
		return (long) Math.pow(x, y);
	}
	@Override
	public Long get() {
		return doTheMaths();
	}

}
