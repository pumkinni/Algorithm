import java.util.*;

class Solution {
    public int[] solution(String[] maps) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];
        for (int i = 0; i < maps.length; i++){
            for (int j = 0; j < maps[0].length(); j++){
                if (maps[i].charAt(j) != 'X' && visited[i][j] == false){
                    list.add(dfs(maps, visited, j, i));
                }
            }
        }
        
        Collections.sort(list);
        
        if (list.size() == 0){
            list.add(-1);
        }
        
        return list.stream().mapToInt(i -> i).toArray();
    }
    
    public int dfs(String[] maps, boolean[][] visited, int x, int y){
        int[][] direction = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        
        int sum = 0;
        
        if (x < 0 || y < 0 || x >= visited[0].length || y >= visited.length ){
            return 0;
        }
        
        if (maps[y].charAt(x) == 'X'){
            return 0;
        }
        
        if (visited[y][x] == true){
            return 0;
        }
        
        visited[y][x] = true;
        
        sum = (int)maps[y].charAt(x) - '0';
        
        for (int[] dir : direction){
            int nextX = x + dir[0];
            int nextY = y + dir[1];
            sum += dfs(maps, visited, nextX, nextY);
        }
        
        return sum;
    }
}
