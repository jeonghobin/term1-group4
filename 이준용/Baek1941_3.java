package day0405;

import java.io.*;
import java.util.*;

public class Baek1941_3 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;

	static char[][]map=new char[5][5];
	static int[][]map2;
	static boolean[][]v;
	static int[]num=new int[25];
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1,};

	public static void main(String[] args) throws IOException {
		for(int i=0;i<5;i++) {
			String word=br.readLine();
			for(int j=0;j<5;j++) {
				map[i][j]=word.charAt(j);
				num[i*5+j]=i*5+j;
			}
		}
		
		recursive(new int[7], 0, 0);
		System.out.println(ans);
	}
	
	static int ans;

	private static void recursive(int[] sel, int idx, int k) {
		if(k==7) {
			v=new boolean[5][5];
			map2=new int[5][5];
			for(int i=0;i<7;i++) {
				int r=sel[i]/5;
				int c=sel[i]%5;
				map2[r][c]=1;
			}
			int scnt=0;
			int bfscnt=0;
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(map2[i][j]==1&&!v[i][j]) {
						if(bfscnt>=1) return;
						scnt=bfs(i,j);
						bfscnt++;
					}
				}
			}
			if(bfscnt==1&&scnt>=4) {
				ans++;
			}

			return;
		}
		if(idx==25) return;
		
		for(int i=idx;i<num.length;i++) {
			sel[k]=num[i];
			recursive(sel, i+1, k+1);
		}
	}
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static int bfs(int r, int c) {
		int scnt=0;
		Queue<Point>q=new LinkedList<>();
		v[r][c]=true;
		q.add(new Point(r, c));
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(map[p.r][p.c]=='S') {
				scnt++;
			}
			
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<5&&nc>=0&&nc<5&&!v[nr][nc]&&map2[nr][nc]==1) {
					v[nr][nc]=true;
					q.add(new Point(nr, nc));
				}
			}
		}
		return scnt;
	}
}
