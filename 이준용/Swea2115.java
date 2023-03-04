package day0304;

import java.io.*;
import java.util.*;

public class Swea2115 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,M,C;
	static int[][]map;
	//static boolean[][]v;
	//static int[]dc= {-1,1};

	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			M=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			map=new int[N][N];
			//v=new boolean[N][N];
			for(int i=0;i<N;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N-M+1;j++) {
					recursive(i,j,0,0);
				}
			}
			
			
		}
	}

	static int maxsum;
	
	private static void recursive(int r, int c, int cnt, int subsum) {
		if(cnt==2) {
			maxsum=Math.max(subsum, maxsum);
			return;
		}
		
		int[] list=new int[M];
		for(int i=0;i<M;i++) {
			list[i]=map[r][c+i];
		}
		recursive2(list, new boolean[M], 0, 0 );
		System.out.println();
		
		recursive(r, c+M-1, cnt+1, maxsubsum);
	}
	
	static int cnt=1;
	
	static int maxsubsum;

	private static void recursive2(int[] list, boolean[] v, int idx, int k) {
		if(k==M) {
			int subsum=0;
			int subpow=0;
			for(int i=0;i<M;i++) {
				if(v[i]==true) {
					subsum+=list[i];
					subsum+=list[i]*list[i];
				}
			}
			if(subsum<=C) {
				maxsubsum=Math.max(maxsubsum, subpow);
			}
			return;
		}
		
		v[k]=true;
		recursive2(list, v, idx, k+1);
		v[k]=false;
		recursive2(list, v, idx, k+1);
	}

}
