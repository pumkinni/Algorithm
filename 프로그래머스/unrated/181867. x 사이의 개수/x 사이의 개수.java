import java.util.*;

class Solution {
    public int[] solution(String myString) {
        int[] answer = {};
        return Arrays.stream(myString.split("x", -1)).mapToInt(i -> i.length()).toArray();
    }
}