package day0314;

import java.io.*;
import java.util.*;

public class Baek1261 {

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
	static ArrayList<Point>[]array;
	static int[]dist;
	
	static int[][]map;
	static int[]dr= {1,-1,0,0};
	static int[]dc= {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		
		int M=Integer.parseInt(st.nextToken());
		int N=Integer.parseInt(st.nextToken());
		map=new int[N][M];
		for(int i=0;i<N;i++) {
			String word=br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j]=Character.getNumericValue(word.charAt(j));
			}
		}
		
		array=new ArrayList[N*M];
		for(int i=0;i<N*M;i++) {
			array[i]=new ArrayList<>();
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				for(int d=0;d<4;d++) {
					int nr=i+dr[d];
					int nc=j+dc[d];
					if(nr>=0&&nr<N&&nc>=0&&nc<M) {
						if(map[nr][nc]==0) {
							array[i*M+j].add(new Point(nr*M+nc, 0));
						}
						else {
							array[i*M+j].add(new Point(nr*M+nc, 1));
						}
					}
				}
			}
		}
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		dist=new int[N*M];
		Arrays.fill(dist, Integer.MAX_VALUE);
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
		
		System.out.println(dist[N*M-1]);
		
	}

}
