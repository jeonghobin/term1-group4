package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15650 {

    static int N, M;
    static int[] data;
    static StringBuilder sb;

    public static void recursive(int cnt, int start){

        if (cnt >= M){
            for (int i = 0; i < data.length; i++) {
                sb.append(data[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < N + 1; i++) {
            data[cnt] = i;
            recursive(cnt + 1, i + 1);
        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[M];
        sb = new StringBuilder();

        recursive(0,1);
        System.out.println(sb);

    }
}
