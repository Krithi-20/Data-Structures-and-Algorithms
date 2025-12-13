import java.util.HashMap;
import java.util.Stack;

class ValidParenthesis {
    public boolean isValid(String s) {
        HashMap <Character,Character> match = new HashMap <>();
        match.put(')','(');
        match.put(']','[');
        match.put('}','{');

        Stack <Character> stackT = new Stack <>();
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);

            if(!match.containsKey(c)) {
                stackT.push(c); 
            } else {
                if(stackT.isEmpty()) {
                    return false;
                }
                char topElement = stackT.pop();
                if(topElement != match.get(c)) {
                    return false;
                }
            }
        }
        return stackT.isEmpty();
    }   
}