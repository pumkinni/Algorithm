import java.util.*;

class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>((x,y) -> x[1] - y[1]);
        
        for (int i=0; i<rank.length; i++){
            if (attendance[i]){
                queue.offer(new int[]{i, rank[i]});
            }
        }
        
        int idx = 0;
        int num = 10000;
        
        while (idx < 3){
            int[] cur = queue.poll();
            answer += num * cur[0];
            num /= 100;
            idx++;
        }
        return answer;
    }
}