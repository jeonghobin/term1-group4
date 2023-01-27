package 알고리즘.백준;

import java.io.*;

public class Boj_1436 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String a = "666";
        int[] data = new int[N];
        data[0] = 666;

        for (int i = 1; i < N; i++) {
            int start = data[i-1];
            while(true) {
                start++;
                String temp = start + "";
//                temp.contains(a);
                if (temp.indexOf(a) != -1	) {
                    data[i] = start;
                    break;
                }
            }
        }
        System.out.println(data[N-1]);
    }
}
