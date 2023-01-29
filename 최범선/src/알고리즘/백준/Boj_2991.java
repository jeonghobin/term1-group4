package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2991 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        int[] data = new int[1001];
        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        for (int i = 1; i < data.length; i += A+B) {
            for (int j = 0; j < A; j++) {
                if (i + j < data.length) data[i + j]++;
                else break;
            }
        }
        for (int i = 1; i < data.length; i += C+D) {
            for (int j = 0; j < C; j++) {
                if (i + j < data.length) data[i + j]++;
                else break;
            }
        }
        System.out.println(data[P]);
        System.out.println(data[M]);
        System.out.println(data[N]);

    }
}
