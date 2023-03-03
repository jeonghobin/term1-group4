package 알고리즘.백준;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_2121 {

    static int N, width, height;
    static Pair[] p;

    public static class Pair implements Comparable<Pair>{
        int x, y;
        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Pair o) {
//            return Integer.compare(this.x, o.x);
            return this.x == o.x ? Integer.compare(this.y, o.y) : Integer.compare(this.x, o.x);
        }
    }

    public static boolean find(int x, int y){
        int start = 0;
        int end = N - 1;
        int mid;
        while (start <= end){
            mid = (start + end) / 2;
            if(p[mid].x == x && p[mid].y == y) return true;
            if(p[mid].x > x) end = mid - 1;
            else if(p[mid].x == x && p[mid].y > y)end = mid - 1;
            else start = mid + 1;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        p = new Pair[N];

        st = new StringTokenizer(br.readLine());
        width = Integer.parseInt(st.nextToken());
        height = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            p[i] = new Pair(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(p);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if (find(p[i].x + width, p[i].y) && find(p[i].x, p[i].y + height) && find(p[i].x + width, p[i].y + height)) cnt++;
        }
        System.out.println(cnt);
    }
}
