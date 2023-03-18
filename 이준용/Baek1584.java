package day0314;

import java.io.*;
import java.util.*;

public class Baek1584 {
	static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	
	static class Point implements Comparable<Point>{
		int e,w;

		public Point(int e, int w) {
			super();
			this.e = e;
			this.w = w;
		}

		@Override
		public int compareTo(Point o) {
			// TODO Auto-generated method stub
			return this.w-o.w;
		}
	}
	
	static int[][]map=new int[501][501];
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	
	static ArrayList<Point>[]array=new ArrayList[501*501];
	static int[]dist=new int[501*501];

	public static void main(String[] args) throws IOException {
		int N=Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int sr=Integer.parseInt(st.nextToken());
			int sc=Integer.parseInt(st.nextToken());
			int er=Integer.parseInt(st.nextToken());
			int ec=Integer.parseInt(st.nextToken());
			for(int r=Math.min(sr, er);r<=Math.max(sr, er);r++) {
				for(int c=Math.min(sc, ec);c<=Math.max(sc, ec);c++) {
					map[r][c]=1;
				}
			}
		}
		
		int M=Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int sr=Integer.parseInt(st.nextToken());
			int sc=Integer.parseInt(st.nextToken());
			int er=Integer.parseInt(st.nextToken());
			int ec=Integer.parseInt(st.nextToken());
			for(int r=Math.min(sr, er);r<=Math.max(sr, er);r++) {
				for(int c=Math.min(sc, ec);c<=Math.max(sc, ec);c++) {
					map[r][c]=-1;
				}
			}
		}
		
		for(int i=0;i<501*501;i++) {
			array[i]=new ArrayList<>();
		}
		
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		for(int i=0;i<501;i++) {
			for(int j=0;j<501;j++) {
				for(int d=0;d<4;d++) {
					int nr=i+dr[d];
					int nc=j+dc[d];
					if(nr>=0&&nr<501&&nc>=0&&nc<501) {
						if(map[nr][nc]==0) {
							array[i*501+j].add(new Point(nr*501+nc, 0));
						}
						else if(map[nr][nc]==1) {
							array[i*501+j].add(new Point(nr*501+nc, 1));
						}
					}
				}
			}
		}
		
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		dist[0]=0;
		q.add(new Point(0, 0));
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(dist[p.e]<p.w) continue;
			
			for(Point np:array[p.e]) {
				int nw=dist[p.e]+np.w;
				if(nw<dist[np.e]) {
					dist[np.e]=nw;
					q.add(new Point(np.e, nw));
				}
			}
		}
		
		int ans=dist[501*501-1];
		if(ans==Integer.MAX_VALUE) ans=-1;
		bw.write(ans+"");
		bw.close();
	}
}
