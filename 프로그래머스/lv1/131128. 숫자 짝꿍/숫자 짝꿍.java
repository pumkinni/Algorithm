import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        int[] x = new int[10];
        int[] y = new int[10];
        
        for (char c : X.toCharArray()){
            x[c - (int)'0'] += 1;
        }
        
        for (char c : Y.toCharArray()){
            y[c - (int)'0'] += 1;
        }
        
        for (int i=9; i>=0; i--){
            int min = Math.min(x[i], y[i]);
            
            if (i == 0 && answer.length() == 0){
                if (min == 0){
                    return "-1";
                }
                return "0";
            }
            for (int j=0; j<min; j++){
                answer.append(i);
            }
        }
        return answer.toString();
    }
}