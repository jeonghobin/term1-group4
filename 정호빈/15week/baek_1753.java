import java.util.*;
import java.io.*;

class Point implements Comparable<Point>{
	int e,c;

	public Point(int e, int c) {
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
	
	static int N,M;
	static List<Point>[] g;
	static int[] d;
	static boolean[] v;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new LinkedList[N+1];
		d = new int[N+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		v = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			g[i] = new LinkedList<Point>();
		}
		int start = Integer.parseInt(br.readLine());
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g[a].add(new Point(b,c));
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>();
		pq.add(new Point(start,0));
		d[start] = 0;
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(v[p.e])continue;
			v[p.e]=true;
			for(Point next: g[p.e]) {
				if(!v[next.e]&&d[next.e]>d[p.e]+next.c) {
					d[next.e] = d[p.e]+next.c;
					pq.add(new Point(next.e,d[next.e]));
				}
			}
		}
		
		for(int i=1;i<=N;i++) {
			if(d[i]==Integer.MAX_VALUE)
				System.out.println("INF");
			else
				System.out.println(d[i]);
		}
	}

}
