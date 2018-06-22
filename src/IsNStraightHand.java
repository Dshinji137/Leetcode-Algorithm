import java.util.*;

public class IsNStraightHand {
	public boolean isNStraightHand(int[] hand, int W) {
        if(hand.length == 0 || hand.length%W != 0) return false;
        
        Map<Integer,Integer> map = new TreeMap<>();
        for(int num : hand) {
        	map.put(num,map.getOrDefault(num,0)+1);
        }
        
        for(int key : map.keySet()) {
        	if(map.get(key) > 0) {
        		for(int i = 1; i <= W-1; i++) {
            		if(map.getOrDefault(key+i, 0) < map.get(key)) return false;
            		map.put(key+i,map.get(key+i)-map.get(key));
            	}
        	}
        }
        
        return true;
    }

}
