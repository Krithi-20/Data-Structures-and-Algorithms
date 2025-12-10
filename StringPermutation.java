class StringPermuatation {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) {
            return false;
        }
        int []s1FreqMap = new int [26];
        int []s2FreqMap = new int [26];

        for(int i=0; i<s1.length(); i++) {
            s1FreqMap[s1.charAt(i) - 'a']++;
            s2FreqMap[s2.charAt(i) - 'a']++; //first sliding window of S2
        }

        for(int i=0; i<s2.length()-s1.length(); i++) { //until length of s2-length of s1 for last sliding window
            if(matches(s1FreqMap,s2FreqMap)) {
                return true;
            }
            s2FreqMap[s2.charAt(i + s1.length()) - 'a']++; //increase sliding window by 3 on right side
            s2FreqMap[s2.charAt(i) -'a']--; //decrease sliding window until i on left side
        }
        return matches(s1FreqMap, s2FreqMap);
    }

    public boolean matches (int [] s1Map, int [] s2Map) {
        for(int i=0; i<26; i++) {
            if(s1Map[i] != s2Map[i]) {
                return false;
            }
        }
        return true;
    }
}