package swea.d3_1873;

import java.io.*;
import java.util.*;

// testcase 97개 중 93개 맞음
public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		// 상 하 좌 우
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int[] tank = new int[2]; // 탱크 위치
			int tankRotate = -1; // 탱크 방향
			st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			String[][] map = new String[H][W];
			for (int i = 0; i < map.length; i++) {
				st = new StringTokenizer(br.readLine());
				String[] row = st.nextToken().split("");
				
				for (int j = 0; j < map[i].length; j++) {
					map[i][j] = row[j]; // 문자열 하나씩 맵 배열에 저장
					
					if ( row[j].equals("^") ) {
						tankRotate = 0;
						tank[0] = i;
						tank[1] = j;
						
					} else if ( row[j].equals("v") ) {
						tankRotate = 1;
						tank[0] = i;
						tank[1] = j;
						
					} else if ( row[j].equals("<") ) {
						tankRotate = 2;
						tank[0] = i;
						tank[1] = j;
						
					} else if ( row[j].equals(">") ) {
						tankRotate = 3;
						tank[0] = i;
						tank[1] = j;
					}
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int count = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			String move = st.nextToken();
			
			for (int i = 0; i < move.length(); i++) {
				char nowMove = move.charAt(i);
				
				if (nowMove == 'U') {
					tankRotate = 0;
					if (tank[0] + dx[tankRotate] >= 0 && tank[0] + dx[tankRotate] < H && tank[1] + dy[tankRotate] >= 0 && tank[1] + dy[tankRotate] < W
							) {
						if (map[ tank[0] + dx[tankRotate] ][ tank[1] + dy[tankRotate] ].equals(".")) {
							map[tank[0]][tank[1]] = ".";
							tank[0] = tank[0] + dx[tankRotate];
							tank[1] = tank[1] + dy[tankRotate];
							map[tank[0]][tank[1]] = "^";
						} else {
							map[tank[0]][tank[1]] = "^";
						}

					}
				} else if (nowMove == 'D') {
					tankRotate = 1;
					if (tank[0] + dx[tankRotate] >= 0 && tank[0] + dx[tankRotate] < H && tank[1] + dy[tankRotate] >= 0 && tank[1] + dy[tankRotate] < W // 범위를 벗어나지 않는다면
						) {
						if (map[ tank[0] + dx[tankRotate] ][ tank[1] + dy[tankRotate] ].equals(".")) { // 평지라면
							map[tank[0]][tank[1]] = "."; // 기존 위치를 .으로 바꾸고
							tank[0] = tank[0] + dx[tankRotate]; // x 좌표 위치 정보 변경
							tank[1] = tank[1] + dy[tankRotate]; // y 좌표 위치 정보 변경
							map[tank[0]][tank[1]] = "v"; // 지도의 현재 탱크 위치 작성
						}
						else {
							map[tank[0]][tank[1]] = "v"; // 탱크 위치 작성
						}
					}
				} else if (nowMove == 'L') {
					tankRotate = 2;
					if (tank[0] + dx[tankRotate] >= 0 && tank[0] + dx[tankRotate] < H && tank[1] + dy[tankRotate] >= 0 && tank[1] + dy[tankRotate] < W
						) {
						if (map[ tank[0] + dx[tankRotate] ][ tank[1] + dy[tankRotate] ].equals(".")) {
							map[tank[0]][tank[1]] = ".";
							tank[0] = tank[0] + dx[tankRotate];
							tank[1] = tank[1] + dy[tankRotate];
							map[tank[0]][tank[1]] = "<";
						}
						else {
							map[tank[0]][tank[1]] = "<";
						}
						
					}
				} else if (nowMove == 'R') {
					tankRotate = 3;
					if (tank[0] + dx[tankRotate] >= 0 && tank[0] + dx[tankRotate] < H && tank[1] + dy[tankRotate] >= 0 && tank[1] + dy[tankRotate] < W
					) {
						if (map[ tank[0] + dx[tankRotate] ][ tank[1] + dy[tankRotate] ].equals(".")) {
							map[tank[0]][tank[1]] = ".";
							tank[0] = tank[0] + dx[tankRotate];
							tank[1] = tank[1] + dy[tankRotate];
							map[tank[0]][tank[1]] = ">";
						}
						else {
							map[tank[0]][tank[1]] = ">";
						}

					}
				} else if (nowMove == 'S') {
					for (int k = 1; true; k++) {
						if (tank[0] + dx[tankRotate] * k >= 0 && tank[0] + dx[tankRotate] * k < H && tank[1] + dy[tankRotate] * k >= 0 && tank[1] + dy[tankRotate] * k < W) {
							if (map[ tank[0] + dx[tankRotate] * k ][ tank[1] + dy[tankRotate] * k ].equals("*")) { // 벽돌을 만나면
								map[ tank[0] + dx[tankRotate] * k ][ tank[1] + dy[tankRotate] * k ] = ".";
								break;
							} else if (map[ tank[0] + dx[tankRotate] * k ][ tank[1] + dy[tankRotate] * k ].equals("#")) { // 강철을 만나면
								break;
							} else { // 평지이거나 물이라면
								continue;
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
			
		}
	}
}
