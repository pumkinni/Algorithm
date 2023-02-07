import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";
        ArrayList<Character> list = new ArrayList();
        char c = 'a';
        
        while(c <= 'z'){
            if (!skip.contains(String.valueOf(c))){
                list.add(c);
            }
            c = (char)(c + 1);
        }
        
        for (char ch : s.toCharArray()){
            
            char newChar = list.get((list.indexOf(ch) + index) % list.size());
            answer += String.valueOf(newChar);
        }

        return answer;
    }
}
