package callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Main {

	public static void main(String[] args) {
		ExecutorService executor = Executors.newCachedThreadPool();
		Future<Long> solution;
		solution = executor.submit(new CallableThread(2,10));
		executor.shutdown();  	//  vergangene anfragen werden bis zum ende abgearbeitet neue anfragen werden nicht angenommen
		try {
			System.out.println(solution.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
