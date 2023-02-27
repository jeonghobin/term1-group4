package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Boj_10775 {
    static int[] sel;

    public static int find(int idx){
        if(sel[idx] == idx) return idx;
        return sel[idx] = find(sel[idx]);
    }

    public static void union(int x, int y){
        int a = find(x);
        int b = find(y);
        sel[a] = b;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        sel = new int[N + 1];
        for (int i = 1; i < N + 1; i++) sel[i] = i;

        boolean flag = false;
        int cnt = 0;
        for (int i = 0; i < K; i++) {
            int t = Integer.parseInt(br.readLine());
            if(flag) continue;
            int rep = find(t);
            if(rep < 1) flag = true;
            else{
                union(rep, rep - 1);
//                System.out.println(Arrays.toString(sel));
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
