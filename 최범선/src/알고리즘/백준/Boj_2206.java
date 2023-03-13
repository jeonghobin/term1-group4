package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Boj_2206 {
    static int[][] data;
    static boolean[][][] v;
    static int N, M, min;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static class Node{
        int x, y, cnt, flag;
        public Node(int x, int y, int cnt, int flag) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.flag = flag;
        }
    }

    public static void bfs(){

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(1, 1, 1, 0));

        while (!q.isEmpty()){
            Node t = q.poll();
            int x = t.x;
            int y = t.y;
            int flag = t.flag;
            if (x == N && y == M){
                min = t.cnt;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx < 1 || nx > N || ny < 1 || ny > M) continue;
                if (data[nx][ny] == 0 && !v[nx][ny][flag]){
                    v[nx][ny][flag] = true;
                    q.add(new Node(nx, ny, t.cnt + 1, flag));
                }else if (data[nx][ny] == 1 && flag == 0){
                    v[nx][ny][1] = true;
                    q.add(new Node(nx, ny, t.cnt + 1, 1));
                }


            }

        }


    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N + 1][M + 1];
        v = new boolean[N + 1][M + 1][2];


        for (int i = 1; i < N + 1; i++) {
            String a = br.readLine();
            for (int j = 1; j < M + 1; j++) {
                data[i][j] = a.charAt(j - 1) - '0';
            }
        }
        min = Integer.MAX_VALUE;
        bfs();
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }
}
