
public class LongestPalindrome {
	public String longestPalindrome(String s) {
        if(s.length() <= 1) return s;
        
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        for(int i = 0; i < len; i++) {dp[i][i] = true;}
        int max = 1; String ans = s.substring(0,1);
        
        for(int d = 1; d < len; d++) {
            for(int r = 0; r < len-d; r++) {
                int c = r+d;
                if(s.charAt(r) == s.charAt(c)) {
                    if(c-r>=2) {
                        if(dp[r+1][c-1]) {
                        	dp[r][c] = true;
                            if(c-r+1 > max) {
                                max = c-r+1;
                                ans = s.substring(r,c+1);
                            }
                        }
                    } else {
                    	dp[r][c] = true;
                        if(c-r+1 > max) {
                            max = c-r+1;
                            ans = s.substring(r,c+1);
                        }
                    }
                }
            }
        }   
        return ans;
    }
}
