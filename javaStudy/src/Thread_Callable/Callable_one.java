package Thread_Callable;

import java.util.concurrent.Callable;

public class Callable_one implements Callable<String>{
	
	String txt;

	public Callable_one(String txt) {
		this.txt = txt;
	}

	@Override
	public String call() throws Exception {
			System.out.println(String.format("Thread  == >> %s", txt));
		return String.format("반환된 작업  == >> %s", txt);
	}

}
