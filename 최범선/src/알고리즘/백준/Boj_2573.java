package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2573 {
    static int[][] data;
    static boolean[][] v;
    static int cnt, N , M, max, a;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};

    public static boolean down(){

        boolean[][] v = new boolean[N][M];
        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (data[i][j] == 0) continue;
                int count = 0;
                v[i][j] = true;
                for (int k = 0; k < 4; k++) {
                    int nx = i + dx[k];
                    int ny = j + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M){
                        if (!v[nx][ny] && data[nx][ny] == 0) count++;
                    }
                }
                data[i][j] = Math.max(data[i][j] - count, 0);
                if (data[i][j] == 0) {
                    flag = true;
                    cnt--;
                }
            }
        }
        return flag;
    }

    public static void dfs(int x, int y){
        a++;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M){
                if (!v[nx][ny] && data[nx][ny] > 0){
                    v[nx][ny] = true;
                    dfs(nx, ny);
                }
            }
        }
        max = Math.max(max, a);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N][M];

        cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
                if (data[i][j] > 0) cnt++;
            }
        }
        int idx = 0;
        while(true){
            idx++;
            if(down()){
                if (cnt <= 0){
                    System.out.println(0);
                    break;
                }
                L :for (int i = 0; i < N; i++) {
                    for (int j = 0; j < M; j++) {
                        if (data[i][j] > 0) {
                            a = 0;
                            v = new boolean[N][M];
                            max = -1;
                            v[i][j] = true;
                            dfs(i,j);
                            break L;
                        }
                    }
                }
                if(max != cnt) {
                    System.out.println(idx);
                    break;
                }
            }
        }
    }
}
