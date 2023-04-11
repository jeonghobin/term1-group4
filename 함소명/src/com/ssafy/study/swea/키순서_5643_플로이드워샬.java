package com.ssafy.study.swea;
import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 키순서_5643_플로이드워샬 {
	static int N, M;
	static int adj[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());// 학생들의 수(정점)
			M = Integer.parseInt(br.readLine());// 두 학생의 키를 비교한 횟수(간선)
			adj = new int[N + 1][N + 1]; // 자신보다 키가 큰 관계 표현

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				// a보다 b가 큼.
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				// 단방향,유향,큰애들 순서
				adj[a][b] = 1;
			}

			for (int k = 1; k <= N; k++) {// 경유(학생 k)
				for (int i = 1; i <= N; i++) {// 출발(학생 j)
					if (i == k || adj[i][k] == 0)
						continue; // 경유효과가 없음. 알수있는 관계 없음. i와 k와의 관계 가 없어 경유 불가.
					for (int j = 1; j <= N; j++) {// 도착(학생 i)
						// i<k<j : 학생 i보다 학생 k가 키가 크고 학생 k보다 학생 j가 키가 크면 고로 학생 i보다 학생j의 키가 크다.
						if (adj[i][j] == 1)
							continue;// 이미 i보다 j가 크다는 사실관계를 알면 패스

						adj[i][j] = adj[k][j];

					}
				}
			}

			int ans = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[i][0] += adj[i][j];// 자신보다 키가 큰 학생수 누적
					adj[0][j] += adj[i][j];// 자신보다 키가 작은 학생 수 누적
				}
			}

			Print();

			for (int i = 1; i <= N; i++) {
				if (adj[i][0] + adj[0][i] == N - 1)
					++ans;
			}

			System.out.println(ans);
		}

	}

	private static void Print() {
		for (int i = 0; i <= N; i++) {
			for (int j = 0; j <= N; j++) {
				System.out.print(adj[i][j]);
			}
		}
	}
}
