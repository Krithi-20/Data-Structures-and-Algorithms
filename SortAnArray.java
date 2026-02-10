import java.util.ArrayList;
import java.util.List;

class Solution {

    public void merge(int []arr, int low, int mid, int high) {
        List <Integer> temp = new ArrayList <>();
        int left = low;
        int right = mid+1;
        while(left <= mid && right <= high) {
            if(arr[left] <= arr[right] ) {
                temp.add(arr[left]);
                left++;
            }
            else {
                temp.add(arr[right]);
                right++;
            }
        }
        while(left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while(right <= high) {
            temp.add(arr[right]);
            right++;
        }
        for(int i=low; i<=high; i++) {
            arr[i] = temp.get(i-low);
        }
    }

    public void mergeSort(int []arr, int low, int high) {
        int mid = low + (high - low)/2;

        if(low >= high) return;
        mergeSort(arr,low,mid);
        mergeSort(arr,mid+1,high);
        merge(arr,low,mid,high);
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;

        /* Selection Sort
        for(int i=0; i<n-1; i++) {
            int min = i;
            for(int j=i+1; j<n; j++) {
                if(nums[j] < nums[min]) {
                    min = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[min];
            nums[min] = temp;
        }*/

        /* Bubble Sort
        for(int i=n-1; i>=0; i--) {
            int didSwap = 0;
            for(int j=0; j<i; j++) {
                if(nums[j] > nums[j+1]) {
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    didSwap = 1;
                }
            }
            if(didSwap == 0) {
                break;
            }
        }
        */
        /* 
        for(int i=0; i<n; i++) {
            int j = i;
            while(j > 0 && nums[j-1] > nums[j]) {
                int temp = nums[j-1];
                nums[j-1] = nums[j];
                nums[j] = temp;
                j--;
            }
        }*/
        mergeSort(nums,0,n-1);
        return nums;
    }
}