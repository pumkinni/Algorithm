import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Double> widths = new ArrayList();

        while(k > 1){
            double tmp = k;
            if (k % 2 == 0){
                k /= 2;
            } else {
                k = k*3 + 1;
            }
            widths.add((k+tmp) / 2);
        }
        
        int all = widths.size();
        int idx = 0;
        for (int[] range : ranges){
            int start = range[0];
            int end = all + range[1];
            double sum = 0.0;
            if (start < end){
                for (int i = start; i < end; i++){
                    sum += widths.get(i);
                }
                answer[idx] = sum;
            } else if (start == end){
                answer[idx] = 0.0;
            } else {
                answer[idx] = -1.0;
            }
            idx++;
        }
        
        
        return answer;
    }
}
