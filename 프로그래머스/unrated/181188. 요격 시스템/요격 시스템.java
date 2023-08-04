import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (x,y) -> x[1] - y[1]);
        
        int last = 0;
        int idx = 0;
        int[] cur;
        
        while (idx < targets.length) {
            cur = targets[idx++];
            last = cur[1] - 1;
            
            while (idx < targets.length && targets[idx][0] <= last && targets[idx][1] > last){
                idx++;
            }
            answer++;
        }
        
        
        return answer;
    }
}