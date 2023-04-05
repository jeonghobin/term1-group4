package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 보호필름_2112_lesson {

	static int W; // 보호 필름 폭 W
	static int D; // 보호필름 두께 D
	static int K; // 합격기준 K
	static int Min; // 최소 투약 횟수
	static int[][] film; // 필름 정보
	static int[] chemicals; // 약품 투약 정보 (부분 집합으로 만들어 냄)

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			film = new int[D][W];
			Min = Integer.MAX_VALUE;
			chemicals = new int[D];
			for (int i = 0; i < D; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					film[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			// ------------Input End------------------------
			
			dfs(0,0);

			System.out.println("#" + tc + " " + Min);

		}

	}

	/**
	 * dfs로 부분 집합
	 * 
	 * @param row      : 약품 주입여부가 적용 될 행
	 * @param inputCnt : 약품 투여 횟수
	 */
	static void dfs(int row, int inputCnt) {
		// 기저조건 : D까지 도달했을 때
		if (row == D) {
			// 성능검사하기!
			if(check()) {
				//합격 여부에 따라서, 투입횟수 최소값 갱신
				Min = Math.min(inputCnt, Min);
			}
			//죄송해요!!! 여기를 아까 보충하면서 빼먹었어요 ㅜㅜ return 빼면 안됩니다!!!!!!!!!
			return;
		}
		//추가 가지치기 : 투여 횟수가 이미 저장된 최소 횟수를 넘어가면 return 
		if(inputCnt>=Min) {
			return;
		}

		// 각 행 약품 투입 결정하기 - 부분집합 만들기
		// 투입 안하는 경우-1 , A약품 투입 0, B약품 투입 1하는 경우
		for (int i = -1; i < 2; i++) {
			chemicals[row] = i;
			if (i == -1) { // 약품 투입을 안하는 경우
				dfs(row + 1, inputCnt);
			} else {// 약품 투입하는 경우(A약품, B약품)
				dfs(row + 1, inputCnt + 1);
			}

		}
		//for문을 풀면 아래와 같이 재귀를 탈 수 있습니다.
//		chemicals[row]=-1;
//		dfs(row+1, inputCnt);
//		
//		chemicals[row]=0;
//		dfs(row+1, inputCnt+1);
//		
//		chemicals[row]=1;
//		dfs(row+1, inputCnt+1);
		

	}

	/**
	 * 
	 * @return
	 */
	static boolean check() {
		int cnt = 0;
		int cur, next;
		for (int col = 0; col < W; col++) {
			cnt = 1;
			for (int row = 0; row < D - 1; row++) {
				// 약품 투여 정보를 가진 배열 확인하면서 약품 투여 여부 확인
				// 투여 안했으면 원본 배열 값 가져오고, 투여 했으면 투여 정보 배열에서 가져오기
				cur = chemicals[row] == -1 ? film[row][col] : chemicals[row];
				next = chemicals[row + 1] == -1 ? film[row + 1][col] : chemicals[row + 1];

				if (cur == next) {
					cnt++;
					if (cnt >= K) { // 합격기준 넘어가면 break
						break;
					}
				} else {
					cnt = 1;
				}
			}
			if (cnt < K) {
				return false;
			}

		}
		return true;
	}

}