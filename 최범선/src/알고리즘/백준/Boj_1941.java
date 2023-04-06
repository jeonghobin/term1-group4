package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_1941 {
    static int count, rsl;
    static char[][] data;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Pair[] temp;
    static boolean[] v;

    static class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public String toString() {
            return "Pair{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    public static void dfs(int idx){
        count++;
        v[idx] = true;

        int x = temp[idx].x;
        int y = temp[idx].y;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            for (int j = 0; j < 7; j++) {
                if(v[j]) continue;
                if(nx == temp[j].x && ny == temp[j].y){
                    dfs(j);
                }
            }
        }

    }
    public static void recursive(int idx, int cnt, int gang, Pair[] p){

        if(cnt == 7 && gang >= 4){
//            System.out.println(Arrays.toString(p));
            v = new boolean[7];
            temp = p;
            count = 0;
            dfs(0);
            if (count == 7) rsl++;
        }
        if(cnt >= 7) return;
        if (idx >= 25) return;


        for (int i = idx; i < 25; i++) {
            int x = i / 5;
            int y = i % 5;
            p[cnt] = new Pair(x, y);
            recursive(i + 1, cnt + 1, data[x][y] == 'S' ? gang + 1 : gang, p);
            p[cnt] = null;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        data = new char[5][5];

        for (int i = 0; i < 5; i++) {
            String a = br.readLine();
            for (int j = 0; j < 5; j++) {
                data[i][j] = a.charAt(j);
            }
        }
        recursive(0, 0, 0, new Pair[7]);
        System.out.println(rsl);
    }

    static void print(){
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(data[i][j]);
            }
            System.out.println();
        }
    }
}
