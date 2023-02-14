package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2667 {


    static int[][] data;
    static Queue<Point> q;
    static boolean[][] v;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N, count;

    public static class Point{
        int x, y;

        public Point(int x, int y) {
            super();
            this.x = x;
            this.y = y;

        }

    }

    public static void bfs() {


        while(!q.isEmpty()) {
            Point p = q.poll();
            int x = p.x;
            int y = p.y;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(!v[nx][ny] && data[nx][ny] == 1) {
                        v[nx][ny] = true;
                        data[nx][ny] = 0;
                        q.offer(new Point(nx, ny));
                        count++;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());

        data = new int[N][N];
        v = new boolean[N][N];

        q = new LinkedList<Point>();

        int cnt = 0;
        for (int i = 0; i < N; i++) {
            String a = br.readLine();
            for (int j = 0; j < N; j++) {
                data[i][j] = a.charAt(j) - '0';
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (data[i][j] == 1) {
                    q.offer(new Point(i, j));
                    v[i][j] = true;
                    count = 1;
                    bfs();
                    list.add(count);
                    cnt++;
                }
            }
        }
        sb.append(cnt).append("\n");
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}
