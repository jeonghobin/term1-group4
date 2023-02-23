package day0223;

import java.io.*;
import java.util.*;

public class Baek2206_2 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int M;
	static int K;
	static int[][]map;
	static boolean[][][]v;
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		v=new boolean[K+1][N][M];
		for(int i=0;i<N;i++) {
			String word=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=Character.getNumericValue(word.charAt(j));
			}
		}
		bfs(0,0);
		if(mincnt==Integer.MAX_VALUE) {
			bw.write(-1+"");
		}
		else {
			bw.write(mincnt+"");
		}
		bw.close();

	}
	static boolean flag;

	static int mincnt=Integer.MAX_VALUE;
	
	static class Point{
		int r,c,cnt,chance,day;

		public Point(int r, int c, int cnt, int chance, int day) {
			super();
			this.r = r;
			this.c = c;
			this.cnt = cnt;
			this.chance = chance;
			this.day = day;
		}
	}
	
	private static void bfs(int r, int c) {
		
		
		Queue<Point>q=new LinkedList<>();
		v[K][r][c]=true;
		q.offer(new Point(r, c, 1, K, 1));
		
		while(!q.isEmpty()) {
			Point p=q.poll();
			
			
			if(p.r==N-1&&p.c==M-1) {
				mincnt=Math.min(mincnt, p.cnt);
				
			}
			for(int d=0;d<4;d++) {
				int nr=p.r+dr[d];
				int nc=p.c+dc[d];
				if(nr>=0&&nr<N&&nc>=0&&nc<M&&v[p.chance][nr][nc]==false) {
					if(map[nr][nc]==0) {
						v[p.chance][nr][nc]=true;
						q.add(new Point(nr, nc, p.cnt+1, p.chance, p.day+1));
					}
					else if(map[nr][nc]==1) {
						if(p.chance!=0) {
							
							if(p.day%2==1) {
								v[p.chance][nr][nc]=true;
								q.add(new Point(nr, nc, p.cnt+1, p.chance-1, p.day+1));
							}
							else if(p.day%2==0){
								
								q.add(new Point(p.r, p.c, p.cnt+1, p.chance, p.day+1));
							}
						}
					}
				}
			}		
		}
	}
}
