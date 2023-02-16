package algo.bj.b1_2775;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
	
		int[][] arr = new int[15][15];
		
		for (int i = 0; i < arr.length; i++) {
			arr[0][i] = i;
		}
		
		for (int i = 1; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				for (int i2 = 0; i2 <= i; i2++) {
					for (int j2 = 0; j2 < j; j2++) {
						int s = arr[i2][j2];
						arr[i][j] += arr[i2][j2];
					}
				}
			}				
		}
		
		System.out.println();
		
		
//		int T = Integer.parseInt(st.nextToken());
//		for (int i = 0; i < T; i++) {
//			st = new StringTokenizer(br.readLine());
//			int k = Integer.parseInt(st.nextToken());
//			
//			st = new StringTokenizer(br.readLine());
//			int n = Integer.parseInt(st.nextToken());
			
			
			
//		}
	}
}
