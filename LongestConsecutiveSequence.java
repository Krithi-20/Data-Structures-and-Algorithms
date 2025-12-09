import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        Set <Integer> numSet = new HashSet <> ();
        for(int n : nums) {
            numSet.add(n);
        } 
        int LCS = 1;
        for(int n : numSet) {
            if(numSet.contains(n-1)) {
                continue;
            }
            else {
                int currNum = n;
                int CS = 1;
                while(numSet.contains(currNum+1)) {
                    currNum++;
                    CS++;
                }
                LCS = Math.max(LCS,CS);
            }
        }
        return LCS;
    }
}