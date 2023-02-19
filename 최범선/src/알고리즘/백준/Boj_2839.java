package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2839 {
    static int min;
    public static void Search(int n, int cnt){

        if (n % 3 == 0){
            min = Math.min(min, cnt + n / 3);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        min = 5001;
        int count = N / 5;

        for (int i = 0; i <= count; i++) {
            Search(N - i * 5, i);
        }
        if (min == 5001) System.out.println(-1);
        else System.out.println(min);
    }
}

