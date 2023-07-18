
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        StringBuilder answer = new StringBuilder();
        Map<Character, Integer> map = new HashMap();
        int[] score = new int[]{0,3,2,1,0,1,2,3};
        
        for (int i=0; i<survey.length; i++){
            int choice = choices[i];
            char c;
            
            if (choice < 4){
                c = survey[i].charAt(0);
            } else if (choice > 4){
                c = survey[i].charAt(1);
            } else {
                continue;
            }
            
            map.put(c, map.getOrDefault(c, 0) + score[choice]);
            
            }
        
        if (map.getOrDefault('R', 0) > map.getOrDefault('T', 0)){
            answer.append('R');
        } else if (map.getOrDefault('R', 0) < map.getOrDefault('T', 0)){
            answer.append('T');
        } else {
            answer.append('R');
        }
        
        if (map.getOrDefault('C',0) > map.getOrDefault('F',0)){
            answer.append('C');
        } else if (map.getOrDefault('C',0) < map.getOrDefault('F',0)){
            answer.append('F');
        } else {
            answer.append('C');
        }
        
        if (map.getOrDefault('J',0) > map.getOrDefault('M',0)){
            answer.append('J');
        } else if (map.getOrDefault('J',0) < map.getOrDefault('M',0)){
            answer.append('M');
        } else {
            answer.append('J');
        }
        
        if (map.getOrDefault('A',0) > map.getOrDefault('N',0)){
            answer.append('A');
        } else if (map.getOrDefault('A',0) < map.getOrDefault('N',0)){
            answer.append('N');
        } else {
            answer.append('A');
        }
    
        
        return answer.toString();
    }
}