package Thread_Callable;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Callable_Study {
	public String Study() {
		ExecutorService exector = Executors.newFixedThreadPool(2);
		ArrayList<Future<String>> arraylist = new ArrayList<>();
		
		
		arraylist.add(exector.submit(new Callable_one("test1")));
		arraylist.add(exector.submit(new Callable_one("test2")));
		arraylist.add(exector.submit(new Callable_one("test3")));
		
		StringBuffer buffer = new StringBuffer();
		for ( Future<String> future : arraylist) {
			try {
				buffer.append(future.get() + " && " + future.isDone() + "\n");
			} catch (Exception e) {
				e.printStackTrace();
			} 
		}
		
		return buffer.toString();
	}
	
	private class Callable_one implements Callable<String>{
		
		String txt;

		private Callable_one(String txt) {
			this.txt = txt;
		}

		@Override
		public String call() throws Exception {
				System.out.println(String.format("Thread  == >> %s", txt));
			return String.format("반환된 값  == >> %s", txt);
		}
	}
}
