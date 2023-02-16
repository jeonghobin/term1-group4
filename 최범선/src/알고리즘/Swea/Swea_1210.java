package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1210 {
    static int[][] data;
    static boolean[][] v;
    static int[] d = {-1,1};

    public static boolean run(int x, int y){
        while (x < 100){
            v[x][y] = true;
            while (y + d[0] >= 0 && data[x][y+d[0]] == 1 && !v[x][y+d[0]]) {
                y += d[0];
            }
            while (y + d[1] < 100 && data[x][y+d[1]] == 1 && !v[x][y+d[1]]) {
                y += d[1];
            }
            if(data[x][y] == 2) return true;
            x++;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t < 11; t++) {
            sb.append("#").append(t).append(" ");
            String a = br.readLine();

            data = new int[101][101];

            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    data[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < 100; i++) {
                if (data[0][i] == 1){
                    v = new boolean[101][101];
                    if(run(0, i)) {
                        sb.append(i).append("\n");
                        break;
                    }
                }
            }
        }
        System.out.println(sb);

    }
}
