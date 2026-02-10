import java.util.List;
import java.util.ArrayList;

class Solution {
    public String frequencySort(String s) {
        /*HashMap <Character,Integer> freq = new HashMap <>();
        for(char c : s.toCharArray()) {
            freq.put(c,freq.getOrDefault(c,0)+1);
        }
        List <Character> lst = new ArrayList<>(freq.keySet());
        Collections.sort(lst,(a,b) -> freq.get(b)-freq.get(a));
        StringBuilder sb = new StringBuilder();
        for(char c : lst) {
            for(int i=0; i<freq.get(c); i++) {
                sb.append(c);
            }
        }
        return sb.toString();*/

        int [] freq = new int[125];
        for(char c : s.toCharArray()) {
            freq[c]++;
        }
        List<Character>[] bucket = new List[s.length() + 1];

        for (int i = 0; i < 125; i++) {
            if (freq[i] > 0) {
                int f = freq[i];
                if (bucket[f] == null) {
                    bucket[f] = new ArrayList<>();
                }
                bucket[f].add((char) i);
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int i = bucket.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                for (char c : bucket[i]) {
                    for (int j = 0; j < i; j++) {
                        sb.append(c);
                    }
                }
            }
        }

        return sb.toString();
    }
}

