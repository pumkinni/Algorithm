import java.util.*;

class Solution {
    public String solution(String s) {
        
        StringBuilder answer = new StringBuilder();
        
        List<Character> list = new ArrayList();
        
        Map<Character, Integer> map = new HashMap();
        
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> item : map.entrySet()) {
            if (item.getValue() == 1){
                answer.append(item.getKey());
            }
        }
        
        char[] spells = answer.toString().toCharArray();
        
        Arrays.sort(spells);
        
        
        return String.valueOf(spells);
    }
}