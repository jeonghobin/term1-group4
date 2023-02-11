package 알고리즘.Swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Swea_1225 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int t = 1; t < 11; t++) {
            String a = br.readLine();
            st = new StringTokenizer(br.readLine());
            StringBuilder sb = new StringBuilder();
            sb.append("#").append(t).append(" ");
            Queue<Integer> q = new LinkedList<Integer>();
            int d = 0, cnt = 0;
            while(st.hasMoreTokens()) {
                int temp = Integer.parseInt(st.nextToken());
                q.add(temp);
            }
            int idx = 1;
            while(true) {
                int temp = q.poll();
                if (temp - idx <= 0) {
                    q.add(0);
                    break;
                }
                else {
                    temp -= idx;
                    q.add(temp);
                }
                idx++;
                if (idx > 5) idx = 1;
            }
            while(!q.isEmpty()) {
                sb.append(q.poll()).append(" ");
            }

            System.out.println(sb);
        }
    }

}
