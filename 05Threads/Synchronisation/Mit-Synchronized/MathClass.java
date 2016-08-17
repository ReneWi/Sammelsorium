package synchronizedPack;

public class MathClass {
	private int x;
	private int y;
	public synchronized int workBitch(int u, int v){
		x = u;
		y = v;
		return x + y;
	}
}
