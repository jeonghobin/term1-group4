package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_2564 {
    static int[][] data, visited;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int N, x, y, min;
    static int[] order;
    public static void recursive(int a, int b, int target, int count){

        if (data[a][b] == target){
            min = Math.min(min, count);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = a + dx[i];
            int ny = b + dy[i];
            if (nx >= 0 && nx < x + 1 && ny >=0 && ny < y + 1){
                if (data[nx][ny] != -1){
                    data[a][b] = -1;
                    count++;
                    recursive(nx,ny,target,count);
                    count--;
                    data[a][b] = 0;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(br.readLine());

        data = new int[x+1][y+1];
        order = new int[N+1];
        for (int i = 1; i < x; i++) {
            for (int j = 1; j < y; j++) {
                data[i][j] = -1;
            }
        }
        int a = 0, b = 0;
        int[][] index = new int[N + 1][2];
        for (int i = 0; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if (d==1){
                if (i == N){
                    a = 0;
                    b = l;
                }
                data[0][l] = i + 1;
                index[i][0] = 0;
                index[i][1] = l;
            }else if(d==3){
                if (i == N){
                    a = l;
                    b = 0;
                }
                data[l][0] = i + 1;
                index[i][0] = l;
                index[i][1] = 0;
            }else if(d==2){
                if (i == N){
                    a = x;
                    b = l;
                }
                data[x][l] = i + 1;
                index[i][0] = x;
                index[i][1] = l;
            }else if(d==4){
                if (i == N){
                    a = l;
                    b = y;
                }
                data[l][y] = i + 1;
                index[i][0] = l;
                index[i][1] = y;
            }
        }
        int rsl = 0;
        for (int i = 1; i <= N ; i++) {
            for (int j = i; j <= N ; j++) {
                int q = index[j-1][0];
                int w = index[j-1][1];
                data[q][w] = j;
            }
            data[a][b] = N + 1;
            min = Integer.MAX_VALUE;
            recursive(a,b,i,0);
            rsl += min;
        }
        System.out.println(rsl);
    }
}
