package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3109 {
    static int R, C;
    static char[][] data;
    static boolean[][] v;
    static int[] dx = {-1, 0, 1};

    public static boolean dfs(int x, int idx){
        if (idx >= C - 1){
            v[x][idx] = true;
//            for (int i = 0; i < R; i++) {
//                for (int j = 0; j < C; j++) {
//                    System.out.print(v[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
            return true;
        }
        if(v[x][idx]) return false;
        v[x][idx] = true;

        for (int i = 0; i < 3; i++) {
            int nx = x + dx[i];
            int ny = idx + 1;
            if(nx >= 0 && nx < R){
                if(data[nx][ny] == '.' && !v[nx][ny]){
                    if(dfs(nx,idx + 1)) return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        data = new char[R][C];
        v = new boolean[R][C];
        int cnt = 0;

        for (int i = 0; i < R; i++) {
            String a = br.readLine();
            for (int j = 0; j < C; j++) {
                data[i][j] = a.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            if(data[i][0] != '.')continue;
            if(dfs(i, 0)) cnt++;
        }
        System.out.println(cnt);
    }
}
