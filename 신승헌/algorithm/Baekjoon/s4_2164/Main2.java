package algo.bj.s4_2164;

import java.io.*;
import java.util.*;

public class Main2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for (int i = 1; i <= N; i++) {
			q.offer(i);
		}
		
		
		while(!(q.size() == 1)) {
			q.poll();
			q.offer(q.poll());
		}
		System.out.println(q.poll());
		
	}

}
