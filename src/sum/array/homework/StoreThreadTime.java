package sum.array.homework;

public class StoreThreadTime{
	private int numberThread;
	private int timeThread;
	
	public StoreThreadTime(int numberThread, int timeThread) {
		super();
		this.numberThread = numberThread;
		this.timeThread = timeThread;
	}

	public int getNumberThread() {
		return numberThread;
	}

	public int getTimeThread() {
		return timeThread;
	}

	@Override
	public String toString() {
		return "StoreThreadTime [numberThread=" + numberThread + ", timeThread=" + timeThread + "]";
	}	
}
