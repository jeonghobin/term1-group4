package homework.Baekjoon.s1_2564;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int width = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int storeCount = Integer.parseInt(st.nextToken());
		
		int[] distance = new int[storeCount + 1];
		
		for (int i = 0; i < distance.length; i++) {
			st = new StringTokenizer(br.readLine());
			
			int block = Integer.parseInt(st.nextToken());
			int blockDistance = Integer.parseInt(st.nextToken());
			
			if (block == 1) { // 북
				blockDistance += 0;
			} else if (block == 4) { // 동
				blockDistance += width;
			} else if (block == 2) { // 남
				blockDistance = width + height + width - blockDistance;
			} else if (block == 3) {
				blockDistance = width + height + width + height - blockDistance;
			}
			
			distance[i] = blockDistance;
		}
		
		int totalDistance = width * 2 + height * 2;
		int answer = 0;
		int me = distance[distance.length - 1];
		for (int i = 0; i < distance.length - 1; i++) {
			int leftDistance = Math.abs(distance[i] - me);
			int rightDistance = totalDistance - Math.max(distance[i], me) + Math.min(distance[i], me);
			
			answer += Math.min(leftDistance, rightDistance);
		}
		System.out.println(answer);
	}

}
