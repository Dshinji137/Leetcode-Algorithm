import java.util.*;

public class MaxEnvelopes {
	public int maxEnvelopes(int[][] envs) {
		if(envs.length <= 1) return envs.length;
        
        Arrays.sort(envs,new Comparator<int[]>() {
            @Override
            public int compare(int[] e1, int[] e2) {
                if(e1[0]==e2[0]) return e2[1]-e1[1];
                return e1[0]-e2[0];
            }
        });
        
        int[] dp = new int[envs.length]; int size = 0;
        
        for(int[] env : envs) {
            int l = 0; int r = size;
            while(l < r) {
                int mid = l + (r-l)/2;
                if(dp[mid] < env[1]) {
                    l = mid+1;
                } else {
                    r = mid;
                }
            }
            dp[l] = env[1];
            if(l == size) size++;
        }
        
        return size;
    }

}
