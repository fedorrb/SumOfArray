package sum.array.homework;

import java.util.ArrayList;
import java.util.Random;

public class Test {
	private int[] array;

	public Test(int[] array) {
		super();
		this.array = array;
	}

	public void fillArrayRandomNumber(){
		Random rn = new Random();
		for (int i = 0; i < array.length; i++) {
			array[i] = rn.nextInt(10000);
		}		
	}
	
	public void calcSumSingleThread() {
		long tstart = System.currentTimeMillis();
		long sumArray = 0;
		for (int i : array) {
			sumArray += i;
		}
		long tend = System.currentTimeMillis();
		System.out.println("Sum elements of array = " + sumArray);
		System.out.println((tend - tstart) + "  ms" + "- single thread sum.");
	}
	
	public void calcSumMultiThread(){
		long tstart = System.currentTimeMillis();
		long sumArray = MultiThreadSum.calcSum(array, 8);
		long tend = System.currentTimeMillis();
		System.out.println("Sum elements of array = " + sumArray);
		System.out .println((tend - tstart) + "  ms" + "- multi thread sum.");		
	}
	
	public void findThreadWithMinTime(){
		ArrayList<StoreThreadTime> timeCalc = new ArrayList<StoreThreadTime>();
		int maxThreads = 200;
		int calcTimes = 10;
		int averageTime = 0;
		long tstart = 0;
		long tend = 0;
		for (int i = 1; i < maxThreads; i++) {
			averageTime = 0;
			for (int j = 0; j < calcTimes; j++) {
				tstart = System.currentTimeMillis();
				MultiThreadSum.calcSum(array, i);
				tend = System.currentTimeMillis();
				averageTime += (tend - tstart);
			}
			timeCalc.add(new StoreThreadTime(i, (int)(averageTime / 10)));
		}
		timeCalc.sort(new SortThreadByTime());
//		for(StoreThreadTime stt: timeCalc){
//			System.out.println(stt);
//		}
		int minTime = timeCalc.get(0).getTimeThread();
		for(int i = 0; minTime == timeCalc.get(i).getTimeThread(); i++){
			System.out.println(timeCalc.get(i));
		}
	}
}
