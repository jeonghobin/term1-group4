package homwork.SWEA.d3_4615;

import java.io.*;
import java.util.*;

public class Solution {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("res/d3_4615/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		int[] dx = {0, -1, -1, -1, 0, 1, 1, 1};
		int[] dy = {-1, -1, 0, 1, 1, 1, 0, -1};
		
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 판 크기
			int M = Integer.parseInt(st.nextToken()); // 돌놓는 횟수
			
			
		
			
			int[][] array = new int[N][N];
			
			int mid = N / 2;
			array[mid - 1][mid - 1] = 2;
			array[mid - 1][mid] = 1;
			array[mid][mid - 1] = 1;
			array[mid][mid] = 2;
			
			int white = 0;
			int black = 0;
			
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken()) -1; 
				int Y = Integer.parseInt(st.nextToken()) -1; 
				int color = Integer.parseInt(st.nextToken()); 
				
				array[X][Y] = color;
				
				for (int j = 0; j < dx.length; j++) {
					LinkedList<Integer> cx = new LinkedList<>();
					LinkedList<Integer> cy = new LinkedList<>();
					
					for (int k = 1; k < N; k++) {
						if (X + (dx[j] * k) >= 0 && X + (dx[j] * k) < N && Y + (dy[j] * k) >= 0 && Y + (dy[j] * k) < N) {
							if (array[X + (dx[j] * k)][Y + (dy[j] * k)] == 0) {
								break;
							}
							
							if(array[X + (dx[j] * k)][Y + (dy[j] * k)] != color) {
								cx.add(X + (dx[j] * k));
								cy.add(Y + (dy[j] * k));
							} 
							if (array[X + (dx[j] * k)][Y + (dy[j] * k)] == color) {
								for (int l = 0; l < cx.size(); l++) {
									array[cx.get(l)][cy.get(l)] = color;
								}
								break;
							} 
						}
						
					}
				}
			}
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (array[i][j] == 1) {
						black += 1;
					} else if (array[i][j] == 2) {
						white += 1;
					}
				}
			}
			
			sb.append("#" + test_case + " " + black + " " + white + "\n");
			
			
		}
		System.out.println(sb);
	}
}
