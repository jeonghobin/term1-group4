package day0302;

import java.io.*;
import java.util.*;

public class Swea5656 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static int N,R,C;
	static int[][]map;
	static int[][]map2;
	static int[]list;
	
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	
	static class Point{
		int r,c,cnt;

		public Point(int r, int c, int cnt) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	public static void main(String[] args) throws IOException {
		int T=Integer.parseInt(br.readLine());
		for(int t=1;t<=T;t++) {
			st=new StringTokenizer(br.readLine());
			N=Integer.parseInt(st.nextToken());
			C=Integer.parseInt(st.nextToken());
			R=Integer.parseInt(st.nextToken());
			
			map=new int[R][C];
			map2=new int[R][C];
			for(int i=0;i<R;i++) {
				st=new StringTokenizer(br.readLine());
				for(int j=0;j<C;j++) {
					map[i][j]=Integer.parseInt(st.nextToken());
				}
			}
			list=new int[C];
			for(int i=0;i<C;i++) {
				list[i]=i;
			}

			recursive(new int[N],0,0);
			
			System.out.println("#"+t+" "+mincnt);
			mincnt=Integer.MAX_VALUE;
		}

	}
	
	static int mincnt=Integer.MAX_VALUE;

	private static void recursive(int[] sel, int idx, int k) {
		if(k==N) {
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					map2[i][j]=map[i][j];
				}
			}
			for(int i=0;i<N;i++) {
				System.out.println(Arrays.toString(sel));
				bfs(sel[i]);
			}
			int cnt=0;
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					if(map2[i][j]!=0) {
						cnt++;
					}
				}
			}
			mincnt=Math.min(mincnt, cnt);
			
			
			return;
		}
		if(idx==C) return;
		
		for(int i=idx;i<C;i++) {
			sel[k]=list[i];
			recursive(sel, i, k+1);
		}
	}

	private static void bfs(int c) {
		Queue<Point>q=new LinkedList<>();
		for(int r=0;r<R;r++) {
			if(map2[r][c]!=0) {
				q.offer(new Point(r, c, map2[r][c]));
				break;
			}
		}
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			map2[p.r][p.c]=0;
			
			for(int cnt=0;cnt<p.cnt;cnt++) {
				for(int d=0;d<4;d++) {
					int nr=p.r+cnt*dr[d];
					int nc=p.c+cnt*dc[d];
					if(nr>=0&&nr<R&&nc>=0&&nc<C) {
						if(map2[nr][nc]!=0) {
							q.add(new Point(nr, nc, map2[nr][nc]));
						}
					}
				}
			}
		}
		int[][]map3=new int[R][C];
		for(int i=0;i<C;i++) {
			int index=R-1;
			for(int j=R-1;j>=0;j--) {
				if(map2[j][i]!=0) {
					map3[index--][i]=map2[j][i];
				}
			}
		}
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map2[i][j]=map3[i][j];
				System.out.print(map2[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}
