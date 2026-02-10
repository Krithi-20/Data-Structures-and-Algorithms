class LargestOddNumberInString {
    public String largestOddNumber(String num) {
        int idx = -1;
        for(int i= num.length()-1; i>=0; i--) {
            if((num.charAt(i) - '0')%2 == 1) {
                idx = i;
                break;
            }
        }
        if(idx < 0) return "";
        String s = num.substring(0,idx+1);
        return s;
    }
}