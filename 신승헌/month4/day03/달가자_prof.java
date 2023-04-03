package day03;

import java.io.*;
import java.util.*;


/*
 * # : 벽
 * a-f : 열쇠
 * A-F : 문
 * 0 : 현재 위치
 * 
 */
public class 달가자_prof {
	static int N, M, Sx, Sy;
	static int answer = Integer.MAX_VALUE;
	static char[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		
		for (int r = 0; r < N; r++) {
			String str = sc.next();
			for (int c = 0; c < M; c++) {
				map[r][c] = str.charAt(c);
				if (map[r][c] == '0') {
					Sx = r;
					Sy = c;
				}
			}
		}
		
		print(map);
		
		bfs();
		
		
		System.out.println(answer == Integer.MAX_VALUE?-1:answer);
	}
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	
	
	static class Point {
		int x, y, cnt, key; 

		public Point(int x, int y, int cnt, int key) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.key = key; // 비트마스킹
		}
	}
	
	private static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][][] v = new boolean[N][M][1<<6];
		q.offer(new Point(Sx, Sy, 0, 0));
		v[Sx][Sy][0] = true;
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			
			if (map[p.x][p.y] == '1') {
				answer = Math.min(answer, p.cnt);
				break;
			}
			
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];
				int nkey = p.key;

				if(nx >= 0 && nx < N && ny >= 0 && ny < M && !v[nx][ny][nkey] && map[nx][ny] != '#' ) {
					// 키를 만났을 경우 키를 습득함
					if (map[nx][ny] >= 'a' && map[nx][ny] <= 'f') {		
						// | 삽입
						nkey = nkey | ( 1 << (map[nx][ny] - 'a') );
					}
					
					// nkey = nkey & ( 1 << (map[nx][ny] - 'a') );

					// 문을 만났을 경우, 키 여부에 따라서 결정
					// 키가 있으면 지나감, 키가 없으면 못감
					if (map[nx][ny] >= 'A' && map[nx][ny] <= 'F') {	
						// & : 있는지 여부 판단
						// > 0 : 키가 있다면 | == 0 : 키가 없다면
						if (( nkey & ( 1 << (map[nx][ny] - 'a'))) == 0  ) {
							continue;
						}
					}
					v[nx][ny][nkey] = true;
					q.offer(new Point(nx, ny, p.cnt+1, nkey));
				}
			}
		}
	}
	private static void print(char[][] map) {
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				System.out.print(map[r][c] + " ");
			}
			System.out.println();
		}
	}
}
