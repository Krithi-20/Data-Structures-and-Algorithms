class Solution {

    public int firstOccurance(int [] nums, int target, int n) {
        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {
                ans = mid;
                high = mid-1;
            } else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }

    public int lastOccurance(int [] nums, int target, int n) {
        int low = 0;
        int high = n-1;
        int ans = -1;

        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] == target) {
                ans = mid;
                low = mid+1;
            } else if(nums[mid] < target) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = firstOccurance(nums,target,n);
        if(first == -1) return new int[] {-1,-1};
        int last = lastOccurance(nums,target,n);
        return new int [] {first,last};

    }
}