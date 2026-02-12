import java.util.HashMap;

class Solution {

    public int utility(int [] nums, int k) {
        int l=0; 
        int r=0;
        int maxLen = 0;
        HashMap<Integer,Integer> mp = new HashMap <>();

        while(r < nums.length) {
            mp.put(nums[r],mp.getOrDefault(nums[r],0)+1);

            while(mp.size() > k) {
                mp.put(nums[l],mp.get(nums[l])-1);
                if(mp.get(nums[l]) == 0) {
                    mp.remove(nums[l]);
                }
                l++;
            }

            maxLen = maxLen + (r-l+1);
            r++;
        }
        return maxLen;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return utility(nums,k) - utility(nums,k-1);
    }
}