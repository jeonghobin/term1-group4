package 알고리즘.백준;

import java.io.*;
public class Boj_2999 {
    public static void main(String args[]) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        int R = 1 , C = a.length();
        int n = (int)Math.sqrt(a.length()) + 1;
        for (int i = 1; i < n; i++) {
            if (a.length() % i == 0) {
                R = i;
                C = a.length() / i;
            }
        }

        char[][] data = new char[R][C];
        int cnt = 0;
        for (int i = 0; i < C; i++) {
            for (int j = 0; j < R; j++) {
                if (cnt <= a.length())data[j][i] = a.charAt(cnt++);
            }
        }


        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                System.out.print(data[i][j]);
            }
        }


    }
}
