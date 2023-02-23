package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_1874 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        Stack<Integer> s = new Stack<>();
        boolean flag = true;
        boolean[] check = new boolean[N + 1];
        int idx = 1;
        for (int i = 1; i < N + 1 ; i++) {
            int K = Integer.parseInt(br.readLine());
            while (idx <= K){
                s.add(idx++);
                sb.append("+").append("\n");
            }
            while (s.peek() == K){
                s.pop();
                sb.append("-").append("\n");
                if(s.isEmpty()) break;
            }
        }
        System.out.println(s.isEmpty() ? sb : "NO");
    }
}

