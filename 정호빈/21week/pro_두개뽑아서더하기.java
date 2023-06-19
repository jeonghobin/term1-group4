import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        Set<Integer> set = new TreeSet<>();
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                int num = numbers[i]+numbers[j];
                set.add(num);
            }
        }
        
        
        answer = new int[set.size()];
        int j=0;
        for(int i : set){
            answer[j++] = i;
        }
        Arrays.sort(answer);
        return answer;
    }
}
