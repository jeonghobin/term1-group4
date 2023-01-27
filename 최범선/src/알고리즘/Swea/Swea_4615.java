package 알고리즘.Swea;

import java.io.*;
import java.util.*;

public class Swea_4615 {
    //흑 : 1 , 백 : 2
    static int data[][] ;
    static int N;
    static int[] dx = {0,1,0,-1,-1,-1,1,1};
    static int[] dy = {1,0,-1,0,-1,1,-1,1};
    public static void check(int i, int j, int color){
        int state ;
        if (color == 1) state = 2;
        else state = 1;
        data[i][j] = color;

        for (int k = 0; k < 8; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 1 && nx <= N && ny >= 1 && ny <= N && data[nx][ny] == state){
                check2(nx, ny, k, color);
            }
        }
    }
    public static void check2(int i, int j, int idx, int color){
        int nx = i + dx[idx];
        int ny = j + dy[idx];
        int cnt = 0, state;
        if (color == 1) state = 2;
        else state = 1;
        while (nx >= 1 && nx <= N && ny >= 1 && ny <= N){
            if(data[nx][ny] == state){
                cnt++;
                nx += dx[idx];
                ny += dy[idx];
            }
            else if (data[nx][ny] == color) {
                cnt++;
                int x = i, y = j;
                for (int k = 0; k < cnt; k++) {
                    data[x][y] = color;
                    x += dx[idx];
                    y += dy[idx];
                }
                break;
            }else{
                break;
            }

        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int tc = Integer.parseInt(br.readLine());

        for (int i = 1; i < tc + 1; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            data = new int[N+1][N+1];
            data[N/2][N/2] = 2;
            data[N/2][N/2 + 1] = 1;
            data[N/2 + 1][N/2] = 1;
            data[N/2 + 1][N/2 + 1] = 2;

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());
                check(x,y,color);
            }

            int black = 0, white = 0;
            for (int j = 1; j < N + 1 ; j++) {
                for (int k = 1; k < N + 1; k++) {
                    if (data[j][k] == 1){
                        black++;
                    }else if(data[j][k] == 2){
                        white++;
                    }
                }
            }
                System.out.println("#" + i + " " + black + " " + white);
        }

}
}