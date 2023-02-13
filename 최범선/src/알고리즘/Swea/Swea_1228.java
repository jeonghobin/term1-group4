package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_1228 {

    public static class Pair{
        int start, cnt;
        int[] data;
        public Pair(int start, int cnt, int[] data) {
            super();
            this.start = start;
            this.cnt = cnt;
            this.data = data;
        }
        @Override
        public String toString() {
            return "Pair [start=" + start + ", cnt=" + cnt + ", data=" + Arrays.toString(data) + "]";
        }

    }
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t < 11; t++) {
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();

            int N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                list.add(Integer.parseInt(st.nextToken()));
            }
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            Pair[] p = new Pair[K];
            int idx = 0;
            st = new StringTokenizer(br.readLine());
            while(st.hasMoreTokens()) {
                String a = st.nextToken();
                int index = Integer.parseInt(st.nextToken());
                int count = Integer.parseInt(st.nextToken());
                int[] temp = new int[count];
                for (int i = 0; i < count; i++) {
                    temp[i] = Integer.parseInt(st.nextToken());
                }
                p[idx] = new Pair(index, count, temp);
                idx++;
            }
            for (int i = 0; i < p.length; i++) {
                int start = p[i].start;
                int cnt = p[i].cnt;
                for (int j = 0; j < cnt; j++) {
                    list.add(start++ , p[i].data[j]);
                }
            }
            for (int i = 0; i < 10; i++) {
                sb.append(list.get(i)).append(" ");
            }
            System.out.println(sb);
        }
    }

}
