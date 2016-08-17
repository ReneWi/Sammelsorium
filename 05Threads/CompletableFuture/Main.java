package completableFuture;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {

	public static void main(String[] args) {
		CompletableFuture<Long> solution;
		MySupplier ms = new MySupplier(2, 20);
		solution = 	CompletableFuture.supplyAsync(ms);
		try {
			System.out.println(solution.get());
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// ------------ multi-threading--------------
		ArrayList<CompletableFuture<Long>> solutions = new ArrayList<>();
		for(int i = 0;i<3;i++){
			MySupplier ms2 = new MySupplier(2,i);
			solutions.add(CompletableFuture.supplyAsync(ms2));
		}
		solutions.forEach(e->{
			try {
				System.out.println(e.get());
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
	}

}
