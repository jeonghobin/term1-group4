import java.io.*;
import java.util.*;


class Point{
	int e,c;

	public Point( int e, int c) {
		super();
		this.e = e;
		this.c = c;
	}
	
}

public class Main {
	
	static int N,M,s,e,rs,max=Integer.MIN_VALUE,min=Integer.MAX_VALUE;
	static List<Point>[] g;
	static boolean[] v;
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		g = new LinkedList[N+1];
		for(int i=1;i<=N;i++) {
			g[i] = new LinkedList<Point>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			max = Math.max(max, c);
			min = Math.min(min, c);	
			g[a].add(new Point(b,c));
			g[b].add(new Point(a,c));
		}
		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken());
		e = Integer.parseInt(st.nextToken());
		while(min<=max) {
			int mid = (max+min)/2;
			v = new boolean[N+1];
			if(bfs(mid)) {
				min = mid+1;
				rs = mid;
			}else {
				max = mid-1;
			}
		}
		System.out.println(rs);
		
	}
	private static boolean bfs(int mid) {
		// TODO Auto-generated method stub
		Queue<Integer> que = new LinkedList<>();
		que.add(s);
		v[s] = true;
		while(!que.isEmpty()) {
			int temp = que.poll();
			if(temp == e)return true;
			for(Point next : g[temp]) {
				if(!v[next.e]&&next.c>=mid) {
					v[next.e] = true;
					que.add(next.e);
				}
			}
		}
		return false;
	}
	

 	

}
