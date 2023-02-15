package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1861{

    static int N, max, val;
    static int[][] data;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static void dfs(int x , int y, int cnt){

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < N && ny >= 0 && ny < N){
                if((data[x][y]-1) == data[nx][ny]){
                    v[nx][ny] = true;
                    dfs(nx, ny, cnt + 1);
                }
            }
        }
        if (cnt > max){
            max = cnt;
            val = data[x][y];
        }else if (cnt == max) val = Math.min(val, data[x][y]);


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");

            N = Integer.parseInt(br.readLine());
            data = new int[N][N];
            v = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            max = -1;
            val = -1;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!v[i][j]){
                        v[i][j] = true;
                        dfs(i,j,1);
                    }
                }
            }
            sb.append(val).append(" ").append(max).append("\n");
        }
        System.out.println(sb);
    }

}



//public class Swea_1861 {
//
//    static int[][] data;
//    static int max, N, val;
//    static int[] dx = {0,1,0,-1};
//    static int[] dy = {1,0,-1,0};
//    static boolean[][] v;
//
//
//    public static void dfs(int x , int y, int cnt, int start) {
//        if (cnt >= max) {
//            if (cnt > max) {
//                max = cnt;
//                val = start;
//            }else val = Math.min(val, start);
//        }
//        if (cnt >= N*N) return;
//
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
//                if(data[x][y] + 1 == data[nx][ny] && !v[nx][ny]) {
//                    v[nx][ny] = true;
//                    dfs(nx, ny, cnt + 1,start);
//                }
//            }
//        }
//    }
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//
//        int tc = Integer.parseInt(st.nextToken());
//
//        for (int t = 1; t < tc + 1; t++) {
//            sb.append("#").append(t).append(" ");
//            N = Integer.parseInt(br.readLine());
//            data = new int[N][N];
//            v = new boolean[N][N];
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < N; j++) {
//                    data[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//
//            max = -1;
//            val = -1;
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < N; j++) {
//                    if (!v[i][j]){
//                        v[i][j] = true;
//                        dfs(i, j, 1, data[i][j]);
//                    }
//                }
//            }
//
//            sb.append(val).append(" ").append(max).append("\n");
//        }
//        System.out.println(sb);
//    }
//}