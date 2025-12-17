class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];

        while(slow != fast) {  //detect cylce move slow 1 step and fast 2 steps
            slow = nums[slow];
            fast = nums[nums[fast]];
        }

        slow = 0;  //reset slow to initial point

        while(slow != fast) {  //move slow and fast by step until they meet and the point where they meet is duplicate
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow;
    }
}