import java.util.*;

public class FindLongestChain {
	public int findLongestChain(int[][] pairs) {
		if(pairs.length <= 1) return pairs.length;
        
        Arrays.sort(pairs, new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[1]-p2[1];
            }
        });
        
        int count = 0; int pos = -1;
        while(++pos < pairs.length) {
            count++;
            int currEnd = pairs[pos][1];
            while(pos+1<pairs.length && pairs[pos+1][0]<=currEnd) pos++;
        }
        
        return count;
    }

}
