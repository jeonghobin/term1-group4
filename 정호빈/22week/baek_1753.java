import java.io.*;
import java.util.*;


class Point implements Comparable<Point>{
	int e,c;

	public Point( int e, int c) {
		super();
		this.e = e;
		this.c = c;
	}
	
	@Override
	public int compareTo(Point o) {
		// TODO Auto-generated method stub
		return this.c-o.c;
	}
	
}

public class Main {
	
	static int V,E,K;
	static List<Point>[] g;
	static int[] d;
	static boolean[] v;
 	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());
		g = new LinkedList[V+1];
		d = new int[V+1];
		v = new boolean[V+1];
		for(int i=0;i<=V;i++) {
			g[i] = new LinkedList<Point>();
			d[i] = Integer.MAX_VALUE;
		}
		for(int i=0;i<E;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g[a].add(new Point(b,c));
		}
		PriorityQueue<Point> pq = new PriorityQueue<>();
		d[K] = 0;
		pq.add(new Point(K,0));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(v[p.e])continue;
			v[p.e] =true;
			for(Point next : g[p.e]) {
				if(!v[next.e]&&d[next.e]>d[p.e]+next.c) {
					d[next.e] = d[p.e] + next.c;
					pq.add(new Point(next.e,d[next.e]));
				}
			}
		}
		for(int i=1;i<=V;i++) {
			if(d[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(d[i]);
		}
		
		
	}
	

}
