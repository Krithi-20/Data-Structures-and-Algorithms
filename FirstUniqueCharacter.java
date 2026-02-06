class FirstUniqueCharacter

    public int firstUniqChar(String s) {
        int []frq = new int[26];
        for(char c : s.toCharArray()) {
            frq[c - 'a']++;
        }
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(frq[c - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    /*public int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap <>();
        for(char c : s.toCharArray()) {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        for(int i=0; i<s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }*/
}