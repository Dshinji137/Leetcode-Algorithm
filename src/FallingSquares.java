import java.util.*;

public class FallingSquares {
	List<Integer> res = new ArrayList<>();
    public List<Integer> fallingSquares(int[][] positions) {
        List<Integer> points = new ArrayList<>();
        Map<Integer,Integer> map = new HashMap<>();
        
        for(int[] pos : positions) {
            int start = pos[0]; int end = pos[0]+pos[1];
            int ind1 = insert(points,start);
            int ind2 = insert(points,end);
            
            int cnt = 0; 
            int maxH = ind1>=1? map.get(points.get(ind1-1)):0;
            while(cnt < ind2-ind1) {
                int point = points.get(ind1);
                if(point != end) {
                	maxH = Math.max(maxH,map.get(point));
                }
                points.remove(ind1);
                cnt++;
            }
            points.add(ind1,end);
            points.add(ind1,start);
            map.put(start,maxH+pos[1]);
            map.put(end,maxH+pos[1]);
            
            int maxHeight = res.size()==0? maxH+pos[1] : Math.max(maxH+pos[1],res.get(res.size()-1));
            res.add(maxHeight);
        }
        
        return res;
    }
    
    int insert(List<Integer> list, int target) {
        int l = 0; int r = list.size();
        while(l < r) {
            int mid = l + (r-l)/2;
            if(list.get(mid) <= target) {
                l = mid+1;
            } else {
                r = mid;
            }
        }
        return l;
    }

}
