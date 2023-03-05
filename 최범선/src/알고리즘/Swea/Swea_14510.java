package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Swea_14510 {
    static int N, max;
    static int[] data;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            data = new int[N];
            st = new StringTokenizer(br.readLine());
            max = -1;
            for (int i = 0; i < N; i++) {
                data[i] = Integer.parseInt(st.nextToken());
                max = Math.max(max, data[i]);
            }
            int odd = 0, even = 0;
            for (int i = 0; i < N; i++) {
                if (data[i] == max) continue;
                int temp = max - data[i];
                even += temp / 2;
                odd += temp % 2;
            }
            while (even - odd > 1){
                even--;
                odd += 2;
            }
            int result = 0;
            if(even > odd){
                result = 2 * even;
            }else if(even < odd){
                result = 2 * odd - 1;
            }else{
                result = odd + even;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }
}
