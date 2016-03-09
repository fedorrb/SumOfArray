package sum.array.homework;

import java.util.Comparator;

public class SortThreadByTime implements Comparator<StoreThreadTime>{

	@Override
	public int compare(StoreThreadTime o1, StoreThreadTime o2) {
		if(o1 == null || o2 == null)
			return -1;
		if(o1.getTimeThread() < o2.getTimeThread())
			return -1;
		else if(o1.getTimeThread() > o2.getTimeThread())			
			return 1;
		else {
			if(o1.getNumberThread() < o2.getNumberThread())
				return -1;
			else if(o1.getNumberThread() > o2.getNumberThread())
				return 1;
		}
		return 0;
	}
	
}
