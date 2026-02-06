import java.util.Arrays;

class MinimumNoOfDaysToMakeBouquet {

    public boolean possible(int[] bloomDay, int days, int m, int k) {
        int cnt = 0;
        int noOfB = 0;
        for(int i=0; i<bloomDay.length;i++) {
            if(bloomDay[i] <= days) {
                cnt++;
            }
            else {
                noOfB += (cnt/k);
                cnt = 0;
            }
        }
        noOfB += (cnt/k);
        return noOfB >= m;
    }

    public int minDays(int[] bloomDay, int m, int k) {

        if((long) m*k > bloomDay.length) return -1;

        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(possible(bloomDay,mid,m,k)) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
}