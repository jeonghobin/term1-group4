package homework.Baekjoon.s4_1244;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 스위치 개수
		int[] switchArray = new int[N + 1];
		int M; // 학생 수
		int[][] student; // 1행 : 성별, 2행 : 스위치 번호
		
		// input
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i < switchArray.length; i++) {
			switchArray[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		
		student = new int[2][M];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			student[0][i] = Integer.parseInt(st.nextToken());
			student[1][i] = Integer.parseInt(st.nextToken());
		}
		
		
		for (int i = 0; i < student[0].length; i++) {
			int searchSex = student[0][i];
			int searchNum = student[1][i];
			if (searchSex == 1) {
				for (int j = searchNum; j < switchArray.length; j += searchNum ) {
					switchArray[j] += 1;
					switchArray[j] %= 2;
				}
			} else {
				// 연산 가능한 경우
				if ( (searchNum - 1 != 0 && searchNum + 1 != N + 1) && switchArray[searchNum - 1] == switchArray[searchNum + 1] ) {
					// 좌우대칭인 경우 반복
					int changeIndex = 1;
					switchArray[searchNum] += 1;
					switchArray[searchNum] %= 2;
					while((searchNum - changeIndex != 0 && searchNum + changeIndex != N + 1) && switchArray[searchNum - changeIndex] == switchArray[searchNum + changeIndex]) {
						switchArray[searchNum + changeIndex] += 1;
						switchArray[searchNum + changeIndex] %= 2;
						switchArray[searchNum - changeIndex] += 1;
						switchArray[searchNum - changeIndex] %= 2;
						
						changeIndex += 1;
						
					}
					
				
				// 끝 부분이라 연산이 불가능한 경우 || 처음부터 비대칭인 경우
				} else { 
					switchArray[searchNum] += 1;
					switchArray[searchNum] %= 2;
				}
			}
			
		}
		
//		for (int i = 1; i < switchArray.length; i++) {
//			sb.append(switchArray[i] + " ");
//		}
//		
//		System.out.print(sb);

		for (int i = 1; i < switchArray.length; i++) {
			System.out.print(switchArray[i] + " ");
		}
	}
}
