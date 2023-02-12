package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1931 {
    public static class Pair{
        long start, end;
        public Pair(long start, long end) {
            this.start = start;
            this.end = end;
        }
    }
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Pair[] p = new Pair[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = new Pair(Long.parseLong(st.nextToken()),Long.parseLong(st.nextToken()));
        }
        Arrays.sort(p, (o1, o2) -> {
            if (o1.end == o2.end) return Math.toIntExact(o1.start - o2.start);
            return Math.toIntExact(o1.end - o2.end);
        });
        int cnt = 1;
        long end = p[0].end;
        for (int i = 1; i < N; i++) {
            if (end <= p[i].start){
                end = p[i].end;
                cnt++;
            }
        }
        System.out.println(cnt);

    }
}
