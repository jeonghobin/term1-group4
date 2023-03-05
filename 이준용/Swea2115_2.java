package day0304;

import java.io.*;
import java.util.*;

public class Swea2115_2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M,C;
	static int[][]map;
	static boolean[][]v;



	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			map=new int[N][N];
			v=new boolean[N][N];

			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-M+1;j++) {
					for(int i2=0;i2<M;i2++) {
						v[i][j+i2]=true;
					}
					recursive(i,j,0,0);
				}
			}

			//recursive(0, 0, 0, 0);
			
			System.out.println(maxsum);
			maxsum=0;
			
		}
	}

	static int maxsum;

	private static void recursive(int r, int c, int cnt, int sum) {
		if(cnt==2) {
			System.out.println(sum);
			maxsum=Math.max(maxsum, sum);
			return;
		}
		
		
		

		for(int i=0;i<N;i++) {
			for(int j=0;j<N-M+1;j++) {
				if(v[i][j]==false) {
					int[]list=new int[M];
					for(int i2=0;i2<M;i2++) {
						list[i2]=map[i][j+i2];
						
					}
					v[i][j]=true;
					submaxsum=0;
					recursive2(list, new boolean[M], 0, 0);
					recursive(0, 0, cnt+1, sum+submaxsum);
				}
			}
		}
	}
	
	static int submaxsum;

	private static void recursive2(int[] list, boolean[] sel, int idx, int k) {
		if(k==M) {
			int subsum=0;
			int subpow=0;
			for(int i=0;i<M;i++) {
				if(sel[i]==true) {
					subsum+=list[i];
					subpow+=list[i]*list[i];
				}
			}
			if(subsum<=C) {
				submaxsum=Math.max(submaxsum, subpow);
			}
			return;
		}
		
		sel[k]=false;
		recursive2(list, sel, idx, k+1);
		sel[k]=true;
		recursive2(list, sel, idx, k+1);
	}
}
