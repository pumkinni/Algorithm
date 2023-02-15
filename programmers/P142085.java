import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        PriorityQueue<Integer> maxHeap = new PriorityQueue(Collections.reverseOrder());
        
        if (k >= enemy.length){
            return enemy.length;
        }
        
        for (int i = 0; i < enemy.length; i++){
            int enemyNum = enemy[i];
            maxHeap.offer(enemyNum);
            // 적 > 군사시 무적권 쓰기
            while (n < enemyNum){
                // 무적권이 있고 무적권을 쓸수 있는 군사가 있으면
                if (k > 0 && !maxHeap.isEmpty()){ 
                    n += maxHeap.poll();
                    k--;
                } else { // 무적권이 없거나 무적권을 쓸수 있는 군사가 없다면
                    return i;
                }
            }
            n -= enemyNum;
        }
        
        return enemy.length;
    }
}
