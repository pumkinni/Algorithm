import java.util.*;

class Solution {
    public String[] solution(String my_string) {
        ArrayList<String> answerList = new ArrayList();
        
        for (String word : my_string.split(" ")){
            if (word.length() > 0){
                answerList.add(word);
            }
        }
        return answerList.toArray(new String[answerList.size()]);
    }
}