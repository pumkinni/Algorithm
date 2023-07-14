import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        
        Map<String, Integer> playerMap = new HashMap();
        Map<Integer, String> indexMap = new HashMap();
        
        for (int i=0; i < players.length; i++){
            playerMap.put(players[i], i);
            indexMap.put(i, players[i]);
        }
        
        for (String call : callings){
            int index = playerMap.get(call);
            playerMap.put(call, index-1);
            String swapPlayer = indexMap.get(index-1);
            playerMap.put(swapPlayer, index);
            indexMap.put(index, swapPlayer);
            indexMap.put(index-1, call);
        }
        
        for (Map.Entry<Integer, String> entry: indexMap.entrySet()){
            answer[entry.getKey()] = entry.getValue();
        }
        
        return answer;
    }
}