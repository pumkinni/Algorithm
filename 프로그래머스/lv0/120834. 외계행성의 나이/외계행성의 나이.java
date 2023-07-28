class Solution {
    public String solution(int age) {
        StringBuffer sb = new StringBuffer();
        
        while (age >0){
            sb.append(String.valueOf((char)((int)'a'+ age%10)));
            age /= 10;
        }
    
        return sb.reverse().toString();
    }
}