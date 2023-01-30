package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3985 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[] data = new int[N+1];
        int max = -1, idx = -1, max1 = -1, idx1 = -1;
        for (int i = 1; i < K+1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (b - a > max1){
                max1 = b-a;
                idx1 = i;
            }
            int cnt = 0;
            for (int j = a; j < b+1; j++) {
                if (data[j] == 0){
                    data[j]++;
                    cnt++;
                }
            }
            if (max < cnt){
                max = cnt;
                idx = i;
            }
        }
        System.out.println(idx1);
        System.out.println(idx);
    }
}
