package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1697 {
    static int a, b, max;
    static int[] v;

    public static class Pair{
        int x, cnt;
        public Pair(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
    }
    public static void bfs(int idx){

        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(idx, 0));
        v[idx] = 1;
        while (!q.isEmpty()){
            Pair t = q.poll();
            if(t.x==b) {
                System.out.println(t.cnt);
                break;
            }
            if(2 * t.x <= 100000 && v[2 * t.x] == 0){
                v[2 * t.x] = 1;
                q.add(new Pair(2 * t.x, t.cnt + 1));
            }
            if(t.x + 1 <= b && v[t.x+1] == 0) {
                v[t.x + 1] = 1;
                q.add(new Pair(t.x + 1, t.cnt + 1));
            }
            if(t.x - 1 >= 0 && v[t.x-1] == 0) {
                v[t.x - 1] = 1;
                q.add(new Pair(t.x - 1, t.cnt + 1));
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        v = new int[100001];
        bfs(a);


    }
}
