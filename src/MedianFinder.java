import java.util.*;

public class MedianFinder {
	PriorityQueue<Integer> minPQ;
	PriorityQueue<Integer> maxPQ;
    
    public MedianFinder() {
        minPQ = new PriorityQueue<>();
        maxPQ = new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        minPQ.add(num);
        maxPQ.add(minPQ.poll());
        if(minPQ.size() < maxPQ.size()) {
        	minPQ.add(maxPQ.poll());
        }
    }
    
    public double findMedian() {
        if(minPQ.size() == maxPQ.size()) {
        	return (double)(minPQ.peek()+maxPQ.peek())/2.0;
        } else {
        	return (double)minPQ.peek();
        }
    }
}
