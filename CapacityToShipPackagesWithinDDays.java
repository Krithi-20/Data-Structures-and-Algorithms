import java.util.Arrays;

class Solution {

    public int reqDaysCapacity(int [] arr, int capacity) {
        int days = 1; int sum = 0;
        for(int i=0; i<arr.length; i++) {
            if(sum + arr[i] > capacity) {
                days++;
                sum = arr[i];
            }
            else {
                sum += arr[i];
            }
        }
        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low = Arrays.stream(weights).max().getAsInt();
        int high = Arrays.stream(weights).sum();

        while(low <= high) {
            int mid = low + (high-low)/2;
            int reqDays = reqDaysCapacity(weights,mid);

            if(reqDays <= days) {
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return low;
    }
}