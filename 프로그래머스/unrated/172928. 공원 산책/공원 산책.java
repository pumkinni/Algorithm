class Solution {
    static int finalX;
    static int finalY;
    static int[][] direct;
    static String[] parks;
    
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        parks = park;
        direct = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0,1}};
        
        roop:
        for (int i=0; i<park.length; i++){
            for (int j=0; j<park[i].length(); j++){
                if (park[i].charAt(j) == 'S'){
                    finalX = i;
                    finalY = j;
                    find(i, j, routes, 0);
                    break roop;
                }
            }
        }
        return new int[]{finalX, finalY};
    }
    
    public void find(int x, int y, String[] routes, int idx){
        if (idx == routes.length){
            return;
        }
        
        String[] route = routes[idx].split(" ");
        int cnt = Integer.parseInt(route[1]);
        int[] dir;
        
        if (route[0].equals("N")){
            dir = direct[0];
        } else if (route[0].equals("S")){
            dir = direct[1];
        } else if (route[0].equals("W")){
            dir = direct[2];
        } else {
            dir = direct[3];
        }
        
        int newX = x + dir[0] * cnt;
        int newY = y + dir[1] * cnt;
        
        if (newX < 0 || newY < 0 || newX >= parks.length || newY >= parks[0].length()){
            find(x, y, routes, idx+1);
            return;
        }
        
        newX = x;
        newY = y;
        
        for (int i=0 ; i<cnt; i++){
            newX += dir[0];
            newY += dir[1];
            
            if (parks[newX].charAt(newY) == 'X'){
                find(x, y, routes, idx+1);
                return;
            }
        }
        
        finalX = newX;
        finalY = newY;
        
        find(newX, newY, routes, idx+1);
    }
}