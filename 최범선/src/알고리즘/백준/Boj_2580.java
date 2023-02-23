package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2580 {
    static int[][] data;
    static ArrayList<Pair> p;
    static StringBuilder sb;
    public static class Pair{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void recursive(int idx){

        if (idx >= p.size()){
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(data[i][j]).append(" ");
                }
                sb.append("\n");
            }
            System.out.println(sb);
            System.exit(0);
        }
        Pair t = p.get(idx);
        int x = t.x;
        int y = t.y;

        for (int i = 1; i < 10; i++) {
            if(!check(x, y, i)) continue;
            data[x][y] = i;
            recursive(idx + 1);
            data[x][y] = 0;
        }
    }
    public static boolean check(int x, int y, int val){

        for (int i = 0; i < 9; i++) {
            if(data[i][y] == val) return false;
        }
        for (int i = 0; i < 9; i++) {
            if(data[x][i] == val) return false;
        }
        for (int i = 3*(x/3); i < 3*(x/3) + 3; i++) {
            for (int j = 3*(y/3); j < 3*(y/3) + 3; j++) {
                if(data[i][j] == val) return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        data = new int[9][9];
        p = new ArrayList<>();
        sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] == 0) p.add(new Pair(i, j));
            }
        }
        recursive(0);
    }
}
