package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_11399 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] a = br.readLine().split(" ");
        int[] data = new int[N];
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(a[i]);
        }
        Arrays.sort(data);
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            int temp = 0;
            for (int j = 0; j < i + 1 ; j++) {
                temp += data[j];
            }
            sum += temp;
        }
        System.out.println(sum);
    }
}

