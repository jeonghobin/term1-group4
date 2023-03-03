package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_17136 {

    static int[][] data, map;
    static int min;
    static int[] count = {0, 5, 5, 5, 5, 5};

    public static int getSize(int x, int y){
        int size = 5;
        boolean flag;
        while (size > 1){
            flag = true;
            L :for (int i = x; i < x + size; i++) {
                for (int j = y; j < y + size; j++) {
                    if(i >= 10 || j >= 10) {
                        flag = false;
                        break L;
                    }
                    if (data[i][j] != 1) {
                        flag = false;
                        break L;
                    }
                }
            }

            if(flag) break;
            size--;
        }
        return size;
    }

    public static void dfs(int cnt){

        if(min <= cnt) return;

        int x = -1, y = -1;
        L :for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (data[i][j] == 1){
                    x = i;
                    y = j;
                    break L;
                }
            }
        }
        if(x == -1){
            min = Math.min(min, cnt);
            return;
        }
        int size = getSize(x, y);
        for (int k = 1; k <= size ; k++) {
            if(count[k] - 1 < 0) continue;
            for (int i = x; i < x + k; i++) {
                for (int j = y; j < y + k; j++) {
                    data[i][j] = 0;
                }
            }
            count[k]--;
            dfs(cnt + 1);
            for (int i = x; i < x + k; i++) {
                for (int j = y; j < y + k; j++) {
                    data[i][j] = 1;
                }
            }
            count[k]++;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        data = new int[10][10];
        map = new int[10][10];
        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        min = Integer.MAX_VALUE;
        dfs(0);

        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

}
