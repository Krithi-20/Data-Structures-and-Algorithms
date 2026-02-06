class Solution {

    public int splitSum(int [] nums, int mid) {
        int k = 1;
        int next = 0;
        for(int i=0; i<nums.length; i++) {
            if(next + nums[i] <= mid ) {
                next += nums[i];
            }
            else {
                k++;
                next = nums[i];
            }
        }
        return k;
    }
    public int splitArray(int[] nums, int k) {
        int low = Arrays.stream(nums).max().getAsInt();
        int high = Arrays.stream(nums).sum();

        while(low <= high) {
            int mid = low + (high - low)/2;

            int minSum = splitSum(nums,mid);
            if(minSum > k) {
                low = mid+1;
            }
            else {
                high = mid-1;
            }
        }
        return low;
    }
}