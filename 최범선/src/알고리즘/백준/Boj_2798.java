package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2798 {

    static int[] data;
    static int N, score, max;

    public static void recursive(int cnt, int start, int sum) {

        if (cnt >= 3 && sum <= score) {
            max = Math.max(max, sum);
            return;
        }
        if (cnt > 3) return;

        for (int i = start; i < N + 1; i++) {
            sum += data[i];
            recursive(cnt + 1, i + 1, sum);
            sum -= data[i];
        }

    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        score = Integer.parseInt(st.nextToken());

        data = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }
        max = Integer.MIN_VALUE;
        recursive(0, 1, 0);

        System.out.println(max);
    }
}


//public class Boj_2798 {
//
//    static String[] a;
//    static int N, M, max = -1;
//    public static void recursive(int idx, int total, int cnt){
//
//        if (cnt == 3){
//            max = Math.max(max,total);
//            return;
//        }
//        if (idx >= N) return;
//        recursive(idx + 1, total, cnt);
//        if (total + Integer.parseInt(a[idx]) <= M){
//            recursive(idx + 1, total + Integer.parseInt(a[idx]), cnt + 1);
//        }
//
//    }
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        N = Integer.parseInt(st.nextToken());
//        M = Integer.parseInt(st.nextToken());
//
//        a = br.readLine().split(" ");
//        recursive(0,0,0);
//        System.out.println(max);
//    }
//}
