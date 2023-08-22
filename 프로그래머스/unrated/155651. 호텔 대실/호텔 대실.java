import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (x,y) ->  x[0].compareTo(y[0]));
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> (x[1] == y[1] ? y[0]-x[0] : x[1] - y[1]));
        // PriorityQueue<int[]> pq2 = new PriorityQueue<>((x,y) -> (x[1] == y[1] ? y[0]-x[0] : x[1] - y[1]));

        
        for (String[] book : book_time){
            String[] start = book[0].split(":");
            String[] end = book[1].split(":");
            
            int startT = Integer.valueOf(start[0])*60 + Integer.valueOf(start[1]);
            int endT = Integer.valueOf(end[0])*60 + Integer.valueOf(end[1]) + 10;
            
            // 대실중이 방이 없을경우
            if (pq.isEmpty()){
                pq.offer(new int[]{startT, endT});
                answer++;
                continue;
            }
            
            int[] cur = pq.peek();
            
            if (startT < cur[1]){
                answer++;
            } else {
                pq.poll();
            }
            pq.offer(new int[]{startT, endT});
            
        }      
        
//         while (!pq.isEmpty()){
//             pq = check(pq, pq2);
//             pq2 = new PriorityQueue<int[]>((x,y) -> (x[1] == y[1] ? y[0]-x[0] : x[1] - y[1]));
//             answer++;
//         }
        
        return answer;
    }
    
//     public PriorityQueue<int[]> check(PriorityQueue<int[]> pq1, PriorityQueue<int[]> pq2){
//         int curTime = 0;
        
//         while(!pq1.isEmpty()){
//             int[] cur = pq1.poll();
            
//             while(!pq1.isEmpty() && pq1.peek()[0] < cur[1]){
//                 System.out.print(pq1.peek()[0] + ", ");
                
//                 System.out.println(cur[1]);
//                 pq2.offer(pq1.poll());
//             }
//         }
        
//         return pq2;
//     }
                                                       
}