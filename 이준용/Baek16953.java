package day0223;

import java.io.*;
import java.util.*;

public class Baek16953 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int A;
	static int B;
	

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		A=Integer.parseInt(st.nextToken());
		B=Integer.parseInt(st.nextToken());
		
		bfs(A);
		
		if(mincnt==Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(mincnt+1);
		}
		
	}

	static int mincnt=Integer.MAX_VALUE;

	private static void bfs(int a) {
		int cnt=0;
		Queue<Integer>q=new LinkedList<Integer>();
		q.offer(a);
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i2=0;i2<size;i2++) {
				int num=q.poll();
				if(num==B) {
					mincnt=Math.min(mincnt, cnt);
					return;
				}
				if(A*(cnt+1)*2>B) return;
				for(int i=0;i<2;i++) {
					if(i==0) {
						int nnum=num*2;
						if(nnum<=2000000000) {
							q.add(nnum);
						}
					}
					else {
						int nnum=num*10+1;
						if(nnum<=2000000000) {
							q.add(nnum);
						}
					}
				}
				
			}
			cnt++;
		}
	}
}
