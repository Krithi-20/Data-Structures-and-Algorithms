class MergeSortedArrayShellSortGapMethod {

    public void swap(int [] nums1, int [] nums2, int left, int right) {
        if(nums1[left] > nums2[right]) {
            int temp = nums1[left];
            nums1[left] = nums2[right];
            nums2[right] = temp;
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len = m+n;
        int gap = (len/2)+(len%2);

        while(gap > 0) {
            int left = 0;
            int right = left + gap;
            while(right < len) {
                
                if(left < m && right >= m) {
                    swap(nums1, nums2, left, right-m); 
                }

                 else if( left >= m) {
                    swap(nums2, nums2, left -m, right-m);
                 }

                 else {
                    if(right < m)
                    swap(nums1, nums1, left, right);
                 }

                 left++;
                 right++;
            }
            if(gap == 1) break;
            gap = (gap/2) + (gap%2);
        }
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }
}