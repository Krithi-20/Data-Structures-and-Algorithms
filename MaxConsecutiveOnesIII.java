class Solution {
    public int longestOnes(int[] nums, int k) {
        if(nums.length == 0) {
            return 0;
        }

        int l = 0;
        int r = 0;
        int maxLen = 0;
        int zeros = 0;

        while(r < nums.length) {
            if(nums[r] == 0) zeros++;
            int currLen = 0;
            if(zeros > k) {
                if(nums[l] == 0) {
                    zeros--;
                }
                l++;
            } 
            currLen = r-l+1;
            maxLen = Math.max(maxLen,currLen);
            r++;
        }
        return maxLen;
    }
}
