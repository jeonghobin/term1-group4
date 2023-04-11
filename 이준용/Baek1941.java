package day0405;

import java.io.*;
import java.util.*;

public class Baek1941 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static char[][]map=new char[5][5];
	static int[][]check=new int[5][5];
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		for(int i=0;i<5;i++) {
			String word=br.readLine();
			for(int j=0;j<5;j++) {
				map[i][j]=word.charAt(j);
			}
		}
		
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(map[i][j]=='Y') {
					dfs(i,j,1,0);
				}
				else {
					dfs(i,j,1,1);
				}
				
			}
		}
		System.out.println(ans);
		
	}
	
	static int ans;

	private static void dfs(int r, int c, int cnt, int dasom) {
		if(cnt==7) {
			if(dasom>=4) ans++;
			return;
		}
		
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr>=0&&nr<5&&nc>=0&&nc<5) {
				if(map[nr][nc]=='Y') {
					if(cnt-dasom>=3) continue;
					dfs(nr,nc,cnt+1,dasom);
				}
				else {
					dfs(nr,nc,cnt+1,dasom+1);
				}
			}
		}
	}
}
