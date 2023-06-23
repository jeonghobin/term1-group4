import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] answer = {};
        List<Integer> list = new ArrayList<>();
        
        int[] sufo1 = {1,2,3,4,5};
        int[] sufo2 = {2,1,2,3,2,4,2,5};
        int[] sufo3 = {3,3,1,1,2,2,4,4,5,5};
        int[] cnt=new int[3];
        for(int i=0;i<answers.length;i++){
            if(answers[i]==sufo1[i%sufo1.length])cnt[0]++;
            if(answers[i]==sufo2[i%sufo2.length])cnt[1]++;
            if(answers[i]==sufo3[i%sufo3.length])cnt[2]++;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            max = Math.max(max,cnt[i]);
        }
        for(int i=0;i<3;i++){
            if(max==cnt[i])list.add(i+1);
        }
        
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
