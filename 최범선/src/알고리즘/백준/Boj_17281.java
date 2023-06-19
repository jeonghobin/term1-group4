package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17281 {

    static int N, score, idx, inning;
    static int[][] data;
    static boolean[] v;
    static Queue<Integer> q;

    static void recursive(int idx, int[] sel){

        if (idx == 3){
            sel[idx] = 0;
            idx++;
        }

        if (idx >= 9){
//            System.out.println(Arrays.toString(sel));
            play(sel);
            return;
        }

        for (int i = 0; i < 9; i++) {
            if (v[i]) continue;
            v[i] = true;
            sel[idx] = i;
            recursive(idx + 1, sel);
            v[i] = false;
            sel[idx] = -1;
        }
    }

    static void make(int[] player){
        q = new LinkedList<>();
        int out = 0;
        while (out < 3){
            if (data[inning][player[idx]] == 0){
                out++;
                idx++;
                idx %= 9;
                continue;
            }
            q.add(data[inning][player[idx]]);
            idx++;
            idx %= 9;
        }

    }

    static void play(int[] player){

        inning = 0;
        int[] cnt = new int[4];
        idx = 0;
        int s = 0;

        while(inning < N){
            make(player);
            while (!q.isEmpty()){
                int t = q.poll();
                if (t == 4){
                    int count = 0;
                    for (int i = 1; i < 4; i++) {
                        if (cnt[i] > 0) count++;
                    }
                    s += count + 1;
                    continue;
                }
                for (int i = 3; i > 0; i--) {
                    if (cnt[i] == 0) continue;
                    if (i + t >= 4) {
                        s++;
                        cnt[i] = 0;
                        continue;
                    }
                    cnt[i + t] = 1;
                    cnt[i] = 0;
                }
                cnt[t] = 1;
            }
            Arrays.fill(cnt, 0);
            inning++;
        }
        System.out.println(s);
        score = Math.max(score, s);
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        data = new int[N][9];
        v = new boolean[9];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                data[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        score = -1;
        v[0] = true;
        recursive(0, new int[9]);
        System.out.println(score);

    }
}














