import java.util.*;
class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = {};
        List<Integer> list = new ArrayList<Integer>();
        
        for(int i=0;i<photo.length;i++){
            int sum = 0;
            for(int j=0;j<photo[i].length;j++){
                String str = photo[i][j];
                for(int k=0;k<name.length;k++){
                    if(str.equals(name[k])){
                        sum+=yearning[k];
                    }
                }
            }
            list.add(sum);
        }
        
        
        
        
        answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }
        return answer;
    }
}
