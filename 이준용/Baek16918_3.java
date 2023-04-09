package day0406;

import java.io.*;
import java.util.*;

public class Baek16918_3 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int R,C,N;
	static int[][]map;
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	
	static class Point{
		int r,c;
		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		int N2=Integer.parseInt(st.nextToken());
		N=N2%4+4;
		map=new int[R][C];
		for(int i=0;i<R;i++) {
			String word=br.readLine();
			for(int j=0;j<C;j++) {
				if(word.charAt(j)=='O') {
					map[i][j]=3;
				}
				else {
					map[i][j]=-1;
				}
			}
		}
		
		if(N2!=1) {
			for(int t=1;t<=N;t++) {
				for(int i=0;i<R;i++) {
					for(int j=0;j<C;j++) {
						if(map[i][j]!=-1) {
							map[i][j]--;
						}
					}
				}
				
				if(t%2==0) {
					for(int i=0;i<R;i++) {
						for(int j=0;j<C;j++) {
							if(map[i][j]==-1) {
								map[i][j]=3;
							}
						}
					}
				}
				bfs(t);
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) {
					bw.write('O');
				}
				else {
					bw.write('.');
				}
			}
			bw.write("\n");
		}
		bw.close();
	}

	private static void bfs(int t) {
		Queue<Point>q=new LinkedList<>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]==0) {
					q.add(new Point(i, j));
				}
			}
		}
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<R&&nc>=0&&nc<C) {
					map[nr][nc]=-1;
				}
			}
		}
	}
}