package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2596 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String a = br.readLine();
        String[] data_idx = {"A","B","C","D","E","F","G","H"};
        String[] data = {"000000","001111","010011","011100","100110","101001","110101","111010"};


        for (int i = 0; i < N; i++) {
            boolean flag = true;
            String temp = a.substring(6*i, 6*i+6);
            for (int j = 0; j < data.length; j++) {
                if(temp.equals(data[j])){
                    sb.append(data_idx[j]);
                    flag = false;
                    break;
                }
            }if (flag){
                int min = 1000001, index = -1;
                for (int j = 0; j < data.length; j++) {
                    int cnt = 0;
                    for (int k = 0; k < 6; k++) {
                        if (data[j].charAt(k) != temp.charAt(k)){
                            cnt++;
                        }
                    }
                    if (min > cnt){
                        min = cnt;
                        index = j;
                    }

                }
                if (min == 1){
                    sb.append(data_idx[index]);
                }else{
                    sb.delete(0,sb.length());
                    sb.append(i+1);
                    break;
                }
            }
        }
        System.out.println(sb);
    }
}
