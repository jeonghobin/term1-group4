package baek;

import java.io.*;
import java.util.*;

public class Baek1800 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
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
	
	static int N,M,K;
	static ArrayList<Point>[]array;
	static int[]dist;
	static int[]back;
	static Stack<Integer> stack=new Stack<Integer>();
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		array=new ArrayList[N];
		back=new int[N];
		
		for(int i=0;i<N;i++) {
			array[i]=new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			array[s].add(new Point(e, w));
			array[e].add(new Point(s, w));
		}
		
		dist=new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
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
					back[np.e]=p.e;
				}
			}
		}
		System.out.println(Arrays.toString(dist));
	}

}
