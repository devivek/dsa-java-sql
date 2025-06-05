package String;

import java.util.*;

public class ReverseWords {
    public String reverseWords1(String s) {
        String res = "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c != ' '){
                sb.append(c);
            }else {
                if(!sb.toString().isEmpty()){
                    res = sb.toString() + " " + res; // Expensive operation
                    sb = new StringBuilder();
                }

            }
        }
        if(!sb.toString().isEmpty())
            res = sb.toString() + " " + res;
        return res.substring(0, res.length()-1);
    }

    public String reverseWords2(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c != ' '){
                sb.append(c);
            }else {
                if(!sb.toString().isEmpty()){
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }

            }
        }
        if(!sb.toString().isEmpty())
            res.add(sb.toString());
        Collections.reverse(res);
        return String.join(" ", res);
    }

    public String reverseWords3(String s) {
        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c != ' '){
                sb.append(c);
            }else {
                if(!sb.toString().isEmpty()){
                    res.add(sb.toString());
                    sb = new StringBuilder();
                }

            }
        }
        if(!sb.toString().isEmpty()){
            res.add(sb.toString());
            sb = new StringBuilder();
        }
        for(int i=res.size()-1; i>=0; i--){
            sb.append(res.get(i));
            if(i != 0)
                sb.append(" ");
        }
        return sb.toString();
    }
}
