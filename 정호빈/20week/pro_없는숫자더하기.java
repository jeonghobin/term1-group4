class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        boolean[] v = new boolean[10];
        for(int i=0;i<numbers.length;i++){
            v[numbers[i]]=true;
        }
        for(int i=0;i<10;i++){
            if(!v[i]) answer+=i;
        }
        return answer;
    }
}
