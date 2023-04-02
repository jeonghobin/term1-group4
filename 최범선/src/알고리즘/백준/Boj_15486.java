package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_15486 {
    static int N, rsl;
    static int[][] data;
    static int[] d;

//    public static void recursive(int idx, int cnt){
//
//    	if (idx == N + 1) {
//    		rsl = Math.max(rsl, cnt);
//    		return;
//    	}
//
//    	if(idx + data[idx][0] <= N + 1) {
//    		recursive(idx + data[idx][0], cnt + data[idx][1]);
//    	}
//    	recursive(idx + 1, cnt);
//    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        data = new int[N + 1][2];
        d = new int[N + 2];
        for (int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 2; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

//        recursive(1, 0);
//        System.out.println(rsl);
//

        for (int i = 1; i < N + 1; i++) {
            int day = i + data[i][0];
            if (day <= N + 1) {
                d[day] = Math.max(d[day], d[i] + data[i][1]);
            }
            d[i + 1] = Math.max(d[i+1], d[i]);
//        	System.out.println(Arrays.toString(d));
        }
//        Arrays.sort(d);
        System.out.println(d[N+1]);

    }
}
