package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Boj_17135{

    static int R, C, D, count, max, N;
    static int[][] data;
    static ArrayList<Pair> p;

    public static class Pair{
        int x, y;

        public Pair(int x, int y) {
            super();
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Pair [x=" + x + ", y=" + y + "]";
        }
    }

    public static void attack(int[] sel) {

        ArrayList<Pair> temp = new ArrayList<>();
        for (Pair t : p) temp.add(new Pair(t.x, t.y));

        ArrayList<Pair> dead = new ArrayList<>();

        while(N > 0) {
            for (int k = 0; k < 3; k++) {
                int idx = -1 , min = Integer.MAX_VALUE;
                for (int j = 0; j < temp.size(); j++) {
                    Pair t = temp.get(j);
                    int dis = Math.abs(R - t.x) + Math.abs(sel[k] - t.y);
                    if (dis <= D) {
                        if (min > dis) {
                            min = dis;
                            idx = j;
                        }else if(min == dis) {
                            if (t.y < temp.get(idx).y) {
                                idx = j;
                            }
                        }
                    }
                }
                if (idx <= -1) continue;
                dead.add(temp.get(idx));
            }
            for (int i = 0; i < dead.size(); i++) {
                for (int j = 0; j < temp.size(); j++) {
                    if (dead.get(i) == temp.get(j)) {
                        temp.remove(j--);
                        count++;
                        N--;
                    }
                }
            }

            for (int i = 0; i < temp.size(); i++) {
                Pair t = temp.get(i);
                t.x++;
                if (t.x >= R) {
                    N--;
                    temp.remove(i--);
                }
            }
        }

    }


    public static void recursive(int cnt, int start, int[] sel) {

        if (cnt >= 3) {
            count = 0;
            N = p.size();
            attack(sel);
            max = Math.max(max , count);
            return;
        }
        for (int i = start; i < C; i++) {
            sel[cnt] = i;
            recursive(cnt + 1, i + 1, sel);
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        data = new int[R][C];
        p = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if(data[i][j] == 1) p.add(new Pair(i, j));
            }
        }

        max = Integer.MIN_VALUE;
        recursive(0, 0, new int[3]);

        System.out.println(max);
    }
}