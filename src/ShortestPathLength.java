import java.util.*;

public class ShortestPathLength {
	class State {
        public int source;
        public int mask;
        public State(int s, int m) {
            source = s;
            mask = m;
        }
    }
	
	public int shortestPathLength(int[][] graph) {
        int N = graph.length;
        int[][] dp = new int[N][1 << N];
        
        Queue<State> qe = new LinkedList<>();
        
        for(int i = 0; i < N; i++) {
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][1 << i] = 0;
            qe.offer(new State(i,1<<i));
        }
        
        while(!qe.isEmpty()) {
            State state = qe.poll();
            int source = state.source;
            
            for(int next : graph[source]) {
                int mask = 1 << next;
                int nextMask = mask | state.mask;
                if(dp[next][nextMask] > dp[source][state.mask]+1) {
                    dp[next][nextMask] = dp[source][state.mask]+1;
                    qe.offer(new State(next,nextMask));
                }
            }
        }
        
        int res = Integer.MAX_VALUE;
        
        for(int i = 0; i < N; i++) {
            res = Math.min(res,dp[i][(1<<N)-1]);
        }
        
        return res;
    }

}
