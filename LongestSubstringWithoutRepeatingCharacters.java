
import java.util.HashSet;

class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) {
            return 0;
        }
        if(s.length() == 1) {
            return 1;
        }

        int left = 0;
        int right = 0;
        int ans = 0;

        HashSet <Character> visited = new HashSet <> ();

        while(right < s.length()) {
            char c = s.charAt(right);
            while(visited.contains(c)) {
                visited.remove(s.charAt(left));
                left++;
            }
            visited.add(c);
            ans = Math.max(ans, right-left+1);
            right++;
        }
        return ans;
    }
}