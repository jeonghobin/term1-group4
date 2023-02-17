package algo.bj.b4_10162;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[3];
		
		if (T % 10 != 0) {
			System.out.println(-1);
			return;
		}
		
		arr[0] = T / 300;
		T = T % 300;
		arr[1] = T / 60;
		T = T % 60;
		arr[2] = T / 10;
		
		System.out.println(arr[0] + " " + arr[1] + " " + arr[2] + " ");
		
		
	}
}
