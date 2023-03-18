package day0314;

import java.io.*;
import java.util.*;

public class Baek1504 {
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
	
	static int V,E;
	static ArrayList<Point>[]array;
	static int[]dist;

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		array=new ArrayList[V];
		for(int i=0;i<V;i++) {
			array[i]=new ArrayList<>();
		}
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			array[s].add(new Point(e, w));
			array[e].add(new Point(s, w));
		}
		
		st=new StringTokenizer(br.readLine());
		int n1=Integer.parseInt(st.nextToken())-1;
		int n2=Integer.parseInt(st.nextToken())-1;
		int[][]node = {{0,n1,n2,V-1 },{0,n2,n1,V-1 }};
		
		dist=new int[V];
		PriorityQueue<Point>q=new PriorityQueue<>();
		
		
		int mindist=Integer.MAX_VALUE;
		L:for(int d=0;d<2;d++) {
			int sum=0;
			for(int n=0;n<3;n++) {
				Arrays.fill(dist, Integer.MAX_VALUE);
				int s=node[d][n];
				int e=node[d][n+1];
				
				dist[s]=0;
				q.add(new Point(s, 0));
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
				if(dist[e]==Integer.MAX_VALUE) continue L;
				sum+=dist[e];
			}
			mindist=Math.min(mindist, sum);
		}
		
		if(mindist==Integer.MAX_VALUE) mindist=-1;
		System.out.println(mindist);
	}
}
