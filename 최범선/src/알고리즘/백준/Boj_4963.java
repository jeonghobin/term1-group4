package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_4963 {
    static int w, h;
    static int[][] data;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1,1,1,-1,-1};
    static int[] dy = {1,0,-1,0,1,-1,-1,1};


    public static void recursive(int x, int y){

        if (v[x][y]) return;
        v[x][y] = true;

        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < w && ny >= 0 && ny < h){
                if(!v[nx][ny] && data[nx][ny] == 1){
                    recursive(nx,ny);
                }
            }

        }


    }




    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true){
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            int cnt = 0;
            if ( w == 0 && h == 0) break;
            data = new int[w][h];
            v = new boolean[w][h];
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < h; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < w; i++) {
                for (int j = 0; j < h; j++) {
                    if (data[i][j] == 1 && !v[i][j]){
                        recursive(i, j);
                        cnt++;
                    }
                }
            }
            sb.append(cnt).append("\n");
        }
        System.out.println(sb);

    }
}
//public class Boj_4963 {
//
//    static int[][] data;
//    static boolean[][] v;
//    static int[] dx = {0,1,0,-1,-1,-1,1,1};
//    static int[] dy = {1,0,-1,0,-1,1,-1,1};
//    static int w, h;
//
//    public static class Pair{
//        int x, y;
//        public Pair(int x, int y) {
//            super();
//            this.x = x;
//            this.y = y;
//        }
//    }
//
//
//    public static void bfs(int x, int y) {
//
//        Queue<Pair> q = new LinkedList<Pair>();
//        q.offer(new Pair(x, y));
//        v[x][y] = true;
//
//        while(!q.isEmpty()) {
//            Pair p = q.poll();
//            for (int i = 0; i < 8; i++) {
//                int nx = p.x + dx[i];
//                int ny = p.y + dy[i];
//                if(nx >= 0 && nx < w && ny >= 0 && ny < h) {
//                    if(!v[nx][ny] && data[nx][ny] == 1) {
//                        v[nx][ny] = true;
//                        data[nx][ny] = 0;
//                        q.offer(new Pair(nx, ny));
//                    }
//                }
//            }
//        }
//    }
//
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        StringBuilder sb = new StringBuilder();
//
//        while(true) {
//            st = new StringTokenizer(br.readLine());
//            h = Integer.parseInt(st.nextToken());
//            w = Integer.parseInt(st.nextToken());
//
//            if (w == 0 && h == 0) {
//                System.out.println(sb);
//                return;
//            }
//
//            data = new int[w][h];
//            v = new boolean[w][h];
//
//
//            for (int i = 0; i < w; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < h; j++) {
//                    data[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//            int cnt = 0;
//            for (int i = 0; i < w; i++) {
//                for (int j = 0; j < h; j++) {
//                    if (data[i][j] == 1) {
//                        cnt++;
//                        bfs(i, j);
//                    }
//                }
//            }
//            sb.append(cnt).append("\n");
//        }
//    }
//}
