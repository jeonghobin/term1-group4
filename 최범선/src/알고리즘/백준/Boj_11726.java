package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11726 {

    static int rsl;
    static int[][] data;
    static int[] memo;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] data = new int[N + 1];
        data[0] = 1;
        data[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            data[i] = (data[i-1] + data[i-2])%10007;
        }

//		System.out.println(Arrays.toString(data));

        System.out.println(data[N]);

    }

}
