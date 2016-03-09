package sum.array.homework;

public class MultiThreadSum {
	public static long calcSum(int[] array, int threadNumber) {
		if(threadNumber <= 0){
			throw new IllegalArgumentException();
		}
		long sumElements = 0;
		long[] sumPartArray = new long[threadNumber];
		SingleThreadSum[] singleThreads = new SingleThreadSum[threadNumber];
		int size = array.length / threadNumber;
		for (int i = 0; i < singleThreads.length; i++) {
			int begin = size * i;
			int end = size * (i + 1);
			if ((array.length - size) < size) {
				end = array.length;
			}
			singleThreads[i] = new SingleThreadSum(array, begin, end, sumPartArray, i);
		}
		for (int i = 0; i < singleThreads.length; i++) {
			try {
				singleThreads[i].getThr().join();
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		}
		for (long i : sumPartArray) {
			sumElements += i;
		}
		return sumElements;
	}
}