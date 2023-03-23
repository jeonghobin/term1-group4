package baek;

import java.io.*;
import java.util.*;

public class BAEK11779 {
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
			return this.w-o.w;
		}
	}
	
	static int N,M;
	static int S,E;
	static ArrayList<Point>[] array;
	static int[]dist;
	
	static int[]route;
	static int cnt;
	
	public static void main(String[] args) throws IOException {
		N=Integer.parseInt(br.readLine());
		M=Integer.parseInt(br.readLine());
		array=new ArrayList[N];
		for(int i=0;i<N;i++) {
			array[i]=new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int s=Integer.parseInt(st.nextToken())-1;
			int e=Integer.parseInt(st.nextToken())-1;
			int w=Integer.parseInt(st.nextToken());
			array[s].add(new Point(e, w));
		}
		
		st=new StringTokenizer(br.readLine());
		S=Integer.parseInt(st.nextToken())-1;
		E=Integer.parseInt(st.nextToken())-1;
		
		PriorityQueue<Point>q=new PriorityQueue<>();
		route=new int[N];
		dist=new int[N];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[S]=0;
		q.add(new Point(S, 0));
		while(!q.isEmpty()) {
			Point p=q.poll();
			if(dist[p.e]<p.w) continue;
			
			for(Point np:array[p.e]) {
				int nw=dist[p.e]+np.w;
				if(nw<dist[np.e]) {
					dist[np.e]=nw;
					q.add(new Point(np.e, nw));
					route[np.e]=p.e;
				}
			}
		}
		
		bw.write(dist[E]+"\n");
		
		
		Stack<Integer>stack=new Stack<Integer>();
		int cur=E;
		while(cur!=S) {
			stack.push(cur);
			cnt++;
			cur=route[cur];
		}
		stack.push(cur);
		cnt++;
		bw.write(cnt+"\n");
		
		for(int i=0;i<cnt;i++) {
			bw.write(stack.pop()+1+" ");
		}
		bw.close();
	}
}
