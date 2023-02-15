package algo.swea.d3_1228;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/1228/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
//		int T = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= 10; test_case++) {
			// 첫 번째 줄
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			// 두 번째 줄
			st = new StringTokenizer(br.readLine());
			LinkedList<Integer> list = new LinkedList<>();
			
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			// 세 번째 줄
			st = new StringTokenizer(br.readLine());
			int M = Integer.parseInt(st.nextToken()); // 명령어 개수
			
			// 네 번째 줄
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				st.nextToken(); // | 빼기
				int x = Integer.parseInt(st.nextToken()); // 삽입할 위치
				int y = Integer.parseInt(st.nextToken()); // 삽입할 개수
				
				for (int j = x; j < x + y; j++) {
					if (j != 10) {
						list.add(j, Integer.parseInt(st.nextToken()));
						continue;
					}
					st.nextToken();
				}
			}
			sb.append("#" + test_case + " ");
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i) +" ");
			}
			sb.append("\n");
		} // [E] test_case
		System.out.println(sb);
	}
}
