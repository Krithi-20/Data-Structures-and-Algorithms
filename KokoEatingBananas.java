import java.util.Arrays;

class KokoEatingBananas {

    public long totalHrsUtility(int []piles, int mid) {
        long totalHrs = 0;
        for(int i : piles) {
            totalHrs += Math.ceil((double)i/mid);
        }
        return totalHrs;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int n = piles.length;

        int max = Arrays.stream(piles).max().getAsInt();
        
        int low = 1;
        int high = max;

        while(low <= high) {
            int mid = low + (high-low)/2;

            long totalHrs = totalHrsUtility(piles,mid);

            if(totalHrs <= h) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }
}