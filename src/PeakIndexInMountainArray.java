
public class PeakIndexInMountainArray {
	public int peakIndexInMountainArray(int[] A) {
        int l = 1; int r = A.length;
        while(l < r) {
            int mid = (l+r) / 2;
            if(A[mid] > A[mid-1]) {
                if(mid<A.length-1 && A[mid]>A[mid+1]) return mid;
            	l = mid+1;
            } else {
            	
                r = mid-1;
            }
        }
        return l;
    }

}
