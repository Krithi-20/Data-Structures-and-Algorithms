import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0 || k<=0) {
            return new int [0];
        }
        int n = nums.length;
        int [] result = new int[n-k+1];
        Deque <Integer> dequeue = new LinkedList <> ();
        
        for(int i=0; i<n; i++) {
            while(!dequeue.isEmpty() && dequeue.peek() < i-k+1) {
                dequeue.poll();
            }
            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i]) {
                dequeue.pollLast();
            }
            dequeue.offer(i);

            if(i>=k-1) {
                result[i-k+1] = nums[dequeue.peek()];
            }
        }
        return result;
    }
}