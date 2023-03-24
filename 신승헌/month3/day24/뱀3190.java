import java.io.*;
import java.util.*;

public class 골드뱀 {
	
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 첫 번째 줄
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		int d = 1;
		int nowX = 0;
		int nowY = 0;
		int tailX = 0;
		int tailY = 0;
		int answer = 0;
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				map[i][j] = 7;
			}
		}
		
		map[0][0] = 1;
		
		// 두 번째 줄
		st = new StringTokenizer(br.readLine());
		int K = Integer.parseInt(st.nextToken());

		for (int i = 0; i < K; i++) {
			// 나머지 줄
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			map[x][y] = 9; // 사과 9
		}
		
		// 세 번째 줄
		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		int before = 0;
		for (int i = 0; i < L + 1; i++) {
			
			if (i == L) {
				for (int j = 0; j < map.length; j++) {
//					print(map);
					int x = nowX + dx[d]; 
					int y = nowY + dy[d];
					
					answer++;

					if ( !(x >= 0 && x < map.length && y >= 0 && y < map.length) ) {
						System.out.println(answer);
						return;
					}
					
					// 사과라면
					if (map[x][y] == 9) {
						map[x][y] = d;
						nowX = x;
						nowY = y;
					} 
					// 빈칸이면
					else if (map[x][y] == 7) {
						map[x][y] = d;
						nowX = x;
						nowY = y;
						
						int delX = tailX;
						int delY = tailY;
						tailX = tailX + dx[map[delX][delY]];
						tailY = tailY + dy[map[delX][delY]];
						map[delX][delY] = 7;

					} 
					// 지나간 곳이라면
					else {
						System.out.println(answer);
						return;
					}
				}
			}
			
			// 나머지 줄
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			String rotate = st.nextToken();
			
			for (int j = before; j < time; j++) {
//				print(map);
				int x = nowX + dx[d]; 
				int y = nowY + dy[d];
				
				answer++;

				if ( !(x >= 0 && x < map.length && y >= 0 && y < map.length) ) {
					System.out.println(answer);
					return;
				}
				
				// 사과라면
				if (map[x][y] == 9) {
					map[x][y] = d;
					nowX = x;
					nowY = y;
				} 
				// 빈칸이면
				else if (map[x][y] == 7) {
					map[x][y] = d;
					nowX = x;
					nowY = y;
					
					int delX = tailX;
					int delY = tailY;
					tailX = tailX + dx[map[delX][delY]];
					tailY = tailY + dy[map[delX][delY]];
					map[delX][delY] = 7;

				} 
				// 지나간 곳이라면
				else {
					System.out.println(answer);
					return;
				}
				
				
				if (j == time - 1) {
					if (rotate.equals("L")) {
						d = d - 1;
						if (d == -1) {
							d = 3;
						}
						map[nowX][nowY] = d;
					} else {
						d = (d + 1) % 4;
						map[nowX][nowY] = d;
					}
					before = time;
				}
				
			}
			
		}
		
		System.out.println(answer);
	}
	private static void print(int[][] map) {
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
	}
}
