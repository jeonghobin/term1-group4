package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_10162 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] data = {300, 60, 10};

        if (N % 10 != 0){
            System.out.println(-1);
            return;
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(N / data[i] + " ");
            N %= data[i];
        }


    }
}
