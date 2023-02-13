package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_1158 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < N + 1; i++) {
            list.add(i);
        }
        int idx = K - 1;
        while(list.size() > 1) {
            sb.append(list.get(idx)).append(", ");
            list.remove(idx);
            idx += K-1;
            idx %= list.size();
        }
        sb.append(list.get(0)).append(">");
        System.out.println(sb);
    }
}
