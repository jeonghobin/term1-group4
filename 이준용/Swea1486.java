package day0405;

import java.io.*;
import java.util.*;

public class Swea1486 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N,M;
	static int[]man;
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			man=new int[N];
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				man[i]=Integer.parseInt(st.nextToken());
			}
			
			recursive(new boolean[N],0);

			System.out.println("#"+t+" "+min);
			min=Integer.MAX_VALUE;
		}
	}
	
	static int min=Integer.MAX_VALUE;
	
	private static void recursive(boolean[] sel, int idx) {
		if(idx==N) {
			int sum=0;
			for(int i=0;i<N;i++) {
				if(sel[i]==true) {
					sum+=man[i];
				}
			}
			if(sum>=M) {
				min=Math.min(min, sum-M);
			}
			return;
		}
		
		sel[idx]=false;
		recursive(sel, idx+1);
		sel[idx]=true;
		recursive(sel, idx+1);
	}
}
