package Thread_Control;

import java.util.Scanner;

public class Control_Study {

	Scanner scanner = new Scanner(System.in);
	private Thread thread1, thread2;

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
			thread1 = new Thread(runnable1);
			thread1.setPriority(5);
			thread1.start();
			break;
		case "stop":
			thread1.interrupt();
			break;
		case "join":
			thread2 = new Thread(runnable2);
			thread2.setPriority(8);
			thread2.start();
		}
	}

}
