package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_9229 {

    static int N, M, max;
    static int[] data, sel;

    public static void combination(int cnt, int start){

        if (cnt == 2){
            if(sel[0] + sel[1] <= M) max = Math.max(max, sel[0] + sel[1]);
            return;
        }


        for (int i = start; i < N; i++) {
            sel[cnt] = data[i];
            combination(cnt + 1 , i + 1);
        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            data = new int[N];
            sel = new int[2];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
            }
            max = -1;
            combination(0,0);
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}

