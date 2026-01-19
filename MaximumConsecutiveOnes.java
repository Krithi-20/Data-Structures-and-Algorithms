class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int curr = 0, max = 0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == 1) {
                curr++;
                if(curr>max) {
                    max = curr;
                }
            } else {
                curr = 0;
            }
        }
        return max;
    }
}