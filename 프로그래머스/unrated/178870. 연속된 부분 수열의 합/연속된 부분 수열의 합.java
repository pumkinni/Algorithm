class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[]{0, sequence.length};
        
        int l = 0;
        int r = 0;
        int sum = 0;
        
        while (l < sequence.length){
            while (r < sequence.length && sum < k){
                sum += sequence[r++];
            }
            
            
            if (sum == k && answer[1] - answer[0] > r-l-1){
                answer = new int[]{l, r-1};
            }
            
            sum -= sequence[l++];
        }
        
        
        return answer;
    }
}