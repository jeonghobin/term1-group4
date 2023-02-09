package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Swea_1493 {
    public static void main(String[] args) throws IOException {

        Map<Integer, Map<Integer, Integer>> m = new HashMap<>();
        Map<Integer, Integer> t = new HashMap<>();
        t.put(1,1);
        m.put(1,t);
        int N = 270;
        int[][] data = new int[N][N];
        data[1][1] = 1;
        int right = 2, up = 1;
        for (int i = 1; i < N; i++) {
            int r = right;
            int u = up;
            for (int j = 1; j < N; j++) {
                if (i == 1 && j == 1) {
                    continue;
                }
                if (j == 1){
                    data[i][j] = data[i-1][j] + u;
                    t = new HashMap<>();
                    t.put(i, j);
                    m.put(data[i][j] , t);
                    continue;
                }
                data[i][j] = data[i][j-1] + r;
                t = new HashMap<>();
                t.put(i, j);
                m.put(data[i][j] , t);
                r++;
            }
            right++;
            if (i != 1) up++;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        for (int q = 1; q < tc + 1; q++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(q).append(" ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int x = 0, y = 0;
            Map<Integer, Integer> r1 = m.get(a);
            Map<Integer, Integer> r2 = m.get(b);

            for (Map.Entry<Integer, Integer> e : r1.entrySet()){
                x += e.getKey();
                y += e.getValue();
            }

            for (Map.Entry<Integer, Integer> e : r2.entrySet()){
                x += e.getKey();
                y += e.getValue();
            }
            sb.append(data[x][y]);
            System.out.println(sb);
        }
    }
}
