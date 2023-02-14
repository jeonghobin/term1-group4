package day0214;

import java.io.*;
import java.util.*;

public class Baek7576 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int[][]map;
	
	public static void main(String[] args) throws IOException {
		StringTokenizer st=new StringTokenizer( br.readLine());
		M=Integer.parseInt(st.nextToken());
		N=Integer.parseInt(st.nextToken());
		
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==0) {
					bw.write("-1");
					bw.close();
					System.exit(0);
				}
			}
		}
		bw.write(max+"");
		bw.close();
	}
	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static int max=0;

	private static void bfs() {
		Queue<Point> q = new LinkedList();
		boolean[][]v=new boolean[N][M];
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==1) {
					q.offer(new Point(r,c,0));
					v[r][c]=true;
				}
			}
		}
		
		while(!q.isEmpty()) {
			int size=q.size();
			for(int i=0;i<size;i++) {
				Point p = q.poll();
				//map[p.r][p.c]=0;
				
				for(int d=0;d<4;d++) {
					int nr=p.r+dr[d];
					int nc=p.c+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<M&&v[nr][nc]==false&&map[nr][nc]==0) {
						v[nr][nc]=true;
						map[nr][nc]=1;
						q.add(new Point(nr,nc,p.cnt+1));
						max=Math.max(max, p.cnt+1);
					}
				}
				
			}
		}
		
	}

}
