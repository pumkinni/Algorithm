import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        Map<String, HashSet<String>> rep = new HashMap();
        Map<String, Integer> repCnt = new HashMap();
        
        for (String idAll : report){
            String[] ids = idAll.split(" ");
            if (!rep.containsKey(ids[0])){
                rep.put(ids[0], new HashSet());
            } 
            
            if (!rep.get(ids[0]).contains(ids[1])){
                repCnt.put(ids[1], repCnt.getOrDefault(ids[1], 0) + 1);
                
            }
            
            rep.get(ids[0]).add(ids[1]);
            
        }
        
        // id_list를 돌면서 각 아이디가 신고한 id의 신고처리 개수를 반환
        int idx = 0;
        for (String id : id_list){
            int cnt = 0;
            if (!rep.containsKey(id)){
                answer[idx] = 0;
            } else {
                for (String repId : rep.get(id)){
                    if (repCnt.get(repId) >= k){
                        cnt++;
                    }
                }
                answer[idx] = cnt; 
            }
            idx++;
        }
        return answer;
    }
}
