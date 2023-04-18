package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1655 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> max = new PriorityQueue<>(((o1, o2) -> Integer.compare(o2, o1)));
        PriorityQueue<Integer> min = new PriorityQueue<>();


        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(br.readLine());

            if (max.size() == min.size()) max.add(t);
            else min.add(t);

            if (!max.isEmpty() && !min.isEmpty()){
                if (max.peek() > min.peek()){
                    int temp = max.poll();
                    max.add(min.poll());
                    min.add(temp);
                }
            }
            sb.append(max.peek()).append("\n");
        }
        System.out.println(sb);

    }
}
