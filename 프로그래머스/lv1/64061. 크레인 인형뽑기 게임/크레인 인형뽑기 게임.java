import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        ArrayList<Stack<Integer>> list = new ArrayList<>();
        
        Stack<Integer> result = new Stack();
        
        for (int i=0; i<board.length; i++){
            list.add(new Stack());
        }
        
        for (int i=board.length-1; i>=0; i--){
            for (int j=0; j<board[0].length; j++){
                if (board[i][j] != 0){
                    list.get(j).add(board[i][j]);
                }
            }
        }
        
        for (int mo : moves){
            if (!list.get(mo-1).isEmpty()){
                int doll = list.get(mo-1).pop();

                if (result.isEmpty()){
                    result.push(doll);
                } else if (doll == result.peek()){
                    result.pop();
                    answer+=2;
                } else {
                    result.add(doll);
                }
            }
        }
        
        
        return answer;
    }
}