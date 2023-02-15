package day0215;

import java.io.*;
import java.util.*;

public class Swea1861 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int n;
	static int[][]map;
	static boolean[][]v;
	
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			n=Integer.parseInt(br.readLine());
			map=new int[n][n];
			v=new boolean[n][n];
			for(int i=0;i<n;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<n;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			int maxcnt=0;
			int minnum=10000;
			for(int i=0;i<n;i++) {
				for(int j=0;j<n;j++) {
					dfs(i,j,1);
					
					if(maxcnt<cnt) {
						maxcnt=cnt;
						minnum=map[i][j];
					}
					else if(maxcnt==cnt) {
						minnum=Math.min(minnum, map[i][j]);
					}
					cnt=1;
				}
			}
			bw.write("#"+t+" "+minnum+" "+maxcnt+"\n");
		}
		bw.close();
	}

	static int cnt=1;
	
	public static void dfs(int x, int y,int depth) {
		cnt=Math.max(cnt, depth);
	      for (int i = 0; i < 4; i++) {
	          int nx = x + dr[i];
	          int ny = y + dc[i];
	          if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
	              if (!v[nx][ny]&&map[x][y]+1==map[nx][ny]) {
	            	  v[nx][ny]=true;

	                  dfs(nx, ny, depth + 1);
	                  v[nx][ny]=false;
	              }
	          }
	      }
	      return;
	  }

}
