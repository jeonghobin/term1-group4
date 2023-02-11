package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_11047 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int data[] = new int[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            data[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(data);

        int cnt = 0, idx = N-1;
        while (K > 0){
            cnt += K / data[idx];
            K %= data[idx];
            idx--;
        }
        System.out.println(cnt);


    }
}
