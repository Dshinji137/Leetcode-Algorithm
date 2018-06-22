
public class WordSearch {
	public int[][] dirs = new int[][]{{0,1},{0,-1},{1,0},{-1,0}}; 
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 || board[0].length == 0) return false;
        
        int m = board.length; int n = board[0].length;
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                boolean[][] visited = new boolean[m][n];
                if(check(visited,i,j,board,word,0)) return true;
            }
        }
        return false;
    }
    
    public boolean check(boolean[][] visited, int r, int c, char[][] board, String word, int ind) {
        if(ind == word.length()) return true;
        if(board[r][c] != word.charAt(ind)) return false;
        int m = board.length; int n = board[0].length;
        visited[r][c] = true;
        for(int[] dir : dirs) {
            int x = r+dir[0];
            int y = c+dir[1];
            if(x<0 || x==m || y<0 || y==n || visited[x][y]) continue;
            if(check(visited,x,y,board,word,ind+1)) return true;
        }
        visited[r][c] = false;
        return false;
    }

}
