class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length};
        
        int s = 0;
        int e = 0;
        int sum = 0;
        
        while (s < sequence.length &&  e - 1 < sequence.length){
            
            while (e < sequence.length && sum < k){
                sum += sequence[e++];
            }
                        
            if (sum == k){
                if (answer[1] - answer[0] > e - s - 1){
                    answer[0] = s;
                    answer[1] = e - 1;
                }
            }
            
            sum -= sequence[s++];  
        }
        
        
        return answer;
    }
}