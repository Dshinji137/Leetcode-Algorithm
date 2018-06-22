
public class FindNumberOfLIS {
	public int findNumberOfLIS(int[] nums) {
        if(nums.length <= 1) return nums.length;
        
        int len = nums.length;
        int[][] dp = new int[len][2];
        
        dp[0][0] = 1;
        for(int i = 1; i < nums.length; i++) {
            int j = i-1; boolean find = false;
            while(j >= 0) {
            	if(nums[i]<=nums[j]) {
            		dp[i][0] += dp[j][0];
            		dp[i][1] = 0;
            		find = true;
            	}
            	j--;
            }
            if(!find) {
            	dp[i][0] = 1;
                dp[i][1] = 1;
            }
        }
        
        int sum = dp[len-1][0];
        for(int i = len-2; i >= 0; i--) {
            sum += dp[len-1][1];
        }
        return sum;
    }

}
