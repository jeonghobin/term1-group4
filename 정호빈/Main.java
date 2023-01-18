package baekjoon;

import java.util.*;
import java.io.*;


public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		System.out.println(pibo(N));
 	}
	public static int pibo(int num) {
		if(num==0) return 0;
		if(num==1) return 1;
		return pibo(num-1)+pibo(num-2);
	}
	
	
}

	

