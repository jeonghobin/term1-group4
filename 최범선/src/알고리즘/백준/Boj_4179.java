package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_4179 {
    static int R, C, max;
    static int[][] data;
    static boolean[][][] v;
    static Queue<Pair> q;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};


    static class Pair{
        int x, y, time;
        public Pair(int x, int y, int time) {
            super();
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }

    public static void bfs() {

        while(!q.isEmpty()) {

            Pair t = q.poll();
            int x = t.x;
            int y = t.y;
//            System.out.println(x + " " + y);
            if ((x < 1 || x > R) || (y < 1 || y > C)) {
                if(data[x][y] == 1) {
                    max = t.time;
                    return;
                }
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || nx > R + 1 || ny < 0 || ny > C + 1) continue;

                if (data[x][y] == 2) {
                    if (nx < 1 || nx > R || ny < 1 || ny > C) continue;
                    if(data[nx][ny] != -1 && data[nx][ny] != 2 && !v[nx][ny][1]) {
                        v[nx][ny][1] = true;
                        data[nx][ny] = 2;
                        q.add(new Pair(nx, ny, t.time + 1));
                    }
                }else if(data[x][y] == 1) {
                    if(data[nx][ny] == 0 && !v[nx][ny][0]) {
                        v[nx][ny][0] = true;
                        data[nx][ny] = 1;
                        q.add(new Pair(nx, ny, t.time + 1));
                    }
                }
            }
//            for (int i = 0; i < R + 2; i++) {
//                for (int j = 0; j < C + 2; j++) {
//                    System.out.print(data[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        data = new int[R + 2][C + 2];
        v = new boolean[R + 2][C + 2][2];
        q = new LinkedList<>();
        for (int i = 1; i < R + 1; i++) {
            String a = br.readLine();
            for (int j = 1; j < C + 1; j++) {
                char t = a.charAt(j-1);
                if (t == '#') data[i][j] = -1;
                else if (t == 'J') {
                    q.add(new Pair(i, j, 0));
                    v[i][j][0] = true;
                    data[i][j] = 1;
                }
                else if (t == 'F') {
                    data[i][j] = 2;
                }
            }
        }

        for (int i = 1; i < R + 1; i++) {
            for (int j = 1; j < C + 1; j++) {
                if (data[i][j] == 2) {
                    v[i][j][1] = true;
                    q.add(new Pair(i, j, 0));
                }
            }
        }
        max = -1;
        bfs();

        System.out.println(max == -1 ? "IMPOSSIBLE" : max);


    }

}