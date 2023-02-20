package com.ssafy.study.beakjoon.DFS_BFS.beak_1260_Re;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * DFS와 BFS
 * DFS(Depth-first Search - 깊이우선탐색, 말그대로 그래프에서 가장 최상위 노드부터 하위노드까지 제일깊게 탐색하고, 다시 위로올라와서 깊게 깊게 탐색하는 방법
 * BFS(Breadth-first Search) - 너비우선탐색, 말 그대로 그래프에서 가장 최상위 노드부터 다음 차수(degree)를 모두 탐색하고, 그 다음차수를 모두 너비너비하게 탐색 하는 방법
 * 인접행렬이란 배열의 인덱스 i,j가 서로 바뀌어도 같은 1의 값을 가진것입니다
 */
public class Main {
	static int[][] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();// 정점의 개수
		int M = sc.nextInt();// 간선의 개수
		int V = sc.nextInt();// 정점 시작 번호

		//인접행렬 생성
        arr = new int[N+1][N+1];
        for(int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }

        dfs(new boolean[N + 1],V);

        System.out.println();

        bfs(new boolean[N + 1],V);
    }
    //깊이우선탐색(재귀)
    public static void dfs(boolean[] visited, int V) {
        visited[V] = true;
        System.out.print(V + " ");

        if(V == arr.length) {
            return;
        }
        for(int j = 1; j < arr.length; j++) {
            //연결은 되어있는데, 방문하지 않았다면 재귀
            if(arr[V][j] == 1 && visited[j] == false) {
                dfs(visited, j);
            }
        }
    }

    //너비우선탐색(큐)
    public static void bfs(boolean[] visited, int V) {
        Queue<Integer> que = new LinkedList<Integer>();

        que.add(V);
        visited[V] = true;
        System.out.print(V + " ");

        while(!que.isEmpty()) {
            int temp = que.poll();
            for(int i = 1; i < arr.length; i++) {
                if(arr[temp][i] == 1 && visited[i] == false) {
                    que.add(i);
                    visited[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}