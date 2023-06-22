class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int lefthand=10;
        int righthand=11;
        int[][] posi = {{3,1},{0,0},{0,1},{0,2},{1,0},{1,1},{1,2}
                       ,{2,0},{2,1},{2,2},{3,0},{3,2}};
        for(int i=0;i<numbers.length;i++){
            if(numbers[i]==1||numbers[i]==4||numbers[i]==7){
                answer+="L";
                lefthand = numbers[i];
            }else if(numbers[i]==3||numbers[i]==6||numbers[i]==9){
                answer+="R";
                righthand = numbers[i];
            }else{
            int a = Math.abs(posi[numbers[i]][0]-posi[lefthand][0])
                +Math.abs(posi[numbers[i]][1]-posi[lefthand][1]);
            int b = Math.abs(posi[numbers[i]][0]-posi[righthand][0])
                +Math.abs(posi[numbers[i]][1]-posi[righthand][1]);
            if(a<b){
                answer+="L";
                lefthand = numbers[i];
            }else if(a>b){
                answer+="R";
                righthand= numbers[i];
            }else{
                if(hand.equals("right")){
                    answer+="R";
                    righthand= numbers[i];
                }else{
                    answer+="L";
                    lefthand= numbers[i];
                }
            }
            
        }
        }
        return answer;
    }
}
