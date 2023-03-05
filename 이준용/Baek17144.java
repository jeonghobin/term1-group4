package day0304;

import java.io.*;
import java.util.*;

public class Baek17144 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int R,C,T;
	static int[][]map;
	static boolean[][]v;
	static int[]dr= {0,-1,0,1};
	static int[]dc= {1,0,-1,0};
	static int[]dr2= {0,1,0,-1};
	static int[]dc2= {1,0,-1,0};
	
	static int cleanstart;
	
	static class Point{
		int r,c,size;

		public Point(int r, int c, int size) {
			super();
			this.r = r;
			this.c = c;
			this.size = size;
		}
	}

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		R=Integer.parseInt(st.nextToken());
		C=Integer.parseInt(st.nextToken());
		T=Integer.parseInt(st.nextToken());
		map=new int[R][C];
		v=new boolean[R][C];
		for(int i=0;i<R;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j]=Integer.parseInt(st.nextToken());
				if(map[i][j]==-1) cleanstart=i;
			}
		}
		
		for(int t=0;t<T;t++) {
			spray();
			clean();
		}
		int sum=0;
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>0) {
					sum+=map[i][j];
				}
			}
		}
		System.out.println(sum);

	}
	
	private static void clean() {
		int[][]map2=new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map2[i][j]=map[i][j];
			}
		}
		
		
		int cleanstart1=cleanstart-1;
		int cleanstart2=cleanstart;
		
		int d1=0;
		int sr=cleanstart1;
		int sc=0;
		while(true) {
			if(d1==4) break;
			int nr=sr+dr[d1];
			int nc=sc+dc[d1];
			
			if(nr<0||nr>cleanstart1||nc<0||nc>=C) {
				d1++;
				continue;
			}
			if(map[sr][sc]==-1) {
				map[nr][nc]=0;
			}
			else {
				if(map[nr][nc]==-1) {
					map2[sr][sc]=0;
				}
				else {
					map[nr][nc]=map2[sr][sc];
				}
			}
			sr+=dr[d1];
			sc+=dc[d1];
		}
		
		int d2=0;
		int sr2=cleanstart2;
		int sc2=0;
		while(true) {
			if(d2==4) break;
			int nr=sr2+dr2[d2];
			int nc=sc2+dc2[d2];
			
			if(nr>=R||nr<cleanstart2||nc<0||nc>=C) {
				d2++;
				continue;
			}
			if(map[sr2][sc2]==-1) {
				map[nr][nc]=0;
			}
			else {
				if(map[nr][nc]==-1) {
					map2[sr2][sc2]=0;
				}
				else {
					map[nr][nc]=map2[sr2][sc2];
				}
			}
			sr2+=dr2[d2];
			sc2+=dc2[d2];
		}
	}

	private static void spray() {
		Queue<Point>q=new LinkedList<>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j]>=5) {
					q.offer(new Point(i, j, map[i][j]));
				}
			}
		}
		while(!q.isEmpty()) {
			Point p=q.poll();
			int mini=p.size/5;
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<R&&nc>=0&&nc<C&&map[nr][nc]!=-1) {
					map[nr][nc]+=mini;
					map[p.r][p.c]-=mini;
				}
			}
		}
	}
}
