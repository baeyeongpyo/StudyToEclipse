package Test_StaticThread;

public class MultiThreading {

	public static Thread thread = new Thread(()->{
		while(true) {
			try {
				Thread.sleep(500);
				System.out.println("작업중인 쓰레드");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
}
