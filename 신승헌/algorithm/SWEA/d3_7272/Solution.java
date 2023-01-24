package homwork.SWEA.d3_7272;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("res/d3_7272/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			String A = st.nextToken();
			String B = st.nextToken();
			
			char[] oneHole = {'A','D','O','P','Q','R'};
			
			// 길이가 다르면
			if (A.length() != B.length()) {
				sb.append("#" + test_case + " DIFF\n");
				continue;
			}
			
			// 문자열 길이만큼 반복
			for (int i = 0; i < A.length(); i++) {
				boolean isSame = true;
				char compareA = A.charAt(i);
				char compareB = B.charAt(i);
				
				int oneHoleA = 0;
				int oneHoleB = 0;
				
				// 비교할 문자 개수만큼 반복
				for (int j = 0; j < oneHole.length; j++) {
					if (compareA == 'B') {
						oneHoleA = 2;
					} 
					if (compareB == 'B') {
						oneHoleB = 2;
					} 
					
					if (compareA == oneHole[j]) {
						oneHoleA = 1;
					}
					if (compareB == oneHole[j]) {
						oneHoleB = 1;
					}

					// 둘다 구멍이 하나/두 개인 알파벳이라면
					if (oneHoleA == 1 && oneHoleB == 1 || oneHoleA == 2 && oneHoleB == 2) {
						break;
					}
					
					// 둘 중 하나만 B라면
					if ( (oneHoleA == 2 && oneHoleB != 2) || (oneHoleA != 2 && oneHoleB == 2) ) {
						isSame = false;
						break;
					}
					
					
					// 끝까지 다 돌았고, 둘다 거짓(둘다 구멍이 하나인 알파벳이 아니라면)
					if ( j == oneHole.length - 1 && !(oneHoleA != 1 && oneHoleB != 1) ) {
						isSame = false;
						break;
					}
				}
				
				if (isSame == false) {
					sb.append("#" + test_case + " DIFF\n");
					break;
				}
				
				if (i == A.length() - 1) {
					sb.append("#" + test_case + " SAME\n");
					break;
				}
				
			}
		}
		System.out.println(sb);
	}
	
}
