package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Swea_2805 {
    static int rsl, N;
    static int data[][];
    public static void start(int y, int cnt, int state){

       if (cnt == 1) rsl += data[N/2][y];
       else{
           for (int i = N/2 - cnt/2; i < N/2 + cnt/2 + 1; i++) {
               rsl += data[i][y];
           }
       }
       if (y + 1 >= N){return;}
       if (cnt + 2 > N) state = 1;
       if (state == 1){start(y+1,cnt-2, 1);}
       else{start(y+1,cnt+2, 0);}
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        for (int t = 1; t < tc + 1; t++) {
            rsl = 0;
            N = Integer.parseInt(br.readLine().trim());
            data = new int[N][N];

            for (int i = 0; i < N; i++) {
                String temp = br.readLine().trim();
                for (int j = 0; j < N; j++) {
                    data[i][j] = Integer.parseInt(String.valueOf(temp.charAt(j)));
                }
            }
            start(0,1, 0);
            System.out.println("#" + t + " " + rsl);
        }
    }
}
