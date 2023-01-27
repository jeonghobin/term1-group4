package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1592 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] data = new int[N+1];
        data[1]++;
        int start = L + 1, cnt = 1;
        if (data[1] >= M){
            cnt = 0;
        }else{
        while (true){
            data[start]++;
            if (data[start] >= M) break;
            cnt++;
            if (data[start] % 2 == 0){
                if (start - L <= 0){
                    start = N + (start - L);
                }else{
                    start -= L;
                }
            }else{
                if (start + L > N){
                    start = start + L - N;
                }else{
                    start += L;
                }
            }
        }
        }

        System.out.println(cnt);
    }
}
