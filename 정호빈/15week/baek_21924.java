import java.io.*;
import java.util.*;
class Point{
		int s,e,c;

		public Point(int s, int e, int c) {
			super();
			this.s = s;
			this.e = e;
			this.c = c;
		}
		
	}
public class Main {
	
	
	static int N,M;
	static List<Point> g = new ArrayList<>();
	static int[] p;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		p = new int[N+1];
		for(int i=1;i<=N;i++) {
			p[i]=i;
		}
		M = Integer.parseInt(st.nextToken());
		long maxsum=0;
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			g.add(new Point(a,b,c));
			maxsum+=c;
		}
		Collections.sort(g,new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				return o1.c-o2.c;
			}
		});
		long sum=0;
		for(Point j: g) {
			if(find(j.s)!=find(j.e)) {
				sum+=j.c;
				union(j.s,j.e);
			}
		}
		for(int i=1;i<=N;i++) {
			find(i);
		}
		int a=p[1],flag=0;
		for(int i=2;i<=N;i++) {
			if(a!=p[i]) {
				flag=1;
				break;
			}
		}
		if(flag==1)
			System.out.println(-1);
		else
			System.out.println(maxsum-sum);
		
		
	}
	
	private static void union(int s, int e) {
		int ps = find(s);
		int pe = find(e);
		if(ps!=pe) {
			p[ps]=pe;
		}
	}

	public static int find(int node) {
		if(p[node]==node)return node;
		return p[node]=find(p[node]);
	}
	

	
	
	
	
	

}
