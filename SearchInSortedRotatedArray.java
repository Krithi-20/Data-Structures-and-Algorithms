class SearchInSortedRotatedArray {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            
            if(nums[mid] == target) {
                return mid;
            }

            if(nums[left] <= nums[mid]) { //if left to mid is sorted region search there
                if(target < nums[left] || target > nums[mid]) { //if target lies beyond left to mid
                    left = mid+1;
                }
                else {
                    right = mid-1;
                }
            }

            else { //if mid to right is the sorted region
                if(target < nums[mid] || target > nums[right]) { //kf target lies beyond mid to right
                    right = mid-1;
                } 
                else {
                    left = mid+1;
                }
            }
        }
        return -1;
    }
}