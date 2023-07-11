class Solution {
    public String[] solution(String[] quiz) {
        String[] answer = new String[quiz.length];
        
        for (int i=0; i < quiz.length; i++){
            if (check(quiz[i])){
                answer[i] = "O";
            } else {
                answer[i] = "X";
            }
        }
        
        return answer;
    }
    
    public boolean check(String quiz){
        String[] strings = quiz.split("=");
        String problem = strings[0];
        int solve;
        int answer = Integer.valueOf(strings[1].trim());
        
        String[] nums = problem.split(" ");
        
        if (nums[1].trim().equals("+")){
            solve = Integer.valueOf(nums[0]) + Integer.valueOf(nums[2]);
        } else {
            solve = Integer.valueOf(nums[0]) - Integer.valueOf(nums[2]);
        }
        
        return solve == answer;
    }
}