import java.util.*;
class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        List<Integer> l = new LinkedList<>();
        int[] d1 = new int[N+2];
        int[] d2 = new int[N+2];
        List<double[]> rate = new LinkedList<>();
        for(int i=0;i<stages.length;i++){
            int a = stages[i];
            for(int j=1;j<=a;j++){
                d2[j]++;
            }
            d1[a]++;
        }
        for(int i=1;i<=N;i++){
            System.out.println(d1[i]+" "+d2[i]);
            if(d2[i]==0) rate.add(new double[]{0,i});
            else
                rate.add(new double[] {(double)d1[i]/d2[i], i});
        }
        
        Collections.sort(rate, new Comparator<double[]>(){
            @Override
			public int compare(double[] o1, double[] o2) {
				if(o2[0]==o1[0])return Double.compare(o1[1], o2[1]);
                return Double.compare(o2[0], o1[0]);
			}
        });
        for(int i=0;i<rate.size();i++){
            l.add((int)rate.get(i)[1]);
        }
        
        
        answer = new int[l.size()];
        for(int i=0;i<l.size();i++){
            answer[i] = l.get(i);
        }
        return answer;
    }
}
