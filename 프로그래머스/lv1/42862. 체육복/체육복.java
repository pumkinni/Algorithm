import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        ArrayList<Integer> reserveList = new ArrayList();
        ArrayList<Integer> lostList = new ArrayList();
        int idx = 0;
        
        
        for (int re : reserve){
            reserveList.add(re);
        }
        
        for (int lo : lost){
            if (reserveList.contains(lo)){
                reserveList.remove(reserveList.indexOf(lo));
            } else {
                lostList.add(lo);
            }
        }
        
        answer = n - lostList.size();
        
        for (int lo : lostList){
            if (reserveList.contains(lo-1)){
                reserveList.remove(reserveList.indexOf(lo-1));
                answer++;
            } else if (reserveList.contains(lo+1)){
                reserveList.remove(reserveList.indexOf(lo+1));
                answer++;
            }
        }
        
        return answer;
    }
}