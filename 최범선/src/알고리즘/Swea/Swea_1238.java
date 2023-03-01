package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1238 {
    static ArrayList<Integer>[] list;
    static int max_level, max_num;
    static Queue<node> q;
    static boolean[] v;
    public static class node{
        int end, level;
        public node(int end, int level) {
            this.end = end;
            this.level = level;
        }

        @Override
        public String toString() {
            return "node{" +
                    "end=" + end +
                    ", level=" + level +
                    '}';
        }
    }
    public static void bfs(){
        while (!q.isEmpty()){
            node t = q.poll();
            if (t.level > max_level){
                max_level = t.level;
                max_num = -1;
            }
            max_num = Math.max(max_num, t.end);

            for (int i = 0; i < list[t.end].size(); i++) {
                if(!v[list[t.end].get(i)]){
                    v[list[t.end].get(i)] = true;
                    q.add(new node(list[t.end].get(i), t.level + 1));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t < 11; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            list = new ArrayList[101];
            v = new boolean[101];
            for (int i = 0; i < 101; i++) list[i] = new ArrayList<>();
            while (st.hasMoreTokens()){
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                list[s].add(e);
            }

            q = new LinkedList<>();
            q.add(new node(start, 0));
            v[start] = true;
            max_level = -1;
            max_num = -1;
            bfs();
            sb.append(max_num).append("\n");
        }
        System.out.println(sb);
    }
}
