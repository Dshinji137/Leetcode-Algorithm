
public class Divide {
	public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
		
        long div1 = dividend;
        long div2 = divisor;
        
		if((div1 > 0 && div2 < 0) || (div1 < 0 && div2 > 0)) {
			return -helper(Math.abs(div1),Math.abs(div2));
        } else {
        	//System.out.println(div1+","+div2);
        	return helper(Math.abs(div1),Math.abs(div2));
        }
    }
	
	int helper(long dividend, long divisor) {
		if(dividend == 0 || dividend < divisor) return 0;
		
        long ans = 1; long sum = divisor;
        long currAns = 0; long currSum = 0;
        while(dividend >= sum) {
            currAns = ans;
            currSum = sum;
            ans += ans;
            sum += sum;
        }
        
        return (int)currAns+helper(dividend-currSum,divisor);
	}

}
