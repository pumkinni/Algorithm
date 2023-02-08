class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        for (int i=0; i<s.length(); i++){
            answer[i] = -1;
            for (int j=1; j<=i; j++){
                if(s.charAt(i)==s.charAt(i-j)){
                    answer[i] = j;
                    break;
                }
            }
        }
        return answer;
    }
}
