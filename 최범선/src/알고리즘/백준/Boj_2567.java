package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Boj_2567 {

    static int[][] data;
    public static void draw(int x , int y){

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                data[x + i][y + j] = 1;
            }
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        data = new int[101][101];
        int l = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            draw(a,b);
        }
        int[] dx = {0,1,0,-1};
        int[] dy = {1,0,-1,0};
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (data[i][j] == 1){
                    int cnt = 0;
                    for (int k = 0; k < 4; k++) {
                        int nx = i + dx[k];
                        int ny = j + dy[k];
                        if (nx >= 0 && nx < 101 && ny >= 0 && ny < 101){
                            if (data[nx][ny] == 0) cnt++;
                        }
                    }
                    if (cnt == 2) l += 2;
                    else if(cnt == 1) l += 1;
                }
            }
        }
        System.out.println(l);

    }
}
