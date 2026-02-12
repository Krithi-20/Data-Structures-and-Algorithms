import java.util.HashMap;
import java.util.Map;

class Solution {
    public String minWindow(String s, String t) {
        int l = 0;
        int r = 0;
        int minLen = Integer.MAX_VALUE;
        int cnt = 0;
        int startIdx = -1;

        Map <Character, Integer> mp = new HashMap <>();

        for(int i=0; i<t.length(); i++) {
            mp.put(t.charAt(i),mp.getOrDefault(t.charAt(i),0)+1);
        }

        while(r < s.length()) {
            if(mp.containsKey(s.charAt(r))) {
                if(mp.get(s.charAt(r)) > 0) {
                    cnt++;
                }
                mp.put(s.charAt(r),mp.get(s.charAt(r))-1);
            }

            while(cnt == t.length()) {
                if(r-l+1 < minLen) {
                    minLen = r-l+1;
                    startIdx = l;
                }

                if(mp.containsKey(s.charAt(l))) {
                    mp.put(s.charAt(l), mp.get(s.charAt(l))+1);
                    if(mp.get(s.charAt(l)) > 0) {
                        cnt--;
                    }
                }
                l++;
            }

            r++;
        }
        return startIdx == -1 ? "" : s.substring(startIdx, minLen+startIdx);
    }
}
