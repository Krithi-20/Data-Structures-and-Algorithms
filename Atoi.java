class Solution {
    public int myAtoi(String s) {
        StringBuilder sb = new StringBuilder();
        int i=0;
        while(i < s.length() && s.charAt(i) == ' ') {
            i++;
        }
        int sign = 1;
        if(i < s.length() && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if(s.charAt(i) == '-') sign = -1;
            i++;
        }
        long num = 0;
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            num = num *  10 + (s.charAt(i)-'0');

            if(sign == 1 && num > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } 
            if(sign == -1 && -num < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int) (sign*num);
    }
}