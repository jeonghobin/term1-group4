package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2798 {

    static String[] a;
    static int N, M, max = -1;
    public static void recursive(int idx, int total, int cnt){

        if (cnt == 3){
            max = Math.max(max,total);
            return;
        }
        if (idx >= N) return;
        recursive(idx + 1, total, cnt);
        if (total + Integer.parseInt(a[idx]) <= M){
            recursive(idx + 1, total + Integer.parseInt(a[idx]), cnt + 1);
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        a = br.readLine().split(" ");
        recursive(0,0,0);
        System.out.println(max);
    }
}
