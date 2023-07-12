class Solution {
    public int solution(int[][] board) {
        int answer = 0;
        int xMax = board.length;
        int yMax = board[0].length;
        
        boolean[][] bomb = new boolean[xMax][yMax];
        
        for (int x=0; x < xMax; x++){
            for (int y=0; y < yMax; y++){
                if (board[x][y] == 1){
                    int xM = (x-1 < 0) ? x : x-1;
                    int xP = x+1 >= xMax ? x : x+1;
                    int yM = y-1 < 0 ? y : y-1;
                    int yP = y+1 >= yMax ? y : y+1;
                    
                    bomb[xM][y] = true;
                    bomb[xM][yM] = true;
                    bomb[xM][yP] = true;  
                
                    bomb[x][yM] = true;
                    bomb[x][y] = true;
                    bomb[x][yP] = true;
                    
                    bomb[xP][yM] = true;
                    bomb[xP][y] = true;
                    bomb[xP][yP] = true;
                }
            }
        }
            
        for (int x=0; x < xMax; x++){
            for (int y=0; y < yMax; y++){
                if (bomb[x][y] == false){
                    answer += 1;
                }
            }
        }
        return answer;
        }
    }