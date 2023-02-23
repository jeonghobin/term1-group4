package day0223;
import java.io.*;
import java.util.*;

public class Baek1697 {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static int N;
	static int K;
	static boolean[]v;
	static int[] dx= {-1,1};
	
	public static void main(String[] args) throws IOException {
		st=new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		v=new boolean[100050];
		
		bfs(N);
		
		System.out.println(mincnt);

	}
	static class Point{
		int x,cnt;

		public Point(int x, int cnt) {
			super();
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int mincnt;

	private static void bfs(int x) {
		Queue<Point> q=new LinkedList<>();
		v[x]=true;
		q.offer(new Point(x, 0));
		while(!q.isEmpty()) {
			Point p=q.poll();
			for(int i=0;i<2;i++) {
				if(i==0) {
					for(int d=0;d<2;d++) {
						int nx=p.x+dx[d];
						if(nx>=0&&nx<100050&&v[nx]==false) {
							if(nx==K) {
								mincnt=p.cnt+1;
								return;
							}
							v[nx]=true;
							q.add(new Point(nx, p.cnt+1));
						}
					}
				}
				else {
					int nx=p.x*2;
					if(nx>=0&&nx<100050&&v[nx]==false) {
						if(nx==K) {
							mincnt=p.cnt+1;
							return;
						}
						v[nx]=true;
						q.add(new Point(nx, p.cnt+1));
					}
				}
			}
		}	
	}
}