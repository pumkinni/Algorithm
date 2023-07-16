import java.util.*;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        
        Map<Character, Integer> map = new HashMap();
        
        for (String key : keymap){
            for (int i=0; i<key.length(); i++){
                char cur = key.charAt(i);
                map.put(cur, Math.min(map.getOrDefault(cur, Integer.MAX_VALUE), i+1));
            }
        }
        
        int idx = 0;
        roop:
        for (String target : targets){
            int sum = 0;
            for (char c : target.toCharArray()){
                Integer cur = map.get(c);

                if (cur == null){
                    answer[idx++] = -1;
                    continue roop;
                }
                sum += cur;
            }
            
            answer[idx++] = sum;
        }
        return answer;
    }
}