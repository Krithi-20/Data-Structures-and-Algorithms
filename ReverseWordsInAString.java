class ReverseWordInAString {
    public String reverseWords(String s) {

        /*Stack <Character> st = new Stack<>();
        StringBuilder res = new StringBuilder();
        for(int i=s.length()-1; i>=0; i--) {
            if(s.charAt(i) != ' ') {
                st.push(s.charAt(i));
            }
            else {
                if(!st.isEmpty()) {
                while(!st.isEmpty()) {
                    res.append(st.pop());
                }
                res.append(' '); 
                } 
            }
        }
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        if(res.length() > 0 && res.charAt(res.length()-1) == ' ') {
            res.deleteCharAt(res.length()-1);
        }
        return res.toString();*/

        StringBuilder sb = new StringBuilder();
        int i = s.length()-1;
        while(i>=0) {
            while(i>=0 && s.charAt(i) == ' ') {
                i--;
            }
            if(i<0) break;
            int end = i;
            while(i>=0 && s.charAt(i) != ' ') {
                i--;
            }
            String word = s.substring(i+1,end+1);

            if(sb.length() > 0) {
                sb.append(" ");
            }
            sb.append(word);
        }
        return sb.toString();
    }
}