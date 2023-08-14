import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        
        
        int[][] pick = new int[][]{{1,1,1}, {5,1,1}, {25,5,1}};
        
        PriorityQueue<int[]> queue = new PriorityQueue<>
            ((x,y) -> y[0]==x[0] ? (y[1]==x[1]? y[2]-x[2] : y[1] - x[1]) : y[0] - x[0] );
        
        int n = minerals.length;
        int pickNum = picks[0] + picks[1] + picks[2];

        int idx=0;
        while(idx <= pickNum * 5 && idx < n){
            int d = 0;
            int ir = 0;
            int s = 0;
            for (int j=0; j<5; j++){
                if (minerals[idx].equals("diamond")){
                    d++;
                } else if (minerals[idx].equals("iron")){
                    ir++;
                } else {
                    s++;
                }
                idx++;
                if (idx >= n || idx > pickNum * 5){
                    break;
                }
            }
            queue.add(new int[]{d,ir,s});
        }
        
        int curIdx = 0;
                
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            
            while(picks[curIdx] == 0){
                curIdx++;
                if (curIdx > 2){
                    return answer;
                }
            }
            
            for (int i=0; i<3; i++){
                answer += cur[i] * pick[curIdx][i];
            }
            picks[curIdx] -= 1;
            
        }
        
        return answer;
    }
}