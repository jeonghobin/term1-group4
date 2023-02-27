package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_4008 {
    static int[] data, number;
    static int N, max, min;
    static boolean[] v;

    public static boolean NP(){
        int i = N - 2;
        int j = N - 2;
        while (i > 0 && data[i-1] >= data[i]) i--;
        if (i <= 0) return false;

        while (data[i-1] >= data[j]) j--;
        swap(i-1, j);
        j = N - 2;
        while (i < j){
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }
    public static void swap(int x, int y){
        int temp = data[y];
        data[y] = data[x];
        data[x] = temp;
    }
    public static void find(){
        int start = number[0];

        for (int i = 0; i < N - 1; i++) {
            if(data[i] == 0) start += number[i + 1];
            else if(data[i] == 1) start -= number[i + 1];
            else if(data[i] == 2) start *= number[i + 1];
            else if(data[i] == 3) start /= number[i + 1];
        }
        max = Math.max(max, start);
        min = Math.min(min, start);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int tc  = Integer.parseInt(st.nextToken());

        for (int t = 1; t < tc + 1; t++) {
            sb.append("#").append(t).append(" ");
            N = Integer.parseInt(br.readLine());
            data = new int[N - 1];
            v = new boolean[N - 1];
            number = new int[N];

            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;

            int idx = 0, c = 0;
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()){
                int temp = Integer.parseInt(st.nextToken());
                for (int i = idx; i < idx + temp; i++) {
                    data[i] = c;
                }
                c++;
                idx += temp;
            }
            Arrays.sort(data);
            st = new StringTokenizer(br.readLine());
            idx = 0;
            while (st.hasMoreTokens()) {
                number[idx] = Integer.parseInt(st.nextToken());
                idx++;
            }

            do {
                find();
            }while (NP());
            sb.append(max - min).append("\n");
        }
        System.out.println(sb);
    }
}
