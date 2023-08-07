import java.util.*;
import java.io.*;

class Point{
	int e,c;

	public Point(int e, int c) {
		this.e = e;
		this.c = c;
	}
	
}


public class Main {

	static List<Point>[] g;
	static int N,M,cnt;
	static int[] d;
	static boolean[] v;
	
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new ArrayList[N+1];
		d = new int[N+1];
		v = new boolean[N+1];
		for(int i=1;i<=N;i++) {
			g[i] = new ArrayList<Point>();
			d[i] = Integer.MAX_VALUE;
		}
		d[1] = 0;
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g[a].add(new Point(b,c));
			g[b].add(new Point(a,c));
			
		}
		
		PriorityQueue<Point> pq = new PriorityQueue<Point>(new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				return o1.c-o2.c;
			}
		});
		
		pq.add(new Point(1,0));
		while(!pq.isEmpty()) {
			Point p = pq.poll();
			if(v[p.e]) continue;
			v[p.e] = true;
			
			for(Point nxt : g[p.e]) {
				if(!v[nxt.e]&&d[nxt.e]>d[p.e]+nxt.c) {
					d[nxt.e] = d[p.e]+nxt.c;
					pq.add(new Point(nxt.e,d[nxt.e]));
				}
			}
		}
		System.out.println(d[N]);
		
	}

	

}
