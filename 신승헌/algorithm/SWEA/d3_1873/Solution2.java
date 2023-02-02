package swea.d3_1873;

import java.io.*;
import java.util.*;

public class Solution2 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		// 상 하 좌 우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int tankX = -1; // 탱크 위치
			int tankY = -1;
			int tankRotate = -1; // 탱크 방향
			
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken()); // X
			int W = Integer.parseInt(st.nextToken()); // Y
			
			String[][] map = new String[H][W];
			
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				String[] row = st.nextToken().split("");
				
				for (int j = 0; j < row.length; j++) {
					map[i][j] = row[j];
					
					if ( row[j].equals("^") ) {
						tankRotate = 0;
						tankX = i;
						tankY = j;
						
					} else if ( row[j].equals("v") ) {
						tankRotate = 1;
						tankX = i;
						tankY = j;
						
					} else if ( row[j].equals("<") ) {
						tankRotate = 2;
						tankX = i;
						tankY = j;
						
					} else if ( row[j].equals(">") ) {
						tankRotate = 3;
						tankX = i;
						tankY = j;
					}
					
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			String move = st.nextToken();
			
			for (int i = 0; i < move.length(); i++) {
				if (move.charAt(i) == 'U') {
					tankRotate = 0;
					int cx = tankX + dx[tankRotate];
					int cy = tankY + dy[tankRotate];
					
					if (cx >= 0 && cx < H && cy >= 0 && cy < W && map[cx][cy].equals(".")) {
						map[tankX][tankY] = ".";
						tankX = cx;
						tankY = cy;
					}
					map[tankX][tankY] = "^";
				}
				
				if (move.charAt(i) == 'D') {
					tankRotate = 1;
					int cx = tankX + dx[tankRotate];
					int cy = tankY + dy[tankRotate];
					
					if (cx >= 0 && cx < H && cy >= 0 && cy < W && map[cx][cy].equals(".")) {
						map[tankX][tankY] = ".";
						tankX = cx;
						tankY = cy;
					}
					map[tankX][tankY] = "v";
				}
				
				if (move.charAt(i) == 'L') {
					tankRotate = 2;
					int cx = tankX + dx[tankRotate];
					int cy = tankY + dy[tankRotate];
					
					if (cx >= 0 && cx < H && cy >= 0 && cy < W && map[cx][cy].equals(".")) {
						map[tankX][tankY] = ".";
						tankX = cx;
						tankY = cy;
					}
					map[tankX][tankY] = "<";
				}
				
				if (move.charAt(i) == 'R') {
					tankRotate = 3;
					int cx = tankX + dx[tankRotate];
					int cy = tankY + dy[tankRotate];
					
					if (cx >= 0 && cx < H && cy >= 0 && cy < W && map[cx][cy].equals(".")) {
						map[tankX][tankY] = ".";
						tankX = cx;
						tankY = cy;
					}
					map[tankX][tankY] = ">";
				}
				
				if (move.charAt(i) == 'S') {
					for (int j = 1; true; j++) {
						int cx = tankX + (dx[tankRotate] * j);
						int cy = tankY + (dy[tankRotate] * j);
						if (cx >= 0 && cx < H && cy >= 0 && cy < W) { // 지도 범위 내라면
							if (map[cx][cy].equals("*")) { // 벽돌을 만나면
								map[cx][cy] = ".";
								break;
							}
							
							if (map[cx][cy].equals("#")) { // 강철벽을 만나면
								break;
							}
							
						} else { // 범위를 벗어나면
							break;
						}
					}
				}
				
			}
			
			System.out.print("#" + test_case + " ");
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j < map[i].length; j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
			
		} // [E] Test Case
		
	}
}
