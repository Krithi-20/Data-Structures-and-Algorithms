class Solution {
    public int maxDepth(String s) {
        int maxNesting = 0;
        int currNesting = 0;
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(') {
                currNesting++;
                maxNesting = Math.max(currNesting,maxNesting);
            }
            if(s.charAt(i) == ')') {
                currNesting--;
            }
        }

        return maxNesting;
    }
}