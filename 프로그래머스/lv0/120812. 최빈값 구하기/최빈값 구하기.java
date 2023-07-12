import java.util.*;

class Solution {
    public int solution(int[] array) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap();
        
        for (int a : array){
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        
        int max = -1;
        int cur = -1;
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            if (max < entry.getValue()){
                max = entry.getValue();
                cur = entry.getKey();
            } else if (max == entry.getValue()){
                cur = -1;
            }
        }
        
        return cur;
    }
}