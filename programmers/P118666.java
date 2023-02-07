import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        char[] unit = new char[]{'R','T','C','F','J','M','A','N'};
        HashMap<Character, Integer> map = new HashMap();
        for (char c : unit){
            map.put(c,0);
        }

        // map에 각 점수 입력
        for (int i=0; i<survey.length; i++){
            int score = choices[i];
            if (score < 4){
                char c = survey[i].charAt(0);
                map.put(c, map.get(c) + 4 - score);
            } else if (score > 4){
                char c = survey[i].charAt(1);
                map.put(c, map.get(c) + score - 4);
            }
        }

        // 지표별 두 유형 점수 비교하여 입력 
        for (int i=0; i< unit.length; i+=2){
            if (map.get(unit[i]) > map.get(unit[i+1])){
                answer += unit[i];
            } else if (map.get(unit[i]) < map.get(unit[i+1])){
                answer += unit[i+1];
            } else {
                char c = unit[i] > unit[i+1] ? unit[i+1] : unit[i];
                answer += c;
            }
        }

        return answer;
    }
}
