package 알고리즘.백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_2164 {


    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> q = new LinkedList<Integer>();

        for (int i = 1; i < N + 1; i++) {
            q.add(i);
        }
        while(q.size() > 1) {
            q.poll();
            q.add(q.poll());
        }
        System.out.println(q.element());

    }
}