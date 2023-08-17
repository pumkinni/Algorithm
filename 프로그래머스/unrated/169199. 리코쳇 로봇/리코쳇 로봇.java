import java.util.*;

class Solution {
    static int[][] direct;
    static String[] boards;
    static int row;
    static int answer;
    
    public int solution(String[] board) {
        answer = Integer.MAX_VALUE;
        boards = board;
        row = boards.length;
        
        
        int[][] visit = new int[row][board[0].length()];
        int[] r = new int[2];
        
        direct = new int[][]{{0,1}, {1,0}, {-1,0}, {0,-1}};
        
        // R의 위치 찾기
        for (int i=0; i<row; i++){
            if (board[i].contains("R")){
                r = new int[]{i, board[i].indexOf("R")};
                break;
            }
        }
        
        visit[r[0]][r[1]] = Integer.MAX_VALUE;
        
        dfs(r[0], r[1], 0, visit);
        
        if (answer>=Integer.MAX_VALUE){
            return -1;
        }
        
        return answer;
        
    }
        
    public void dfs(int x, int y, int cnt, int[][] visit){

        if (cnt >= answer){
            return;
        }
            
        if (x < 0 || y <0 || x >= row || y >= boards[0].length()){
            return;
        }
        
        if (visit[x][y] != 0 && visit[x][y] < cnt) {
            return;
        } 
            
        if (boards[x].charAt(y) == 'D'){
            return;
        }
                
        if (boards[x].charAt(y) == 'G'){
            answer = Math.min(answer, cnt);
            return;
        }
        
        visit[x][y] = cnt;
            
        for (int[] dir : direct){
            int newX = dir[0] + x;
            int newY = dir[1] + y;
            int move = 0;
            while (true){
                if (newX < 0 || newY <0 || newX >= row || newY >= boards[0].length()){
                    break;
                }
                if (boards[newX].charAt(newY) == 'D'){
                    break;
                }
                move++;
                newX += dir[0];
                newY += dir[1];
            }

            if (move == 0){
                continue;
            }
            
            newX -= dir[0];
            newY -= dir[1];
            dfs(newX, newY, cnt+1, visit);
        }
        
    }      
}