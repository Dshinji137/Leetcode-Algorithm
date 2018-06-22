
public class LongestIncreasingPath {
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix.length == 0 || matrix[0].length == 0) return 0;
        int m = matrix.length; int n = matrix[0].length;
        
        int max = 0;
        int[][] rec = new int[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int num = dfs(matrix,rec,i,j);
                max = Math.max(max,num);
            }
        }
        
        for(int i = 0; i < m; i++) {
        	for(int j = 0; j < n; j++) {
        		System.out.print(rec[i][j]+" ");
        	}
        	System.out.println();
        }
        
        return max;
    }
    
    int dfs(int[][] matrix, int[][] rec, int i, int j) {
        if(rec[i][j] > 0) return rec[i][j];
        int m = matrix.length; int n = matrix[0].length;
        int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        int ans = 1;
        for(int[] dir : dirs) {
            int r = i+dir[0];
            int c = j+dir[1];
            if(r<0 || r==m || c<0 || c==n || matrix[r][c] <= matrix[i][j]) continue;
            ans = Math.max(ans,1+dfs(matrix,rec,r,c));
        }
        rec[i][j] = ans;
        return ans;
    }

}
