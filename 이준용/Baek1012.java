package day0214;

import java.io.*;
import java.util.*;

public class Baek1012 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static int K;
	static int[][] map;
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			M=Integer.parseInt(st.nextToken());
			N=Integer.parseInt(st.nextToken());
			K=Integer.parseInt(st.nextToken());
			
			map = new int[N][M];
			for(int i=0;i<K;i++) {
				st=new StringTokenizer(br.readLine());
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st.nextToken());
				map[y][x]=1;
			}
			int count=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(map[i][j]==1) {
						count++;
						bfs(i,j);
					}
				}
			}
			bw.write(count+"\n");
		}
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

	private static void bfs(int i, int j) {
		Queue<Point> q=new LinkedList<Point>();
		boolean[][]v=new boolean[N][M];
		
		v[i][j]=true;
		q.offer(new Point(i,j));
		
		while(!q.isEmpty()) {
			Point p= q.poll();
			map[p.r][p.c]=0;
			
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&v[nr][nc]==false&&map[nr][nc]==1) {
					v[nr][nc]=true;
					q.add(new Point(nr,nc));
				}
			}
		}
	}
}
