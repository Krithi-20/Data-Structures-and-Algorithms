class SubsequenceUsingCyclicIncrements {
 
    public boolean canMakeSubsequence(String str1, String str2) {
        int i=0; 
        int j=0;

        while(i < str1.length() && j < str2.length()) {
            char c = str1.charAt(i);
            char next;
            
            if(c == 'z') {
                next = 'a';
            }
            else {
                next = (char) (c+1);
            }

            if(c == str2.charAt(j) || next == str2.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == str2.length();
    }
}