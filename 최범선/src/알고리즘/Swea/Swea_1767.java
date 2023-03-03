package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1767 {

    static int[][] data;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N, max, core;


    public static class Pair{
        int x, y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }
    }
    public static void recursive(int idx, int cnt) {

        if (idx > core) {
            core = idx;
            max = cnt;
        }else if(idx == core) max = Math.min(max, cnt);
        int x = - 1, y = - 1;
        L :for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(data[i][j] == 1 && i != 0 && j !=0 && i != N-1 && j != N-1) {
                    for (int k = 0; k < 4; k++) {
                        if(check(i,j,k)) {
                            x = i;
                            y = j;
                            break L;
                        }
                    }
                }
            }
        }
        if(x==-1) return;

        for (int k = 0; k < 4; k++) {
            if(check(x, y, k)) {
                int t = draw(x, y, k, 2);
                data[x][y] = 2;
                recursive(idx + 1, cnt + t);

                draw(x, y, k, 0);
                data[x][y] = 1;
            }
        }
    }
    public static int draw(int x, int y, int d, int val) {
        int nx = x;
        int ny = y;
        int cnt = 0;
        while(true) {
            if(!(nx+dx[d] >= 0 && nx+dx[d] < N && ny+dy[d] >= 0 && ny+dy[d] < N)) break;
            cnt++;
            nx += dx[d];
            ny += dy[d];
            data[nx][ny] = val;
        }
        return cnt;
    }



    public static boolean check(int x, int y, int d) {
        int nx = x;
        int ny = y;
        while(true) {
            if((nx != x || ny != y) && data[nx][ny] != 0) return false;
            if(!(nx+dx[d] >= 0 && nx+dx[d] < N && ny+dy[d] >= 0 && ny+dy[d] < N)) break;
            nx += dx[d];
            ny += dy[d];
        }
        return true;

    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");

            N = Integer.parseInt(br.readLine());
            data = new int[N][N];

            core = -1;
            max = Integer.MAX_VALUE;

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            recursive(0, 0);

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}