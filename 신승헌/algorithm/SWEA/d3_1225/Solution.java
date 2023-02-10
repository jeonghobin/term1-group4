package algo.swea.d3_1225;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		for(int test_case = 1; test_case <= 10; test_case++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			Queue<Integer> q = new LinkedList<>();
			
			while (st.hasMoreElements()) {
				q.offer(Integer.parseInt(st.nextToken()));
			}
			
			L:while(true) {
				for (int i = 1; i <= 5; i++) {
					if (q.peek() - i <= 0) {
						q.poll();
						q.offer(0);
						break L;
					}
					
					q.offer(q.poll() - i);
					
				}
			}
			
			sb.append("#" + test_case + " ");
			while (!q.isEmpty()) {
				sb.append(q.poll() + " ");
			}
			sb.append("\n");
			
		} // [E] test_case
		System.out.println(sb);
	}
}
