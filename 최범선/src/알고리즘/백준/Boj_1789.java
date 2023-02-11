package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1789 {
    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long sum = 0;
        long max = -1;
        for (long i = 1; i <= N; i++) {
            sum += i;
            if (sum <= N){
                max = Math.max(max,i);
            }else{
                break;
            }
        }
        System.out.println(max);
    }
}
