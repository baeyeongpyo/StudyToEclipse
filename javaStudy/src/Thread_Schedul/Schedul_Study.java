package Thread_Schedul;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import Test_StaticThread.MultiThreading;


public class Schedul_Study {
	
	

	public String Study() {
//		MultiThreading.thread.start();
		ExecutorService executor = Executors.newSingleThreadExecutor();
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);

		executor.submit(new Schedul_one());
		ses.scheduleAtFixedRate(new Schedul_one(), 1L, 5L, TimeUnit.SECONDS);
		
		return null;
		
	}

}
