
public class IncreasingTriplet {
	public boolean increasingTriplet(int[] nums) {
        if(nums.length < 3) return false;
        int len = nums.length;
        int[] maxNums = new int[len]; maxNums[len-1] = nums[len-1];
        
        for(int i = len-2; i >= 0; i--) {
            maxNums[i] = Math.max(nums[i],maxNums[i+1]);
        }
        
        
        int min = nums[0];
        for(int i = 1; i < len; i++) {
            if(nums[i] > min) {
                if(nums[i] < maxNums[i]) return true;
            } else {
                min = nums[i];
            }
        }
        
        return false;
    }

}
