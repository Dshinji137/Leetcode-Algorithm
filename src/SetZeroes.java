
public class SetZeroes {
	public void setZeroes(int[][] matrix) {
        if(matrix.length == 0) return;
        int m = matrix.length; int n = matrix[0].length;
        int firstRow = 1; int firstCol = 1;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0 && j == 0) {
                        firstRow = 0; firstCol = 0;
                    } else if(i == 0) {
                        firstRow = 0; matrix[0][j] = 0;
                    } else if(j == 0) {
                        firstCol = 0; matrix[i][0] = 0;
                    } else {
                        matrix[0][j] = 0; matrix[i][0] = 0;
                    }
                }
            }
        }
        
        for(int i = 1; i < m; i++) {
            if(matrix[i][0] == 0) {matrix[i] = new int[n];}
        }
        
        for(int i = 1; i < n; i++) {
            if(matrix[0][i] == 0) {
                for(int j = 0; j < m; j++) {matrix[j][i] = 0;}
            }
        }
        
        if(firstRow == 0) matrix[0] = new int[n];
        if(firstCol == 0) {
            for(int i = 0; i < m; i++) matrix[i][0] = 0;
        }
    }

}
