package sum.array.homework;

public class Main {

	public static void main(String[] args) {
		int arraySize = 5000000;
		int[] array = new int[arraySize];
		Test test = new Test(array);
		test.fillArrayRandomNumber();
		test.calcSumSingleThread();
		test.calcSumMultiThread();
		//test.findThreadWithMinTime();		
	}

}
