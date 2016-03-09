package sum.array.homework;

public class SingleThreadSum implements Runnable{
	private int begin;
	private int end;
	private int[] array;
	private Thread thr;
	long[] sumPartArray;
	int number;

	public SingleThreadSum(int[] array, int begin, int end, long[] sumPartArray, int number) {
		super();
		this.begin = begin;
		this.end = end;
		this.array = array;
		this.sumPartArray = sumPartArray;
		this.number = number;
		thr = new Thread(this);
		thr.start();
	}

	@Override
	public void run() {
		for(int i = begin; i < end; i++){
			sumPartArray[number] += array[i];
		}
	}

	public Thread getThr() {
		return thr;
	}	
}
