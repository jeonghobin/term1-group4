package baekjoon;

import java.util.*;
import java.io.*;


public class Main {
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		Queue<Integer> que = new LinkedList<Integer>();
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		for(int i=1;i<=N;i++) {
			que.offer(i);
		}
		System.out.print("<");
		while(!que.isEmpty()&&que.size()>1) {
			for(int i=0;i<K-1;i++) {
				que.offer(que.poll());
			}
			System.out.print(que.poll()+", ");
		}
		System.out.print(que.poll()+">");
		
 	}
	
	
	
}

	

