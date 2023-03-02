package month3.day01.과제;

import java.util.*;
import java.io.*;

public class 게리 {
	static LinkedList<Integer>[] graph;
	static int[] num;
	static boolean[] visited, vi2, vi3;
	static int N;
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new LinkedList[N + 1];
		num = new int[N + 1];
		visited = new boolean[N + 1];

		for (int i = 1; i <= N; i++) {
			graph[i] = new LinkedList<Integer>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			for (int j = 0; j < n; j++) {
				int v = Integer.parseInt(st.nextToken());
				graph[i].add(v);
			}
		}
		// 두 선거구로 나누기(부분집합 -> 조합사용)
		for (int i = 1; i <= N / 2; i++) { ///???
			comb(i, 0, 1);
		}
		// 두선거구로 나누었는지 판단하기
		// 나누어졋으면 각각에 맞게 합을 구하여 차구하기
		if (min == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(min);

	}

	private static void comb(int r, int cnt, int start) {
		// TODO Auto-generated method stub
		if (cnt == r) {
			if (Truebfs() && Falsebfs()) {
				int a = 0, b = 0;
				for (int i = 1; i <= N; i++) {
					if (!visited[i]) {
						a += num[i];
					} else {
						b += num[i];
					}
				}
				min = Math.min(min, Math.abs(a - b));
			}
		}

		for (int i = start; i <= N; i++) {
			visited[i] = true;
			comb(r, cnt + 1, i + 1);
			visited[i] = false;
		}

	}

	private static boolean Falsebfs() {
		int cnt = 0;
		vi2 = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (!visited[i] && !vi2[i]) {
				bfs(i, visited[i], vi2);
				cnt++;
			}
		}
		if (cnt == 1)
			return true;
		return false;
	}

	private static boolean Truebfs() {
		int cnt = 0;
		vi3 = new boolean[N + 1];
		for (int i = 1; i <= N; i++) {
			if (visited[i] && !vi3[i]) {
				bfs(i, visited[i], vi3);
				cnt++;
			}
		}
		if (cnt == 1)
			return true;
		return false;
	}

	private static void bfs(int v, boolean visit, boolean[] vi) {
		Queue<Integer> que = new LinkedList<Integer>();
		que.offer(v);
		vi[v] = true;
		while (!que.isEmpty()) {
			int a = que.poll();
			for (int i = 0; i < graph[a].size(); i++) {
				if (visit == visited[graph[a].get(i)]) {
					if (!vi[graph[a].get(i)]) {
						vi[graph[a].get(i)] = true;
						que.offer(graph[a].get(i));
					}
				}
			}
		}

	}

}