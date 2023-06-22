import java.io.*;
import java.util.*;


class Point{
	int s,e;
	double c;

	public Point(int s, int e, double c) {
		super();
		this.s = s;
		this.e = e;
		this.c = c;
	}

	
	
}

public class Main {
	
	static int N;
	static double sum;
	static List<Point> g;
	static int[] par;
	static double[][] xy;
	
  	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		N= Integer.parseInt(br.readLine());
		g = new LinkedList<Point>();
		xy = new double[N+1][2];
		par = new int[N+1];
		for(int i=1;i<=N;i++) {
			par[i]=i;
		}
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			xy[i][0] = Double.parseDouble(st.nextToken());
			xy[i][1] = Double.parseDouble(st.nextToken());
		}
		for(int i=1;i<=N-1;i++) {
			for(int j=i+1;j<=N;j++) {
				double ax = xy[i][0];
				double ay = xy[i][1];
				double bx = xy[j][0];
				double by = xy[j][1];
				double c = Math.sqrt(Math.pow(ax-bx,2)+Math.pow(ay-by,2));
				g.add(new Point(i,j,c));
			}
		}
		Collections.sort(g,new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				// TODO Auto-generated method stub
				if(o1.c>o2.c)return 1;
				else if(o1.c==o2.c)return 0;
				else return -1;
			}
		});
		
		for(Point p : g) {
			int a = p.s;
			int b = p.e;
			if(find(a)!=find(b)) {
				union(a,b);
				sum+=p.c;
			}
		}
		System.out.printf("%.2f", sum);
	}


	private static void union(int a, int b) {
		// TODO Auto-generated method stub
		int pa = find(a);
		int pb = find(b);
		
		par[pa] = pb;
	}


	private static int find(int a) {
		// TODO Auto-generated method stub
		if(par[a]==a)return a;
		return par[a] = find(par[a]);
	}
	
	

 	

}
