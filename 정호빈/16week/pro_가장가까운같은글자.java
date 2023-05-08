import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        Map<Character,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<s.length();i++){
            char chr = s.charAt(i);
            int a = map.getOrDefault(chr,-1);
            
            if(a==-1){
                map.put(chr,i);
                list.add(-1);
            }else{
                int num = i-a;
                map.put(chr,i);
                list.add(num);
            }
        }
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i); 
        }
        return answer;
    }
}
