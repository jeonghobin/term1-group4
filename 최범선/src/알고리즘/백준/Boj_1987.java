package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1987 {

    static int[][] data;
    static boolean[] v;
    static int R, C, max;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void dfs(int x, int y, int cnt){

        max = Math.max(max, cnt);
        if(cnt >= 26) return;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < R && ny >= 0 && ny <C){
                if(!v[data[nx][ny]]){
                    v[data[nx][ny]] = true;
                    dfs(nx, ny, cnt + 1);
                    v[data[nx][ny]] = false;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        data = new int[R][C];
        v = new boolean[91];
        max = - 1;

        for (int i = 0; i < R; i++) {
            String a = br.readLine();
            for (int j = 0; j < C; j++) {
                data[i][j] = a.charAt(j) - 'A';
            }
        }
        v[data[0][0]] = true;
        dfs(0,0, 1);

        System.out.println(max);
    }
}
