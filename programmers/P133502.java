import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        int answer = 0;
        int[] stack = new int[ingredient.length];
        int ss = 0;
        
        for (int i : ingredient){
            stack[ss++] = i;
            if (ss >= 4){
                if (stack[ss-1] == 1 && stack[ss-2] == 3 && stack[ss-3] ==2 && stack[ss-4] == 1){
                    answer ++;
                    ss -= 4;
                }
            }
        }
        return answer;
    }
}
