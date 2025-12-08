
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings {
    public String encode (List <String> strs) {
        if(strs.size() == 0) {
            return Character.toString((char)258);
        }
        String seperate = Character.toString((char)257);
        StringBuilder sb = new StringBuilder();
        for(String s : strs) {
            sb.append(s);
            sb.append(seperate);
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public List<String> decode(String s) {
        if(s.equals(Character.toString((char)258))) {
            return new ArrayList();
        }
        String seperate = Character.toString((char)257);
        return Arrays.asList(s.split(seperate,-1));
    }
}