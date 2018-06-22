import java.util.*;

public class ExamRoom {
	int n;
    List<Integer> list;
    
    public ExamRoom(int N) {
        n = N;
        list = new ArrayList<>();
    }
    
    public int seat() {
        if(list.size() == 0) {
            list.add(0,0);
            return 0;
        } else if(list.size() == 1) {
            int ind = 2*list.get(0) >= n-1? 0 : n-1;
            if(2*list.get(0) >= n-1) {
            	list.add(0,0);
            } else {
            	list.add(n-1);
            }
            return ind;
        } else {
            int[] info = getSeat();
            int value = (info[0]+info[1]) / 2;
            int insertInd = info[2];
            list.add(insertInd,value);
            return value;
        }
    }
    
    public void leave(int p) {
        int ind = search(p);
        list.remove(ind);
        /*
        System.out.print("after remove ");
        for(int ele : list) {
        	System.out.print(ele+" ");
        }
        */
    }
    
    int[] getSeat() {
        int[] info = new int[]{0,0,-1};
        int max = 0;
        
        for(int i = 0; i < list.size()-1; i++) {
            if((list.get(i+1)-list.get(i))/2 > max) {
                info = new int[]{list.get(i),list.get(i+1),i+1};
                max = (list.get(i+1)-list.get(i)) / 2;
            }
        }
        
        if(list.get(0) != 0 && list.get(0) >= max) {
            max = list.get(0);
            info = new int[]{0,0,0};
        }
        if(n-1-list.get(list.size()-1) > max) {
            info = new int[]{n-1,n-1,list.size()};
        }
        
        return info;
    }
    
    int search(int target) {
        int l = 0; int r = list.size();
        while(l < r) {
            int mid = (l+r) / 2;
            if(list.get(mid) >= target) {
                r = mid;
            } else {
                l = mid+1;
            }
        }
        return l;
    }
}

