class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        int[][] direct = {{0,1},{1,0},{0,-1},{-1,0}};
        
        int x = 0;
        int y = 0;
        int dirIdx = 0;
        int[] dir;
        
        answer[x][y] = 1;
        
        
        for (int i=2; i<=n*n; i++){
            dir = direct[dirIdx];
            
            int newX = x + dir[0];
            int newY = y + dir[1];
            
            if (newX >= n || newX < 0 || newY < 0 || newY >= n || answer[newX][newY] != 0){
                dirIdx = (dirIdx + 1) % 4;
            }
            
            dir = direct[dirIdx];
            
            x += dir[0];
            y += dir[1];
            answer[x][y] = i;
        }
        
        return answer;
    }
}