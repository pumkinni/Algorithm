class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int cur = 0;
        
        for (int sec : section){
            if (sec < cur){
                continue;
            }
            answer++;
            cur = sec + m;
        }
        return answer;
    }
}