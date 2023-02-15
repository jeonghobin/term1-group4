package day0215;

import java.io.*;
import java.util.*;

public class Baek18405 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;

	static int[][] map;
	static boolean[][] v;
	static int S;
	static int X;
	static int Y;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());
		
		map=new int[N][N];
		v=new boolean[N][N];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		st=new StringTokenizer(br.readLine());
		S=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		Y=Integer.parseInt(st.nextToken());
		
		int print=map[X-1][Y-1];
		L: for(int s=0;s<S;s++) {
			for(int k=1;k<=K;k++) {
				for(int i=0;i<N;i++) {
					for(int j=0;j<N;j++) {
						if(v[i][j]==false&&map[i][j]==k) {
							bfs(i,j,k);
							if(map[X-1][Y-1]!=0) {
								print=map[X-1][Y-1];
								break L;
							}
						}
						
					}
				}
				for(int i2=0;i2<N;i2++) {
					for(int j2=0;j2<N;j2++) {
						v[i2][j2]=false;
					}
				}
			}
			
		}
		bw.write(print+"");
		bw.close();

	}
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}
	
	private static void bfs(int i, int j, int k) {

		v[i][j]=true;
		for(int d=0;d<4;d++) {
			int nr=i+dr[d];
			int nc=j+dc[d];
	
			if(nr>=0&&nr<N&&nc>=0&&nc<N&&v[nr][nc]==false&&map[nr][nc]==0) {
				map[nr][nc]=k;
				v[nr][nc]=true;
			}
		}
	}
}
