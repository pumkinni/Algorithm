class Solution {
    public int solution(String num_str) {
        int answer = 0;
        
        for (Character num : num_str.toCharArray()){
            answer += Integer.valueOf(num) - Integer.valueOf('0');
        }
        return answer;
    }
}