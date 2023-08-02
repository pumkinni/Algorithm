import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> map = new HashMap();
        
        for (String par :participant){
            map.put(par, map.getOrDefault(par, 0)+1);
        }
        
        for (String com : completion){
            map.put(com, map.get(com)-1);
        }
        
        for (String m : map.keySet()){
            if (map.get(m) == 1){
                answer = m;
                break;
            }
        }
        return answer;
    }
}