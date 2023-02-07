package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_15649 {
    static int N, M;
    static int[] data;
    static boolean[] v;
    static StringBuilder sb;
    private static void recursive(int cnt) {

        if (cnt >= M){
            for (int i = 0; i < data.length; i++) {
                sb.append(data[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if(v[i]) continue;
            data[cnt] = i;
            v[i] = true;
            recursive(cnt + 1);
            v[i] = false;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        data = new int[M];
        v = new boolean[N + 1];
        sb = new StringBuilder();
        recursive(0);
        System.out.println(sb);
    }

}

