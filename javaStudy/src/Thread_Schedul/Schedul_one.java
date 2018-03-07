package Thread_Schedul;


public class Schedul_one implements Runnable{
	
	int count = 0;
	long time = (long) System.currentTimeMillis();
	
	public Schedul_one() {
		count++;
	}

	@Override
	public void run() {
		System.out.println("Callable Class" + count + "번째 호출" + (time - System.currentTimeMillis()));
	}
	
	
}
