package day03;

import java.io.*;
import java.util.*;

public class 연구소_prof {
	
	static int N, M;
	static int answer = Integer.MIN_VALUE;
	static int[][] map;
	static int[][] copyMap;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		copyMap = new int[N][M];
		
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				map[r][c] = sc.nextInt();
			}
		}
		
		// 첫 번째 벽을 세우는 위치
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				// 벽을 세울 수 있는 위치라면
				if(map[x][y] == 0) {
					mapCopy(map, copyMap);
					// 첫 번째 벽을 설치
					copyMap[x][y] = 1;
					recursive(1);
				}
			}
		}	
		System.out.println(answer==Integer.MIN_VALUE?0:answer);
	}

	
	private static void recursive(int cnt) {
		// 쌓은 벽의 개수가 3개라면
		if(cnt == 3) {
			
			// 바이러스 퍼뜨려서 안전공간 크기 계산
			solve();
			return;
		}
		
		// 다음 벽을 설치할 공간 찾기
		for (int x = 0; x < copyMap.length; x++) {
			for (int y = 0; y < copyMap[x].length; y++) {
				if(copyMap[x][y] == 0) {
					copyMap[x][y] = 1;
					recursive(cnt + 1);
					copyMap[x][y] = 0;
				}
			}
		}
		
		
		
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	static class Point {
		int x, y;
		
		Point(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private static void solve() {
		int[][] virusMap = new int[N][M];
		mapCopy(copyMap, virusMap);
		
		// bfs
		Queue<Point> q = new LinkedList<>();
		
		for (int i = 0; i < virusMap.length; i++) {
			for (int j = 0; j < virusMap[i].length; j++) {
				if(virusMap[i][j] == 2) {
					q.offer(new Point(i, j));
				}
			}
		}
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			for (int d = 0; d < dx.length; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				
				if (nx >= 0 && nx < N && ny >= 0 && ny < M && virusMap[nx][ny] == 0) {
					virusMap[nx][ny] = 2;
					q.offer(new Point(nx, ny));
				}
			}
		}
		
		// 안전영역 세기
		int cnt = 0;
		for (int i = 0; i < virusMap.length; i++) {
			for (int j = 0; j < virusMap[i].length; j++) {
				if(virusMap[i][j] == 0) {
					cnt++;
				}
			}
		}
		
		answer = Math.max(answer, cnt);
		
	}


	private static void mapCopy(int[][] map, int[][] copyMap) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map[i].length; j++) {
				copyMap[i][j] = map[i][j];
			}
		}
	}
}
