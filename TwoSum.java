import java.util.*;

class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map <Integer,Integer> sumExist = new HashMap <> ();
        for(int i=0; i<nums.length; i++) {
            int compliment = target-nums[i];
            if(sumExist.containsKey(compliment)) {
                return new int [] {sumExist.get(compliment), i};
            }
            sumExist.put(nums[i],i);
        }
        return new int[] {};
    }
}
