package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_15686 {
    static int[][] data;
    static Chicken[] count;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N, K, res, max;
    static ArrayList<Chicken> c;
    public static class Chicken{
        int x, y, level;
        public Chicken(int x, int y, int level) {
            this.x = x;
            this.y = y;
            this.level = level;
        }
        @Override
        public String toString() {
            return "Chicken{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
    public static void bfs(){

        Queue<Chicken> q = new LinkedList<>();
        int cnt = 0, dis = 0;
        boolean[][] v = new boolean[N][N];
        for (int i = 0; i < K; i++) {
            q.offer(new Chicken(count[i].x, count[i].y, count[i].level));
        }
        while (!q.isEmpty()){
            Chicken t = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = t.x + dx[i];
                int ny = t.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N){
                    if (v[nx][ny]) continue;
                    v[nx][ny] = true;
                    q.add(new Chicken(nx , ny , t.level + 1));
                    if (data[nx][ny] == 1){
                        cnt++;
                        dis += t.level + 1;
                    }
                }
            }
            if (cnt >= max) {
                res = Math.min(res, dis);
                return;
            }
        }
    }

    public static void combination(int cnt, int start){
        if (cnt == K){
            bfs();
            return;
        }
        for (int i = start; i < c.size(); i++) {
            count[cnt] = new Chicken(c.get(i).x , c.get(i).y, c.get(i).level);
            combination(cnt + 1, i + 1);
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        data = new int[N][N];
        count = new Chicken[K];
        c = new ArrayList<>();
        max = 0;
        res = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 2) c.add(new Chicken(i, j, 0));
                else if(data[i][j] == 1) max++;
            }
        }
        combination(0,0);

        System.out.println(res);

    }
}

