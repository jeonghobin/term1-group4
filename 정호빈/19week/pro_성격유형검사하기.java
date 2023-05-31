import java.util.*;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        int[] alp = new int[26];
        for(int i=0;i<survey.length;i++){
            char[] chr = survey[i].toCharArray();
            if(choices[i]>4){
                alp[chr[1]-'A']+=choices[i]-4;
            }else{
                alp[chr[0]-'A']+=4-choices[i];
            }
        }
        if(alp['R'-'A']>=alp['T'-'A']){
            answer+='R';
        }else{
            answer+='T';
        }
        if(alp['C'-'A']>=alp['F'-'A']){
            answer+='C';
        }else{
            answer+='F';
        }
        if(alp['J'-'A']>=alp['M'-'A']){
            answer+='J';
        }else{
            answer+='M';
        }
        if(alp['A'-'A']>=alp['N'-'A']){
            answer+='A';
        }else{
            answer+='N';
        }
        
        return answer;
    }
}
