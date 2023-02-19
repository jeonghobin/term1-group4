package day0218;

import java.io.*;
import java.util.*;

public class Baek2146 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N;
	static int[][]map;
	static boolean[][]v;
	static int changecnt=1;
	static int[] dr= {1,-1,0,0};
	static int[] dc= {0,0,1,-1};
	static int search=1;
	
	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		map=new int[N][N];
		v=new boolean[N][N];
		
		//맵 그리기
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
			}
		}

		// 대륙별 숫자 부여
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]!=0&&v[i][j]==false) {
					change(i,j);
					changecnt++;
				}
			}
		}
		

		//다른 대륙 탐색
		v=new boolean[N][N];
		while(search<changecnt-1) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==search&&v[i][j]==false) {
						
						bfs(i,j);
						v=new boolean[N][N];
					}
				}
			}
			search++;
		}

		bw.write(mincnt+"");
		bw.close();

	}
	static int mincnt=Integer.MAX_VALUE;
	
	private static void bfs(int r, int c) {
		Queue<Point> q=new LinkedList<>();
		v[r][c]=true;
		q.offer(new Point(r, c, 0));
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&map[nr][nc]!=search&&v[nr][nc]==false) {
					if(map[nr][nc]!=0&&map[nr][nc]!=search) {
						mincnt=Math.min(mincnt, p.cnt);
					}
					v[nr][nc]=true;
					q.add(new Point(nr, nc, p.cnt+1));
				}
			}
		}
		
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

	private static void change(int r, int c) {
		Queue<Point> q=new LinkedList<>();
		v[r][c]=true;
		q.offer(new Point(r, c,0));
		while(!q.isEmpty()) {
			Point p=q.poll();
			map[r][c]=changecnt;
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<N&&v[nr][nc]==false&&map[nr][nc]!=0) {
					v[nr][nc]=true;
					map[nr][nc]=changecnt;
					q.add(new Point(nr, nc,0));
				}
			}
		}
		
	}
}
