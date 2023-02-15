package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_7699 {
    static char[][] data;
    static int R, C, max;
    static int[] dx = {0,1,0,-1}, v;
    static int[] dy = {1,0,-1,0};
    public static void recursive(int x, int y, int cnt){

        if (cnt >= 26){
            max = Math.max(max, cnt);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 1 && nx <= R && ny >= 1 && ny <= C){
                if (v[data[nx][ny] - 'A'] == 0){
                    v[data[nx][ny] - 'A'] = 1;
                    recursive(nx, ny, cnt + 1 );
                    v[data[nx][ny] - 'A'] = 0;
                }
            }
        }
        max = Math.max(max, cnt);
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            data = new char[R + 1][C + 1];
            v = new int[26];

            for (int i = 1; i < R + 1; i++) {
                String a = br.readLine();
                for (int j = 1; j < C + 1; j++) {
                    data[i][j] = a.charAt(j-1);
                }
            }
            v[data[1][1] - 'A'] = 1;
            max = - 1;
            recursive(1, 1, 1);

            sb.append(max).append("\n");
        }
        System.out.println(sb);
    }
}
//
//public class Solution {
//
//    static int[][] data;
//    static int R, C, max;
//    static int[] dx = {0,1,0,-1};
//    static int[] dy = {1,0,-1,0};
//    static int[] count;
//
//    public static void recursive(int x, int y, int cnt) {
//
//        max = Math.max(max, cnt);
//
//        if(cnt >= 26) return;
//
//        for (int i = 0; i < 4; i++) {
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if(nx >= 0 && nx < R && ny >= 0 && ny < C) {
//                if(count[data[nx][ny]] == 0) {
//                    count[data[nx][ny]] = 1;
//                    recursive(nx , ny, cnt + 1);
//                    count[data[nx][ny]] = 0;
//                }
//            }
//        }
//
//
//
//    }
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        StringBuilder sb = new StringBuilder();
//        int N = Integer.parseInt(st.nextToken());
//        for (int t = 1; t < N + 1; t++) {
//
//            sb.append("#").append(t).append(" ");
//
//            st = new StringTokenizer(br.readLine());
//
//            R = Integer.parseInt(st.nextToken());
//            C = Integer.parseInt(st.nextToken());
//
//            data = new int[R][C];
//            count = new int[91];
//
//            for (int i = 0; i < R; i++) {
//                String a = br.readLine();
//                for (int j = 0; j < C; j++) {
//                    data[i][j] = a.charAt(j);
//                }
//            }
//
//            count[data[0][0]] = 1;
//            max = -1;
//            recursive(0,0,1);
//            sb.append(max).append("\n");
//        }
//        System.out.println(sb);
//    }
//
//}