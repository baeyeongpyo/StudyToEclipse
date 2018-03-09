package Thread_Control;

import java.util.Scanner;

public class Control_Study2 {
	
	public void Study() {

		ThreadClass thread = new ThreadClass(new ThreadCotror());
		thread.start();
		
		while(true) {
			thread.SetInterruptMsg(new Scanner(System.in).nextLine());
		}
		
	}
	
	class ThreadClass extends Thread{
		ThreadCotror runnable;
		ThreadClass(ThreadCotror runnable){
			super(runnable);
			this.runnable = runnable;
		}
		
		void SetInterruptMsg(String string) {
			runnable.setinterrupt(string);
			this.interrupt();
		}
		
	}
	
	
	class ThreadCotror implements Runnable{
		
		String interrupterString;
		void setinterrupt(String string) {
			interrupterString = string;
		}

		@Override
		public void run() {

			while(true) {
				try {
					Thread.sleep(500);
					System.out.println("쓰레드 진행중");
				} catch (InterruptedException e) {
					System.out.println("쓰레드 이벤트");
					System.out.println(interrupterString);
				}
			}
			
		}
		
	}
}
