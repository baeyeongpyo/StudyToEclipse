package Test_StaticThread;

public class MultiThreading {

	public static Thread thread = new Thread(()->{
		while(true) {
			try {
				Thread.sleep(500);
				System.out.println("�۾����� ������");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	});
	
}
