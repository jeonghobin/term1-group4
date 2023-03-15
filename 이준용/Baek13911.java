package day0314;

import java.io.*;
import java.util.*;

public class Baek13911 {
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
	
	static int V,E;
	static int M,x;
	static int S,y;
	
	static ArrayList<Integer>marray=new ArrayList<Integer>();
	static ArrayList<Integer>sarray=new ArrayList<Integer>();

	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		V=Integer.parseInt(st.nextToken());
		E=Integer.parseInt(st.nextToken());
		
		array=new ArrayList[V];
		for(int i=0;i<V;i++) {
			array[i]=new ArrayList<>();
		}
		
		dist=new int[V];
		
		
		for(int i=0;i<E;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			
			array[s].add(new Point(e, w));
			array[e].add(new Point(s, w));
		}
		//맥도날드 노드 번호 어레이리스트로
		st=new StringTokenizer(br.readLine());
		M=Integer.parseInt(st.nextToken());
		x=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++) {
			marray.add(Integer.parseInt(st.nextToken())-1);
		}
		
		//스벅 노드 번호 어레이리스트로
		st=new StringTokenizer(br.readLine());
		S=Integer.parseInt(st.nextToken());
		y=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<S;i++) {
			sarray.add(Integer.parseInt(st.nextToken())-1);
		}
		
		
		//모든 집에서 다익스트라
		int mindist=Integer.MAX_VALUE;
		int minnode=-1;
		PriorityQueue<Point>q=new PriorityQueue<>();
		for(int v=0;v<V;v++) {
			if(marray.contains(v)||sarray.contains(v)) continue;
			
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[v]=0;
			q.add(new Point(v, 0));
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
			
			int mmin=Integer.MAX_VALUE;
			int smin=Integer.MAX_VALUE;
			
			for(int i=0;i<V;i++) {
				if(marray.contains(i)) {
					mmin=Math.min(mmin, dist[i]);
				}
				if(sarray.contains(i)) {
					smin=Math.min(smin, dist[i]);
				}
			}
			
			if(mmin<=x&&smin<=y) {
				if(mindist>mmin+smin) {
					mindist=mmin+smin;
					minnode=v;
				}
			}
		}
		
		if(minnode==-1) {
			mindist=-1;
		}
		bw.write(mindist+"");
		bw.close();
	}
}
