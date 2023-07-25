import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        boolean[] v = new boolean[n+1];
        boolean[] v2 = new boolean[n+1];
        for(int i=0;i<lost.length;i++){
            v2[lost[i]]=true;
        }
        for(int i=0;i<reserve.length;i++){
            v[reserve[i]]=true;
        }
        answer = n-lost.length;
        Arrays.sort(lost);
        Arrays.sort(reserve);
        for(int i=0;i<lost.length;i++){
            int a = lost[i];
            if(v2[a]&&v[a]){
                answer++;
                v[a]=false;
                continue;
            }
            if(a-1>0&&v[a-1]&&!v2[a-1]){
                answer++;
                v[a-1]=false;
                continue;
            }
            if(a+1<n+1&&v[a+1]&&!v2[a+1]){
                answer++;
                v[a+1]=false;
            }
        }
        
        
        return answer;
    }
}
