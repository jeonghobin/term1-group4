package day0302;

import java.io.*;
import java.util.*;

public class Baek1916 {
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
			return Integer.compare(this.w, o.w);
		}
	}
	
	static int V,E;
	static ArrayList<Point>[]array;
	static int[]dist;
	static int A,B;
	

	public static void main(String[] args) throws IOException {
		V=Integer.parseInt(br.readLine());
		E=Integer.parseInt(br.readLine());
		array=new ArrayList[V];
		dist=new int[V];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0;i<V;i++) {
			array[i]=new ArrayList<>();
		}
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			array[s].add(new Point(e, w));
		}
		
		st=new StringTokenizer(br.readLine());
		A=Integer.parseInt(st.nextToken())-1;
		B=Integer.parseInt(st.nextToken())-1;
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		dist[A]=0;
		q.add(new Point(A, 0));
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(dist[p.e]<p.w)continue;
			
			for(Point np:array[p.e]) {
				int nw=np.w+dist[p.e];
				if(dist[np.e]>nw) {
					dist[np.e]=nw;
					q.add(new Point(np.e, nw));
				}
			}
		}
		bw.write(dist[B]+"");
		bw.close();
	}
}
