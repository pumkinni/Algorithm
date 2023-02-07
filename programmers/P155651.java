import java.util.*;

class Solution {
    public class Guest{
        int startTime;
        int endTime;
        public Guest(String[] book){
            String[] sTime = book[0].split(":");
            String[] eTime = book[1].split(":");

            startTime = Integer.parseInt(sTime[0]) * 100 + Integer.parseInt(sTime[1]);
            endTime = Integer.parseInt(eTime[0]) * 100 + Integer.parseInt(eTime[1]) + 10;
            if (endTime % 100 >= 60){
                endTime += 40;
            }
        }
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        Guest[] guests = new Guest[book_time.length];
        int idx = 0;
        for (String[] book : book_time){
            guests[idx] = new Guest(book);
            idx++;
        }

        // 대기 손님 - 시작 시간 기준으로 오름차순 정렬
        Arrays. sort(guests, (x,y) -> x.startTime - y.startTime);

        // 사용 손님 - 종료 시간 기준으로 오름차순 pq
        PriorityQueue<Guest> use = new PriorityQueue<>((x,y) -> x.endTime - y.endTime);

        for (Guest book : guests){
            // 사용 손님이 없으면 다음 대기 손님 넣고
            // 사용 손님이 있으면 사용 손님의 종료 시간과 다음 대기 손님의 시작 시간 비교
            // 대기 손님의 시작 시간보다 사용 손님의 종료시간이 더 빠르면 제거
            while (!use.isEmpty() && use.peek().endTime <= book.startTime){
                use.poll();
            }
            use.offer(book);
            // 대기 손님을 사용 손님에 추가 후 사이즈 측정
            answer = Math.max(answer, use.size());
        }

        return answer;
    }
}
