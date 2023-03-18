package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Apple {
    static int Ans = Integer.MAX_VALUE, N, MaxApple;
    static int map[][];

    // 우,하,좌,상
    static int[] dr = { 0, 1, 0, -1 };
    static int[] dc = { 1, 0, -1, 0 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            Ans = Integer.MAX_VALUE;
            MaxApple = 0;
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > 0)
                        MaxApple = Math.max(map[i][j], MaxApple);
                }
            }
            //print(map);
            recursive(0,0,0,0,1);

            System.out.println("#" + tc + " " + Ans);

        }

    }

    private static void recursive(int r, int c, int d, int cnt, int eat) {

        //System.out.printf("%d %d %d %d\n",r,c,cnt,eat);
        if(eat-1 == MaxApple) {
            Ans = Math.min(Ans, cnt);

            return;
        }

        int nr = r + dr[d];
        int nc = c + dc[d];
        // 꺽는 경우
        // 1.90도 꺽어서 사과가 있는 경우
        // 2.벽만났을때
        if(check(r,c,d,eat)||(nr<0||nr>=N||nc<0||nc>=N)) {
            int nd = (d+1)%4;
            recursive(r, c, nd, cnt+1, eat);
            return;
        }
        // 먹는 경우
        if(map[r][c]==eat) {
            recursive(r, c, d, cnt, eat+1);
        }else {
            // 갈길가는 경우
            recursive(nr, nc, d, cnt, eat);
        }

    }

    private static boolean check(int r, int c, int d, int eat) {
        d = (d+1)%4;
        while(r>=0&&r<N&&c>=0&&c<N) {
            r += dr[d];
            c += dc[d];
            if(r>=0&&r<N&&c>=0&&c<N) {
                if(map[r][c]==eat) return true;
            }
        }
        return false;
    }

    private static void print(int[][] map) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}

