package com.ssafy.study.swea;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//인접리스트로 푸는게 더 효율적이다.
public class 키순서_5643_dfs {
	static int N, M,cnt;
	static int adj[][], radj[][];

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());//학생들의 수(정점)
			M = Integer.parseInt(br.readLine());//두 학생의 키를 비교한 횟수(간선)
			adj = new int[N+1][N+1]; //자신보다 키가 큰 관계 표현
			radj = new int[N+1][N+1]; //자신보다 키가 작은 관계 표현
			
			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				//a보다 b가 큼.
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				
				//단방향,유향
				//역인접행렬을 생성해서 
				//작은애들 순서, 큰애들 순서 모두 받는다.
				radj[b][a] = adj[a][b] = 1;
			}
			
			

			int ans = 0;
			for (int i = 1; i <= M; i++) {
				cnt = 0;
				dfs(i,adj, new boolean[N+1]);//커지는
				dfs(i,radj, new boolean[N+1]);//작아지는
				if(cnt == N-1) ans++;
			}
			System.out.println(ans);
		}

	}

	private static void dfs(int cur, int[][] adj, boolean[] v) {
		
		//dfs는 밖에서 방문체크
		v[cur] = true;
		
		//adj : 자신보다 큰관계 인접행렬이면 자신보다 큰 정점 탐색
		//adj : 자신보다 작은관계 인접행렬이면 자신보다 작은 정점 탐색
		for (int i = 1; i <= M; i++) {
			if(adj[cur][i]==1 && !v[i]) {
				cnt++;
				dfs(i,adj, v);
			}
		}
	}
}
