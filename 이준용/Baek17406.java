package day0216;

import java.io.*;
import java.util.*;

public class Baek17406 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int K;
	static int[] klist;
	
	static int[][]map;
	static int[][]mission;
	static int[][]newmission;
	static int[]dx= {0,1,0,-1};
	static int[]dy= {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		mission=new int[K][3];
		newmission=new int[K][3];
		
		for(int i=0;i<K;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<3;j++) {
				mission[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		klist=new int[K];
		boolean[]v=new boolean[K];
		for(int i=0;i<K;i++) {
			klist[i]=i;
		}
		recursive(new int[K],v,0);
		
		bw.write(minsum+"");
		bw.close();
	}
	
	private static void recursive(int[] sel, boolean[] v2, int k) {
		if(k==sel.length) {
			for(int i=0;i<K;i++) {
				for(int j=0;j<3;j++) {
					newmission[i][j]=mission[sel[i]][j];
				}
			}
			method();
			return;
		}
		
		for(int i=0;i<K;i++) {
			if(v2[i]==false) {
				sel[k]=klist[i];
				v2[i]=true;
				recursive(sel, v2, k+1);
				v2[i]=false;
			}
		}
	}
	
	static int minsum=Integer.MAX_VALUE;

	private static void method() {
		int[][] copymap=new int[N][M];
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				copymap[i][j]=map[i][j];
			}
		}

		for(int roll=0;roll<K;roll++) {
			int r=newmission[roll][0];
			int c=newmission[roll][1];
			int s=newmission[roll][2];
			
			int t=s;
			int startx=r-s-1;
			int starty=c-s-1;
			int endx=r+s-1;
			int endy=c+s-1;
			int temp[][]=new int[2*s+1][2*s+1];
			
			for(int i=0;i<t;i++) {
				int initx=startx+i;
				int inity=starty+i;
				
				int dir=0;
				
				while(true) {
					if(dir==4) break;

					int nx=initx+dx[dir];
					int ny=inity+dy[dir];
					if(nx>endx-i||nx<startx+i||ny>endy-i||ny<starty+i) {
						dir++;
						continue;
					}
					
					temp[nx-startx][ny-starty]=copymap[initx][inity];
					initx+=dx[dir];
					inity+=dy[dir];
				}
				
			}
			temp[temp.length/2][temp.length/2]=copymap[r-1][c-1];
			for(int i=0;i<temp.length;i++) {
				for(int j=0;j<temp[0].length;j++) {
					copymap[i+startx][j+starty]=temp[i][j];
				}
			}
		}
		for(int i=0;i<N;i++) {
			int sum=0;
			for(int j=0;j<M;j++) {
				sum+=copymap[i][j];
			}
			minsum=Math.min(minsum, sum);
		}
	}
}
