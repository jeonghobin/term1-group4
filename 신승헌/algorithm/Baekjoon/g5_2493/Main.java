package algo.bj.g5_2493;

import java.io.*;
import java.util.*;

// 메모리 초과

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> s = new Stack<>();
		Stack<Integer> temp = new Stack<>();
		int[] answer = new int[N];
		st = new StringTokenizer(br.readLine());

		while (st.hasMoreElements()) {
			s.push(Integer.parseInt(st.nextToken()));
		}
		
		int idx = N-1;
		
		while (s.size() != 0) {
			int nowNum = s.pop();
			int compareIdx = idx + 1;
			
			while (true) {
				if (s.size() == 0) {
					answer[idx] = 0;
					break;
				}
				int compare = s.pop();
				compareIdx -= 1;
				
				if (nowNum > compare) {
					temp.push(compare);
				}
				if (nowNum < compare) {
					answer[idx] = compareIdx;
					temp.push(compare);
					break;
				}
			}
			
			idx = idx - 1;
			
			while (temp.size() != 0) {
				s.push(temp.pop());
			}
		}
		
		for (int i = 0; i < answer.length; i++) {
			sb.append(answer[i] + " ");
		}
		System.out.println(sb);
		
		
		
		
//		int arr[] = new int[N];
//		for (int i = 0; i < N; i++) {
//			arr[i] = Integer.parseInt(st.nextToken());
//		}
//		
//		int max = arr[0];
//		sb.append(0 + " ");
//		for (int i = 1; i < arr.length; i++) {
//			if (arr[i] > max) {
//				max = arr[i];
//				sb.append(0 + " ");
//			} else {
//				for (int j = i; j > 0; j++) {
//					
//				}
//			}
//			
//		}
//		
	
	
	
	}
}
