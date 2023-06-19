package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1325 {
    static int N, M;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            list[i] = new ArrayList<>();
        }
        int s,e;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            list[e].add(s);
        }

        int count[] = new int[N + 1];
        boolean[] v = new boolean[N + 1];
        int max = -1;

        Queue<Integer> q = new LinkedList<>();

        int cnt;
        for (int i = 1; i < N + 1; i++) {
            q.add(i);
            v[i] = true;
            cnt = 0;
            while (!q.isEmpty()){
                int t = q.poll();
                for (int j = 0; j < list[t].size(); j++) {
                        if (v[list[t].get(j)]) continue;
                        cnt++;
                        v[list[t].get(j)] = true;
                        q.add(list[t].get(j));
                }
            }
//            Arrays.fill(v,false);
            v = new boolean[N + 1];
            count[i] = cnt;

            max = Math.max(max, cnt);
        }
        for (int i = 1; i < N + 1; i++) {
            if (count[i] == max) sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}












