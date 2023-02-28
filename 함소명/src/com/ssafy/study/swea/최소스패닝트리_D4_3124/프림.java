package com.ssafy.study.swea.최소스패닝트리_D4_3124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * ?????
 */
public class 프림 {
	static int V;
	static ArrayList<Vertex>[] adj;

	static class Vertex {
		int e, c;

		Vertex(int e, int c) {
			this.e = e;
			this.c = c;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());

			// 인접리스트
			adj = new ArrayList[V+1];
			for (int i = 1; i <= V; i++) {
				adj[i] = new ArrayList<Vertex>();
			}

			for (int i = 0; i < E; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());

				adj[a].add(new Vertex(b, c));
				adj[b].add(new Vertex(a, c));
			}

			// 정점 배열
			int[] Node = new int[V + 1];
			/***** 정점배열의 값을 무한대로 설정 *****/
			Arrays.fill(Node, Integer.MAX_VALUE);

			// 방문 배열
			boolean[] v = new boolean[V + 1];

			Node[0] = 0;

			/** v-1만큼 반복한다 **/
			for (int cnt = 0; cnt < V - 1; cnt++) {
				/** 방문하지 않은 정점 중 최소 간선을 갖는 정점을 찾는다 **/
				int minIdx = 1;
				int minNode = Integer.MAX_VALUE;
				for (int i = 1; i <= V; i++) {
					if (!v[i] && minNode > Node[i]) {
						minIdx = i;
						minNode = Node[i];
					}
				}

				/** 해당 최소 정점에 연결된 정점 중 
				 * 	방문되지 않은 정점에서 원래 있던 노드의 가중치보다 들어온 가중치가 더 작으면 업데이트한다.**/
				for (Vertex next : adj[minIdx]) {
					if (!v[next.e] && next.c < Node[next.e]) {
						Node[next.e] = next.c;
					}
				}
			}
			
			System.out.println(Arrays.toString(Node));
			
			/** 만들어진 트리의 가중치를 출력한다 **/
			int sum = 0;
			for (int i = 1; i <= V; i++) {
				sum += Node[i];
			}

			System.out.println(sum);

		}

	}

}
