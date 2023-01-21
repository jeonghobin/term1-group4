package 알고리즘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1654 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] data = new int[N];
        long end = -1, start = 1;
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(br.readLine());
            end = Math.max(end,data[i]);
        }
        while (start <= end){
            long mid = (start + end) / 2;
            int count = 0;
            for (int i = 0; i < N; i++) {
                count += data[i] / mid;
            }

            if (count >= K){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        System.out.println(end);
    }

}
