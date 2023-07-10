import java.util.*;

class Solution {
    public int[] solution(String myString) {
        ArrayList<Integer> list = new ArrayList();
        
        for (String word : myString.split("x")){
            list.add(word.length());
        }
        
        if (myString.charAt(myString.length() - 1) == 'x'){
            list.add(0);
        }
        
        return list.stream().mapToInt(i->i).toArray();
    }
}