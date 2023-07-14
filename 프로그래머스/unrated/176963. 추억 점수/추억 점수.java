import java.util.*;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String ,Integer> memory = new HashMap();
        
        for (int i=0; i<name.length; i++) {
            memory.put(name[i], yearning[i]);
        }
        
        int idx = 0;
        
        for (String[] pho : photo){
            int sum = Arrays.stream(pho).mapToInt(x -> memory.getOrDefault(x, 0)).sum();
            answer[idx++] = sum;
        }
        
        return answer;
    }
}