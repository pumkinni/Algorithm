class Solution {
    public int[] solution(String[] wallpaper) {
        
        int xMin = wallpaper.length+1;
        int yMin = wallpaper[0].length()+1;
        int xMax = 0;
        int yMax = 0;
        
        int idx = -1;
        
        for (String paper : wallpaper){
            idx++;
            if (paper.indexOf("#") < 0){
                continue;
            }
            
            xMin = Math.min(xMin, idx);
            xMax = Math.max(xMax, idx);
            for (int i = 0; i < yMin; i++){
               if (paper.charAt(i) == '#'){
                   yMin = i;
               }
            }
            
            for (int i = yMax; i < paper.length(); i++){
               if (paper.charAt(i) == '#'){
                   yMax = i;
               }
            }
        }
        
        return new int[]{xMin, yMin, xMax+1, yMax+1};
    }
}