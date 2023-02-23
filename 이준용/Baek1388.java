package day0223;

import java.io.*;
import java.util.*;

public class Baek1388 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int M;
	static char[][]map;
	static boolean[][]v;
	static int[]dr= {1,-1};
	static int[]dc= {1,-1};

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new char[N][M];
		v=new boolean[N][M];
		for(int i=0;i<N;i++) {
			String word=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=word.charAt(j);
			}
		}
		
		int cnt=0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(v[i][j]==false) {
					bfs(i,j,map[i][j]);
					cnt++;
				}
			}
		}

		System.out.println(cnt);
	}
	
	static class Point{
		int r,c;

		public Point(int r, int c) {
			super();
			this.r = r;
			this.c = c;
		}
	}

	private static void bfs(int r, int c, char type) {
		Queue<Point>q=new LinkedList<>();
		v[r][c]=true;
		q.offer(new Point(r, c));
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<2;d++) {
				int nr=0;
				int nc=0;
				if(type=='-') {
					nr=p.r;
					nc=p.c+dc[d];
				}
				else {
					nr=p.r+dr[d];
					nc=p.c;
				}
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&v[nr][nc]==false&&map[nr][nc]==type) {
					v[nr][nc]=true;
					q.add(new Point(nr, nc));
				}
			}
		}
		
	}

}
