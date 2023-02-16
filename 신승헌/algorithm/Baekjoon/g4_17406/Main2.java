package algo.bj.g4_17406;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main2 {
	
	static int[] rs;
	static int[] ss;
	static int[] cs;
	static int[][] arrs;
	static int[][] arr;
	static int[] dx;
	static int[] dy;
	static int minRow = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 행
		int M = Integer.parseInt(st.nextToken()); // 열
		int K = Integer.parseInt(st.nextToken()); // 회전 횟수
		
		arr = new int[N][M];
		arrs = new int[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}	
		
		dx = new int[]{0, 1, 0, -1};
		dy = new int[]{1, 0, -1, 0};
		
		rs = new int[K];
		cs = new int[K];
		ss = new int[K];
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			
			rs[i] = Integer.parseInt(st.nextToken());
			cs[i] = Integer.parseInt(st.nextToken());
			ss[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] array = new int[K];
		for (int i = 0; i < K; i++) {
			array[i] = i;
		}
		
		recursive(array, new int[K], new boolean[K], 0);
		
		System.out.println(minRow);
	}

	private static void recursive(int[] array, int[] sel, boolean[] v, int sIdx) {
		// basis part
		if (sel.length == sIdx) {
//			System.out.println(Arrays.toString(sel));
			rot(sel);
			return;
		}
		
		// inductive part
		for (int i = 0; i < array.length; i++) {
			if (v[i] == false) {
				v[i] = true;
				sel[sIdx] = array[i];
				recursive(array, sel, v, sIdx + 1);
				v[i] = false;
			}
		}
		
	}

	private static void rot(int[] sel) {
		for (int i = 0; i < arr.length; i++) {
//			arrs[i] = Arrays.copyOf(arr[i], arr.length);
			arrs[i] = arr[i].clone();
		}
		
		for (int i = 0; i < sel.length; i++) {
			int r = rs[sel[i]];
			int c = cs[sel[i]];
			int s = ss[sel[i]];
			
			System.out.println(r + " " + c + " " + s);
			
			// 1) -1 : 1,1부터 시작하는 위치 변경
			// 2) -1/+1 : for문 돌릴 때 위치 조정을 위해서
			int startX = r - s -1 -1;
			int startY = c - s -1 -1;
			int endX = r + s -1 + 1;
			int endY = c + s -1 + 1;

	
			for (int j = 0; j < ((r+s) - (r-s)) / 2  ; j++) {
				startX += 1;
				startY += 1;
				endX -= 1;
				endY -= 1;
				
				int temp = arrs[startX][startY];
				int x = startX;
				int y = startY;
				int rotate = 0;
				int cx = x;
				int cy = y;
				while (true) {
					cx += dx[rotate];
					cy += dy[rotate];
					if (cx == startX && cy == startY) {
						arrs[cx][cy] = temp;
						break;
					}
					if ( cx < startX || cx > endX || cy < startY || cy > endY) {
						cx -= dx[rotate];
						cy -= dy[rotate];
						rotate = (rotate + 1) % 4;
						continue;
					}

					int now = arrs[cx][cy];
					arrs[cx][cy] = temp;
					temp = now;
				}
			}		
		}
		
//		System.out.println();
//		print(arrs);
//		System.out.println();
		
		
		for (int j = 0; j < arrs.length; j++) {
			int nowRow = 0;
			for (int k = 0; k < arrs[0].length; k++) {
				nowRow += arrs[j][k];
			}
			if (minRow > nowRow) {
				minRow = nowRow;
			}
		}
	}
	
	private static void print(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
