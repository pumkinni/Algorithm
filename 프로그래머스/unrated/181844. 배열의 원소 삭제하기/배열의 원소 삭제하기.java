import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        int[] answer = {};
        List<Integer> answerList = new ArrayList();
        
        List<Integer> list = Arrays.stream(delete_list).boxed().collect(Collectors.toList());
        
        for (int a : arr){
            if (!list.contains(a)){
                answerList.add(a);
            }
        }
        
        return answerList.stream().mapToInt(i->i).toArray();

    }
}