package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Swea_1289 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        char[] data = {'1', '0'};
        for (int i = 1; i < tc + 1; i++) {
            String a = br.readLine();
            int idx = 0, cnt = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) == data[idx]) {
                    idx++;
                    idx %= 2;
                    cnt++;
                }
            }
            System.out.println("#" + i + " " + cnt);
        }


    }
}