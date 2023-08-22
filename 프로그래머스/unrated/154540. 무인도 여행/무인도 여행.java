import java.util.*;

class Solution {
    static int[][] direct = new int[][]{{0,1}, {1,0}, {0,-1}, {-1,0}};
    static boolean [][] visited;
    static int n;
    static int m;
    static String[] map;
    
    public int[] solution(String[] maps) {
        int[] answer = {};
        n = maps.length;
        m = maps[0].length();

        map = maps;
        
        visited = new boolean[n][m];
        
        List<Integer> list = new ArrayList();
        
        
        for (int i=0; i<n; i++){
            for (int j=0; j<m; j++){
                if (!visited[i][j] && maps[i].charAt(j) != 'X'){
                    list.add(dfs(i, j));
                }
            }
        }
        
        if (list.size() == 0){
            return new int[]{-1};
        }
        
        answer = new int[list.size()];
        
        int idx = 0;
        
        for (int i : list){
            answer[idx++] = i;
        }
        
        Arrays.sort(answer); 
        
        return answer;
    }
    
    public Integer dfs(int x, int y){
        int sum = 0;
        
        Queue<int[]> queue = new LinkedList();
        
        queue.offer(new int[]{x,y});
        
        while (!queue.isEmpty()){
            int[] cur = queue.poll();
            
            if (visited[cur[0]][cur[1]]){
                continue;
            }
            
            sum += (Integer.valueOf(map[cur[0]].charAt(cur[1])) - Integer.valueOf('0'));
            
            visited[cur[0]][cur[1]] = true;
            
            for (int[] dir : direct){
                int newX = cur[0] + dir[0];
                int newY = cur[1] + dir[1];
                
                if (newX < 0 || newY < 0 || newX >= n || newY >= m 
                    || visited[newX][newY] || map[newX].charAt(newY) == 'X'){
                    continue;
                }
                queue.offer(new int[]{newX, newY});
            }
        }
        
        
        return sum;  
        
    }
}