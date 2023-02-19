package day0218;

import java.io.*;
import java.util.*;

public class Baek2573 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int M;
	static int[][]map;
	static boolean[][]v;
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		v=new boolean[N][M];
		for(int n=0;n<N;n++) {
			st=new StringTokenizer(br.readLine());
			for(int m=0;m<M;m++) {
				map[n][m]=Integer.parseInt(st.nextToken());
			}
		}
		int cnt=0;
		while(true) {
			
			boolean check=true;
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					if(map[n][m]!=0) {
						change(n,m);
					}
					if(map[n][m]!=0) {
						check=false;
					}
				}
			}
			if(check==true) {
				cnt=0;
				break;
			}
			cnt++;
			
			v=new boolean[N][M];
			
			int count=0;
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					if(map[n][m]!=0&&v[n][m]==false) {
						bfs(n,m);
						count++;
					}
				}
			}
		
			if(count>=2) {
				break;
			}
			v=new boolean[N][M];
		}
		
		
		bw.write(cnt+"");
		bw.close();
	}
	private static void bfs(int r, int c) {
		Queue<Point>q=new LinkedList<>();
		v[r][c]=true;
		q.offer(new Point(r, c));
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&v[nr][nc]==false&&map[nr][nc]!=0) {
					v[nr][nc]=true;
					q.add(new Point(nr, nc));
				}
			}
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
	
	private static void change(int r, int c) {
		v[r][c]=true;
		for(int d=0;d<4;d++) {
			int nr=r+dr[d];
			int nc=c+dc[d];
			if(nr>=0&&nr<N&&nc>=0&&nc<M&&map[nr][nc]==0&&v[nr][nc]==false&&map[r][c]>0) {
				map[r][c]--;
			}
		}
	}
}
