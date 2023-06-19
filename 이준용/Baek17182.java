package day0406;

import java.io.*;
import java.util.*;

public class Baek17182 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static int N;
	static int[][]map;
	static boolean[]v;

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		map=new int[N][N];
		v=new boolean[N];
		
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		for(int k=0;k<N;k++) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					map[i][j]=Math.min(map[i][j], map[i][k]+map[k][j]);
				}
			}
		}
		
		v[K]=true;
		dfs(K,1,0);
		System.out.println(min);
	}
	
	static int min=Integer.MAX_VALUE;

	private static void dfs(int n, int cnt, int sum) {	
		if(cnt==N) {
			min=Math.min(min, sum);
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(v[i])continue;
			v[i]=true;
			dfs(i,cnt+1,sum+map[n][i]);
			v[i]=false;
		}
	}
}
