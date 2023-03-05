package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_16236{
    static class Pair{
        int x, y, dist;
        public Pair(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    static int N, MinTime = - 1;
    static int[][] data;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};


    public static void recursive(int x, int y, int size, int cnt, int time) {

        int R = -1, C = -1;
        int MinDist = Integer.MAX_VALUE;

        boolean[][] v = new boolean[N][N];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(x, y, 0));
        v[x][y] = true;

        while (!q.isEmpty()) {
            Pair t = q.poll();
            int r = t.x;
            int c = t.y;
            if(t.dist > MinDist) break;
            if(data[r][c] >= 1 && data[r][c] <= 6){
                if(data[r][c] < size){
                    if(t.dist < MinDist){
                        MinDist = t.dist;
                        R = r;
                        C = c;
                    }else if(t.dist == MinDist){
                        if(t.x < R){
                            R = t.x;
                            C = t.y;
                        }else if(t.x == R){
                            if (t.y < C){
                                C = t.y;
                            }
                        }
                    }
                }
                }
            for (int i = 0; i < 4; i++) {
                int nx = r + dx[i];
                int ny = c + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if (!v[nx][ny] && data[nx][ny] <= size) {
                        v[nx][ny] = true;
                        q.add(new Pair(nx, ny, t.dist + 1));
                    }
                }
            }
        }
        if (R == -1) {
            System.out.println(time);
            return;
        }
        cnt++;
        if (size == cnt) {
            size++;
            cnt = 0;
        }
        data[R][C] = 0;
        recursive(R, C, size, cnt, time + MinDist);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        data = new int[N][N];

        int x = -1, y = -1;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if(data[i][j] == 9){
                    data[i][j] = 0;
                    x = i;
                    y = j;
                }
            }
        }
        recursive(x, y, 2, 0, 0);


    }
}
