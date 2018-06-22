import java.util.*;

public class FindLHS {
	public int findLHS(int[] nums) {
        if(nums.length <= 1) return 0;
        
        Arrays.sort(nums);
        
        int f1 = 0; int f2 = 0; int max = 0;
        boolean first = true;
        int prev = nums[0]-2;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == prev) {
                if(first) f1++;
                else {f2++;max=Math.max(max,f1+f2);}
            } else {
                if(!first) {
                    if(nums[i]-1 == prev) {
                        f1 = f2; f2 = 1;
                        max = Math.max(max,f1+f2);
                    } else {
                        f1 = 1; f2 = 0;
                        first = true;
                    }
                } else {
                    if(nums[i]-1 == prev) {
                        f2 = 1;
                        max = Math.max(max,f1+f2);
                        first = false;
                    } else {
                        f1 = 1; f2 = 0;
                    }
                }
                prev = nums[i];
            }
        }
        
        return max;
    }

}
