package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10163 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] data = new int[1002][1002];


        for (int i = 1; i < N + 1; i++) {
            String[] a = br.readLine().split(" ");

            for (int j = Integer.parseInt(a[1]); j < Integer.parseInt(a[1]) + Integer.parseInt(a[3]); j++) {
                for (int k = Integer.parseInt(a[0]); k < Integer.parseInt(a[0]) + Integer.parseInt(a[2]); k++) {
                    data[j][k] = i;
                }
            }
        }
        for (int i = 1; i < N + 1; i++) {
            int cnt = 0;
            for (int j = 0; j < 1002; j++) {
                for (int k = 0; k < 1002; k++) {
                    if (data[j][k] == i) cnt ++ ;
                }
            }
            System.out.println(cnt);
        }
    }
}
