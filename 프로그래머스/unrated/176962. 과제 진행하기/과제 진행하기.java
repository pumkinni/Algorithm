import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        int idx = 0;
    
        
        PriorityQueue<int[]> queue = new PriorityQueue<>((x,y) -> x[1] - y[1]);
        
        for (int i=0; i<plans.length; i++){
            String[] times = plans[i][1].split(":");
            
            queue.add(new int[]{i, Integer.valueOf(times[0]) * 60 + Integer.valueOf(times[1]), Integer.valueOf(plans[i][2])});
        }
        
        Stack<int[]> stack = new Stack();
        
        int [] cur = new int[3];
        int time = queue.peek()[1];
        
        while (!queue.isEmpty()){
            cur = queue.poll();
            int restTime = cur[1] - time;
            
            while (!stack.isEmpty() && restTime > 0){
                int[] pro = stack.pop();
                if (pro[2] <= restTime){
                    answer[idx++] = plans[pro[0]][0];
                    restTime -= pro[2];
                    time += pro[2];
                } else {
                    pro[2] = pro[2] - restTime;
                    stack.add(pro);
                    time = cur[1];
                    break;
                }
            }
            time = cur[1];
            
            stack.add(cur);
        }
        
        while(!stack.isEmpty()){
            answer[idx++] = plans[stack.pop()[0]][0];
        }
        
    return answer;
        
    } 
}