import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        int[][] singo = new int[id_list.length][id_list.length];
        
        for(int i=0;i<report.length;i++){
            String[] str = report[i].split(" ");
            int a=0;int b=0;
            for(int j=0;j<id_list.length;j++){
                if(str[0].equals(id_list[j])) a=j;
                if(str[1].equals(id_list[j])) b=j;
            }
            singo[a][b] = 1;
        }
        boolean[] v = new boolean[id_list.length];
        for(int i=0;i<id_list.length;i++){
            int cnt=0;
            for(int j=0;j<id_list.length;j++){
                if(singo[j][i]==1)cnt++;
            }
            if(cnt>=k)v[i]=true;
        }
        for(int i=0;i<id_list.length;i++){
            int cnt=0;
            for(int j=0;j<id_list.length;j++){
                if(v[j]&&singo[i][j]==1)cnt++;
            }
            list.add(cnt);
        }
        
        
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
