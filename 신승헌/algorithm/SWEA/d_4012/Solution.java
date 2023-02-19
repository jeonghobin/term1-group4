package algo.swea.d_4012;

import java.io.*;
import java.util.*;

public class Solution {
	
	static boolean[] v;
	static Queue<Integer> taste;
	static int minTaste;
	static int aTaste;
	static int bTaste;
	static int synergy[][];

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		int T = Integer.parseInt(st.nextToken()); 
		
		for(int test_case = 1; test_case <= T; test_case++) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 음식의 개수
			
			int[] arr = new int[N];
			for (int i = 0; i < arr.length; i++) {
				arr[i] = i;
			}
			
			synergy = new int[N][N]; // 시너지
			
			for (int i = 0; i < synergy.length; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < synergy[0].length; j++) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			recursion(arr, new int[N/2], 0, 0);
			minTaste = Integer.MAX_VALUE;
			
			while (!q.isEmpty()) {
				int[] foodA = q.poll();
//				ArrayList<Integer> foodB = new ArrayList<Integer>();
				int[] foodB = new int[N/2];
				v = new boolean[N];
				taste = new LinkedList<>();
				
				for (int i = 0; i < foodA.length; i++) {
					v[foodA[i]] = true;
				}
				
				int counter = 0;
				for (int i = 0; i < v.length; i++) {
					if (v[i] == false) {
						foodB[counter] = i;
						counter++;
					}
				}

				aTaste = 0;
				bTaste = 0;
				
				recursion2(foodA, new int[2], 0, 0);
				while(!taste.isEmpty()) {
					aTaste += taste.poll();
				}
				
				recursion2(foodB, new int[2], 0, 0);
				while(!taste.isEmpty()) {
					bTaste += taste.poll();
				}
				
				int compareTaste = Math.abs(aTaste - bTaste);
				minTaste = Math.min(minTaste, compareTaste);
				

			}
			System.out.println("#" + test_case + " " + minTaste);
			
		} // [E] test_case
		
		
	}
	
	static class Point {
		int[] x;

		public Point(int[] x) {
			this.x = x;
		}
	}
	
	static Queue<int[]> q = new LinkedList<>();
	
	private static void recursion(int[] arr, int[] sel, int aIdx, int sIdx) {
		// basis part
		if (sIdx == sel.length) {
			q.offer(Arrays.copyOf(sel, sel.length));
			return;
		}

		// inductive part
		for (int i = aIdx; i < arr.length; i++) {
			sel[sIdx] = arr[i];
			recursion(arr, sel, i + 1, sIdx + 1);
		}
	}
	
	
	private static void recursion2(int[] arr, int[] sel, int aIdx, int sIdx) {
		// basis part
		if (sIdx == sel.length) {
			taste.offer( synergy[sel[0]][sel[1]] + synergy[sel[1]][sel[0]] );
			return;
		}
		
		// inductive part
		for (int i = aIdx; i < arr.length; i++) {
			sel[sIdx] = arr[i];
			recursion2(arr, sel, i + 1, sIdx + 1);
		}
	}
}
