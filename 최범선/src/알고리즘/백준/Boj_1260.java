package 알고리즘.백준;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1260 {
    static ArrayList<Integer>[] list;
    static StringBuilder sb;
    static int N, M;
    static boolean[] v;

    public static void dfs(int idx){

        v[idx] = true;
        sb.append(idx).append(" ");

        for (int i = 0; i < list[idx].size(); i++) {
            int t = list[idx].get(i);
            if(!v[t]) dfs(t);
        }
    }

    public static void bfs(int start){

        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        v[start] = true;

        while (!q.isEmpty()){
            int t = q.poll();
            sb.append(t).append(" ");
            for (int i = 0; i < list[t].size(); i++) {
                int tt = list[t].get(i);
                if(!v[tt]){
                    v[tt] = true;
                    q.add(tt);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        v = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 0; i < N + 1; i++) list[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
            Collections.sort(list[a]);
            Collections.sort(list[b]);
        }

        dfs(start);
        sb.append("\n");
        Arrays.fill(v, false);
        bfs(start);
        System.out.println(sb);

    }
}
