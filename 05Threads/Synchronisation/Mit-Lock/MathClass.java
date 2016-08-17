package synchronizedPack;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MathClass {
	private int x;
	private int y;
	public int workBitch(int u, int v){
		x = u;
		y = v;
		return x + y;
	}
}
