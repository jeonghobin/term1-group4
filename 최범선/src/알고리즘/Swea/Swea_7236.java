package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_7236 {

    static int N, max;
    static String[][] data;
    static int[] dx = {0,1,0,-1,1,1,-1,-1};
    static int[] dy = {1,0,-1,0,1,-1,-1,1};

    public static void check(int x, int y){

        int cnt = 0;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                if (data[nx][ny].equals("W")) cnt++;
            }
        }
        cnt = (cnt == 0) ? 1 : cnt;
        max = Math.max(max, cnt);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");

            N = Integer.parseInt(br.readLine());
            max = Integer.MIN_VALUE;
            data = new String[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = st.nextToken();
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (data[i][j].equals("G")) continue;
                    check(i, j);
                }
            }
            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}

