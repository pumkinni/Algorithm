import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int[] left = {1,3};
        int[] right = {1,3};
        List leftList = new ArrayList();
        List rightList = new ArrayList();
        List middle = new ArrayList();
        
        leftList.add(1);
        leftList.add(4);
        leftList.add(7);
        rightList.add(3);
        rightList.add(6);
        rightList.add(9);
        middle.add(2);
        middle.add(5);
        middle.add(8);
        middle.add(0);
        
        for (int num : numbers){
            
            if (leftList.contains(num)){
                left[1] = leftList.indexOf(num);
                left[0] = 1;
                answer += "L";
            } else if (rightList.contains(num)){
                right[1] = rightList.indexOf(num);
                right[0] = 1;
                answer += "R";
            } else {
                int mid = middle.indexOf(num);
                if (Math.abs(mid - left[1]) + left[0] > Math.abs(mid - right[1]) + right[0]){
                    answer += "R";
                    right[1] = mid;
                    right[0] = 0;
                } else if (Math.abs(mid - left[1]) + left[0] < Math.abs(mid - right[1]) + right[0]){
                    answer += "L";
                    left[1] = mid;
                    left[0] = 0;
                } else {
                    if (hand.equals("right")){
                        answer += "R";
                        right[1] = mid;
                        right[0] = 0;
                    } else {
                        answer += "L";
                        left[1] = mid;
                        left[0] = 0;
                    }
                }
            }
        }
        
        
        return answer;
    }
}