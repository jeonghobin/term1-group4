package com.ssafy.study.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 치즈도둑
 * 100일 동안 요정이 치즈를 먹을 때 덩어리가 가장 많이 남을 때 갯수(맛있는 정도는 1부터 100)
 * X번째날에는 맛있는 정도가 X인 칸을 먹어버린다.
 * 
 * 접근 -> 먹어버린 것의 남은 치즈 덩어리를 세는 것이니까 BFS를 돌림.
 * 
 */

public class D4_7733 {
	static int N;
	static int[][] map;
	static boolean[][] v;
	static int max;
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			max = 1;//치즈가 모두 녹을 경우, 덩어리 개수는 1 
			for (int day = 0; day <= 100; day++) {
				v = new boolean[N][N];
				cnt = 0;
				//먹기
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (map[i][j] == day) {
							map[i][j] = 0;
							v[i][j] = true;
						}
					}
				}

				//덩어리 개수 세기
				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!v[i][j] && map[i][j] != 0) {
							cnt++;
							BFS(i, j);
						}
					}
				}
				
				max = Math.max(max, cnt);
			}

			System.out.println("#" + test_case + " " + max);
		}
	}

	static int[] dr = { 0, 0, -1, 1 };
	static int[] dc = { -1, 1, 0, 0 };
	
    private static void BFS(int x,int y) {
        Queue<int[]> Q = new LinkedList<int[]>();
        v[x][y] = true;
        Q.offer(new int[] {x,y});
        
        while(!Q.isEmpty()) {
        	int[] n = Q.poll();
    		
        	for (int k = 0; k < 4; k++) {
    			int nx = n[0] + dr[k];
    			int ny = n[1] + dc[k];
    			
    			if (nx >= 0 && ny >= 0 && nx < N && ny < N && !v[nx][ny] && map[nx][ny] != 0) {
                    v[nx][ny] = true;
                    Q.offer(new int[] {nx,ny});
                }
            }
        }
    }


}
