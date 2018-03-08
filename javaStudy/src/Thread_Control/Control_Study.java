package Thread_Control;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Control_Study {

	Scanner scanner = new Scanner(System.in);
	private Thread thread1, thread2;
	ScheduledExecutorService executor;

	public void Study() {
		while (true) {
			System.out.print("Command >>");
			String input_String = scanner.nextLine();
			Thread_Control_Method(input_String);
		}
	}

	Runnable runnable1 = () -> {
		boolean loop = true;
		try {
			while (loop) {
				System.out.println("Threading!");
				Thread.sleep(500);
			}
		} catch (InterruptedException e) {
			loop = false;
		}
	};

	Runnable runnable2 = () -> {
		try {
			Thread.sleep(2000); 
			System.out.println("join to Thread!!");
		} catch (InterruptedException e) {
			System.out.println("err");
		}

	};

	private void Thread_Control_Method(String control_command) {
		
		switch (control_command) {
		case "start":
			executor = Executors.newScheduledThreadPool(2);
			executor.schedule(runnable1, 2L, TimeUnit.SECONDS);
			System.out.println(executor.isTerminated());
			break;
		case "stop":
			executor.shutdownNow();
			System.out.println(executor.isTerminated());
			break;
		case "join":
			executor.shutdownNow();
			executor = Executors.newSingleThreadScheduledExecutor();
			executor.execute(runnable2);
			executor.schedule(runnable1, 2L, TimeUnit.SECONDS);
			System.out.println(executor.isTerminated());
			/*thread2 = new Thread(runnable2);
			thread2.setPriority(8);
			thread2.start();*/
		}
	}

}
