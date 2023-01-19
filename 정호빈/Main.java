package baekjoon;

import java.util.*;
import java.io.*;


public class Main {
	
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int i=1;
		while(i*i<N) {
			i++;
		}
		if(i*i==N) {
			System.out.println(i);
		}
		else if(i*i>N) {
			System.out.println(i-1);
		}
 	}
	
	
	
}

	

