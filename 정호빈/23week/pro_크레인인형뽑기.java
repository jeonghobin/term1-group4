import java.util.*;
class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        Stack<Integer>[] stk = new Stack[board[0].length];
        for(int i=0;i<board[0].length;i++){
            stk[i] = new Stack<Integer>();
        }
        for(int i=board.length-1;i>=0;i--){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!=0)stk[j].push(board[i][j]);
            }
        }
        Stack<Integer> rs = new Stack<>();
        for(int i=0;i<moves.length;i++){
            if(!stk[moves[i]-1].isEmpty()){
                if(rs.isEmpty())rs.push(stk[moves[i]-1].pop());
                else{
                    if(rs.peek()==stk[moves[i]-1].peek()){
                        rs.pop();
                        stk[moves[i]-1].pop();
                        answer+=2;
                    }else{
                        rs.push(stk[moves[i]-1].pop());
                    }
                }
            }
        }
        
        return answer;
    }
}
