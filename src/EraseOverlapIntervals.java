import java.util.*;

public class EraseOverlapIntervals {
	public int eraseOverlapIntervals(Interval[] intervals) {
        if(intervals.length <= 1) return 0;
        
		Arrays.sort(intervals,new Comparator<Interval>() {
        	public int compare(Interval i1, Interval i2) {
        		if(i1.start == i2.start) return i1.end-i2.end;
        		return i1.start-i2.start;
        	}
        });
		PriorityQueue<int[]> pq= new PriorityQueue<int[]>((i1,i2) -> i1[1]-i2[1]);
		int max = 1;
        for(Interval interval : intervals) {
            if(pq.isEmpty()) {
                pq.offer(new int[]{interval.start,interval.end,1});
            } else {
                int end = pq.peek()[1];
                if(interval.start >= end) {
                	int count = pq.poll()[2];
                	pq.offer(new int[]{interval.start,interval.end,count+1});
                	max = Math.max(max,count+1);
                } else {
                	pq.offer(new int[]{interval.start,interval.end,1});
                }
            }
        }
        
        System.out.println(max);
        
        return intervals.length-max;
    }

}
