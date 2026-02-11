import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0 || s == null) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = 0;
        int maxLen = 0;
        int [] hash = new int[256];
        Arrays.fill(hash,-1);

        while(right < s.length()) {
            if(hash[s.charAt(right)] >= left) {
                left = hash[s.charAt(right)]+1;
            }
            int len = right - left + 1;
            maxLen = Math.max(len,maxLen);
            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}