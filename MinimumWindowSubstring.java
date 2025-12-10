
import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }

        HashMap<Character, Integer> mapT = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            mapT.put(t.charAt(i), mapT.getOrDefault(t.charAt(i), 0) + 1);
        }

        int required = mapT.size();
        int formed = 0;

        int l = 0, r = 0;
        HashMap<Character, Integer> window = new HashMap<>();

        int[] ans = {-1, 0, 0}; // length, left, right

        while (r < s.length()) {
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (mapT.containsKey(c) && window.get(c).intValue() == mapT.get(c).intValue()) {
                formed++;
            }

            while (l <= r && formed == required) {
                if (ans[0] == -1 || (r - l + 1) < ans[0]) {
                    ans[0] = r - l + 1;
                    ans[1] = l;
                    ans[2] = r;
                }

                char leftChar = s.charAt(l);
                window.put(leftChar, window.get(leftChar) - 1);

                if (mapT.containsKey(leftChar) && window.get(leftChar) < mapT.get(leftChar)) {
                    formed--;
                }
                l++;
            }

            r++;   // <-- FIXED
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
