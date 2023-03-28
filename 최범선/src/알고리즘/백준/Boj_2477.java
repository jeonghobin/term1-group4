package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2477 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int k = Integer.parseInt(br.readLine());
        int[][] data = new int[6][2];
        int[] cnt = new int[5];
        for (int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());
            data[i][0] = Integer.parseInt(st.nextToken());
            data[i][1] = Integer.parseInt(st.nextToken());

            cnt[data[i][0]]++;
        }

        int big = 1;
        int small = 1;
        for (int i = 0; i < 6; i++) {
            if(cnt[data[i][0]] == 1) {
                big *= data[i][1];
                continue;
            }

            int n = (i+1) % 6;
            int nn = (i+2) % 6;

            if(data[i][0] == data[nn][0]) small *= data[n][1];
        }
        System.out.println(k*(big-small));
    }
}
