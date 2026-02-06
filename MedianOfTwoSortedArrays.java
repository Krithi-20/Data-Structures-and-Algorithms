class MedianOfTwoSortedArrays {

    public int find(int [] nums1, int [] nums2, int idx) {
        int i=0; int j=0;
        int cnt = 0;
        int ele = 0;
        while (i < nums1.length && j < nums2.length) {
            if(nums1[i] <= nums2[j]) {
                if(cnt == idx) {
                    ele = nums1[i];
                }
                cnt++;
                i++;
            } 
            else {
                if(cnt == idx) {
                    ele = nums2[j];
                }
                cnt++;
                j++;
            }
        }

        while(i < nums1.length) {
            if(cnt == idx) {
                ele = nums1[i];
            }
            cnt++;
            i++;
        }

        while(j < nums2.length) {
            if(cnt == idx) {
                ele = nums2[j];
            }
            cnt++;
            j++;
        }

        return ele;
    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int length = m+n;

        if(length % 2 == 0) {
            int idx1 = (length/2)-1;
            int idx2 = (length/2);
            int ele1 = find(nums1, nums2, idx1);
            int ele2 = find(nums1, nums2, idx2);
            return (double) (ele1+ele2)/2;
        }
        else {
            int idx = (length/2);
            int ele = find(nums1, nums2, idx);
            return (double) ele;
        }
    }
}