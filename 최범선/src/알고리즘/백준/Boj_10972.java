package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj_10972 {

    static int[] data;
    static int N;

    public static boolean NP() {

        int i = N - 1;
        int j = N - 1;

        while(i > 0 && data[i-1] >= data[i]) i--;
        if (i == 0) return false;

        while(data[i-1] >= data[j]) j--;
        Swap(i-1, j);

        j = N - 1;
        while(i < j) {
            Swap(i, j);
            i++;
            j--;
        }

        return true;
    }

    public static void Swap(int x, int y) {
        int temp = data[x];
        data[x] = data[y];
        data[y] = temp;
    }



    public static void main(String[] args) throws Exception {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        data = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            data[i] = Integer.parseInt(st.nextToken());
        }

        if (NP()) {
            for (int i = 0; i < N; i++) {
                System.out.print(data[i] + " ");
            }
        }
        else System.out.println(-1);
    }
}