
public class SingleNumber {
	public int[] singleNumber(int[] nums) {
        int xor = 0;
        for(int num : nums) {
            xor = xor ^ num;
        }
        
        int check = 1;
        while((xor & 1) == 0) {
            xor >>= 1;
            check <<= 1;
        }
        
        int[] res = new int[]{0,0};
        
        for(int num : nums) {
            if((num & check) == 0) {
                res[0] = res[0]^num;
            } else {
                res[1] = res[1]^num;
            }
        }
        
        return res;
    }

}
