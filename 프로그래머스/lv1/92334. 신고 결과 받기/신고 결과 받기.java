import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> reports = new HashMap();
        Map<String, Set<String>> nameReport = new HashMap();
        for (String id : id_list){
            nameReport.put(id, new HashSet());
        }
        
        
        for (String names : report){
            String name = names.split(" ")[0];
            String re = names.split(" ")[1];
            
            if (!nameReport.get(name).contains(re)){
                reports.put(re, reports.getOrDefault(re, 0) + 1);
                nameReport.get(name).add(re);  
            }
            
        }
        
        int idx=0;
        
        for (String id : id_list){
            int cnt = 0;
            for (String name : nameReport.get(id)){
                if (reports.get(name) >= k){
                    cnt++;
                }
            }
            answer[idx++] = cnt;
        }
        return answer;
    }
}