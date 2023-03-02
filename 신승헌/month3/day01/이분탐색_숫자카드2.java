package month3.day01;

import java.io.*;
import java.util.*;

// 무지성 코드
public class 이분탐색_숫자카드2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(st.nextToken());
		int[] counter = new int[20000001];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int input = 10000000 + Integer.parseInt(st.nextToken());
			counter[input]++;
		}
		
		LinkedList<Integer> list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			if (counter[i] != 0) {
				list.add(i);
			}
		}
		Collections.sort(list);
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int checkNum = 10000000 + Integer.parseInt(st.nextToken());
			sb.append(counter[checkNum] + " ");
//			int start = 0;
//			int end = list.size() -1;
//			
//			while (start <= end) {
//				int mid = (start + end) / 2;
//		
//				// 배열의 값 < 찾는 값  
//				if (list.get(mid) < checkNum) {
//					start = mid + 1;
//				}
//				
//				// 찾는 값 < 배열의 값  
//				if (list.get(mid) > checkNum) {
//					end = mid - 1;
//				}
//				
//				// 찾았으면 
//				if (list.get(mid) == checkNum) {
//					 sb.append(counter[checkNum]);
//				}
//			}
		}
		System.out.println(sb);
	}
	
}