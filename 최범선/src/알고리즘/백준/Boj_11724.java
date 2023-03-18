package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_11724 {
    static int N, M;
    static int[] data;

    public static void makeSet(){
        for (int i = 1; i < N + 1; i++) {
            data[i] = i;
        }
    }
    public static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        data[y] = x;
    }
    public static int find(int idx){
        if(data[idx] == idx) return idx;
        return data[idx] = find(data[idx]);
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        data = new int[N + 1];
        makeSet();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            union(start, end);
        }
        for (int i = 1; i < N + 1; i++) {
            find(i);
        }
        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            if (i == data[i]) cnt++;
        }
        System.out.println(cnt);
    }
}
