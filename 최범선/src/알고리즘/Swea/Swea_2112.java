package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_2112 {

    static int R, C, K, rsl;
    static int[][] data, map;


    public static boolean check() {
        if(K == 1) return true;

        for (int i = 0; i < C; i++) {
            int check = 1;
            boolean flag = false;
            for (int j = 0; j < R - 1; j++) {
                if(map[j][i] == map[j + 1][i]) {
                    check++;
                }else {
                    check = 1;
                }
                if (check == K) {
                    flag = true;
                    break;
                }
            }
            if(!flag) return false;
        }
        return true;
    }

    public static void dfs(int idx, int cnt) {

        if(cnt >= rsl ||cnt > K) return;
//      System.out.println(idx + " " + cnt);
        if(check()) {
            rsl = Math.min(rsl, cnt);
            return;
        }
        if(idx >= R) return;
//        Arrays.fill(map[idx], 1);
//        dfs(idx + 1, cnt + 1);
//        Arrays.fill(map[idx], 0);
//        dfs(idx + 1, cnt + 1);
//        map[idx] = Arrays.copyOf(data[idx], C);
//        dfs(idx + 1, cnt);


      for (int i = idx; i < R; i++) {
          Arrays.fill(map[i], 1);
          dfs(i + 1, cnt + 1);
          Arrays.fill(map[i], 0);
          dfs(i + 1, cnt + 1);
          map[i] = Arrays.copyOf(data[i], C);
//          dfs(i + 1, cnt);
      }

    }


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());

            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            data = new int[R][C];
            map = new int[R][C];

            for (int i = 0; i < R; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < C; j++) {
                    int temp = Integer.parseInt(st.nextToken());
                    data[i][j] = temp;
                    map[i][j] = temp;
                }
            }

            rsl = Integer.MAX_VALUE;
            dfs(0, 0);
//            System.out.println(cc);
            sb.append(rsl).append("\n");

        }
        System.out.println(sb);
    }

}