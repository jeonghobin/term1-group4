package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_1952 {

    static int[] price, count;
    static int min;

    public static void recursive(int idx, int total) {
        if(idx > 12) {
            min = Math.min(min, total);
            return;
        }
        if(count[idx] == 0) {
            recursive(idx + 1, total);
        }
        recursive(idx + 3 , total + price[3]);

        if (count[idx] != 0) {
            recursive(idx + 1, total + price[2]);

            recursive(idx + 1, total + price[1] * count[idx]);
        }

    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for (int t = 1; t < N + 1; t++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");

            price = new int[5]; // 1일 , 1달, 3달 , 1년
            count = new int[13];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 5; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }
            min = price[4];
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i < 13; i++) {
                count[i] = Integer.parseInt(st.nextToken());
            }

            recursive(1, 0);

            sb.append(min);
            System.out.println(sb);
        }
    }
}
