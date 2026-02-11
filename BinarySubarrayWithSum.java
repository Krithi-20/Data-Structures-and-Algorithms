class Solution {

    public int function(int []nums,int goal) {
        int l=0;
        int r=0;
        int sum = 0;
        int cnt = 0;

        if(goal < 0) return 0;
        while(r < nums.length) {
            sum += nums[r];
            while(sum > goal) {
                sum -= nums[l];
                l++;
            }
            cnt += (r-l+1);
            r++;
        }
        return cnt;
    }
    public int numSubarraysWithSum(int[] nums, int goal) {
        int f1 = function(nums,goal);
        int f2 = function(nums,goal-1);
        return f1-f2;
    }
}