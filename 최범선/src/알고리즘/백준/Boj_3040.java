package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_3040 {
    static int[] data;
    static int[] count;

    public static void combination(int cnt, int start, int sum){

        if (cnt == 7){
            if (sum == 100){
                for (int i = 0; i < 7; i++) {
                    System.out.println(count[i]);
                }
            }
            return;
        }
        for (int i = start; i < 9; i++) {
            count[cnt] = data[i];
            combination(cnt + 1, i + 1, sum + count[cnt]);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        data = new int[9];
        count = new int[7];

        for (int i = 0; i < 9; i++) {
            data[i] = Integer.parseInt(br.readLine());
        }
        combination(0, 0, 0);

    }
}
